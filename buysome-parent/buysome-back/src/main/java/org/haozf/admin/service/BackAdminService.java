package org.haozf.admin.service;

import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

import org.haozf.admin.mapper.BackAdminMapper;
import org.haozf.mybatis.mapper.AdminMapper;
import org.haozf.mybatis.mapper.ShopMapper;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.model.AdminExample;
import org.haozf.mybatis.model.AdminExample.Criteria;
import org.haozf.mybatis.service.AdminService;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackAdminService extends AdminService{
    
    @Autowired
    SecurityManager<Realm> securityManager;
    
    @Autowired
    AdminMapper adminMapper;
    
    @Autowired
    BackAdminMapper backAdminMapper;
    
    @Autowired
    ShopMapper shopMapper;
    
    public List<Admin> listAdmin(Admin admin){
        
        Realm subject = securityManager.getSubject();
        Admin sAdmin = (Admin)subject.getMember();
        
        AdminExample example = new AdminExample();
        
        //超级管理员显示所有  
        //管理员查询当前管理员和用户
        //用户查询用户
        if(sAdmin.getRoleid()==0){
            example.or().andIsdeleteEqualTo(0);
        }else if (sAdmin.getRoleid()==1) {
            example.or().andIdEqualTo(sAdmin.getId()).andIsdeleteEqualTo(0);
            example.or().andRoleidEqualTo(2).andIsdeleteEqualTo(0);
        }else{
            example.or().andIsdeleteEqualTo(0).andIdEqualTo(sAdmin.getId());
        }
        
        List<Admin> admins = adminMapper.selectByExample(example);
        return admins;
    }
    
    public Admin check(Admin admin){
        AdminExample example = new AdminExample();
        example.or()
        .andUsernameEqualTo(admin.getUsername())
        .andPasswordEqualTo(MD5(admin.getPassword()))
        .andIsdeleteEqualTo(0);
        
        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins.size()>1){
            throw new RuntimeException();
        }else if(admins==null||admins.size()==0){
            return null;
        }else{
            return admins.get(0);
        }
    }
    
    /**
     * 验证用户名
     * @param admin
     * @return
     */
    public Admin checkAdminName(Admin admin){
        AdminExample example = new AdminExample();
        Criteria or = example.or();
        if(admin.getId()!=null){
            or.andUsernameEqualTo(admin.getUsername()).andIdNotEqualTo(admin.getId());
        }else{
            or.andUsernameEqualTo(admin.getUsername());
        }
        
        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins.size()>1){
            throw new RuntimeException();
        }else if(admins==null||admins.size()==0){
            return null;
        }else{
            return admins.get(0);
        }
    }

    @Override
    public int addAdmin(Admin admin) {
        int id = 0;
        
        //后台验证
        if(admin.getUsername()==null||"".equals(admin.getUsername().trim())) throw new RuntimeException("请输入用户名");
        if(admin.getPassword()==null||"".equals(admin.getPassword().trim())) throw new RuntimeException("请输入密码");
        
        //检查用户名是否存在
        Admin admin2 = checkAdminName(admin);
        if(admin2!=null) throw new RuntimeException("用户名已存在");
        
        //初始化字段
        admin.setAddtime(new Date());
        admin.setPassword(MD5(admin.getPassword()));

        //添加管理员
        id = super.addAdmin(admin);
        return id;
    }

    @Override
    public int updateAdmin(Admin admin) {
    	
    	Admin tadmin = super.getAdmin(admin.getId());
    	
    	//修改允许修改的字段
        if(admin.getUsername()!=null&&!"".equals(admin.getUsername().trim())) tadmin.setUsername(admin.getUsername()); 
        if(admin.getPassword()!=null&&!"".equals(admin.getPassword().trim())) tadmin.setPassword(MD5(admin.getPassword()));
    	
        return super.updateAdmin(tadmin);
    }
    
    public void deleteAdmin(Admin admin){
        admin = super.getAdmin(admin.getId());
        if(admin == null) return;
        //删除更新字段
        admin.setIsdelete(1);
        super.updateAdmin(admin);
    }
    
    public void statusAdmin(Admin admin){
        admin = super.getAdmin(admin.getId());
        if(admin == null) return;
        if(admin.getStatus()==0){
            admin.setStatus(1);
        }else {
            admin.setStatus(0);
        }
        super.updateAdmin(admin);
    }
    
    
    
    public String MD5(String s) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
        try {  
            byte[] btInput = s.getBytes();  
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
    
    public long total(){
        
        Realm subject = securityManager.getSubject();
        Admin sAdmin = (Admin)subject.getMember();
        
    	AdminExample example = new AdminExample();
    	
    	if(sAdmin.getRoleid()==0){
            example.or().andIsdeleteEqualTo(0);
        }else if (sAdmin.getRoleid()==1) {
            example.or().andIdEqualTo(sAdmin.getId()).andIsdeleteEqualTo(0);
            example.or().andRoleidEqualTo(2).andIsdeleteEqualTo(0);
        }else{
            example.or().andIsdeleteEqualTo(0).andIdEqualTo(sAdmin.getId());
        }
    	
    	return adminMapper.countByExample(example);
    }
    

}
