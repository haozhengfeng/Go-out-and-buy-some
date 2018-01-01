package org.haozf.admin.service;

import java.util.List;

import org.haozf.admin.mapper.BackAdminMapper;
import org.haozf.mybatis.mapper.AdminMapper;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.model.AdminExample;
import org.haozf.mybatis.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackAdminService{
    
    @Autowired
    AdminMapper adminMapper;
    
    @Autowired
    BackAdminMapper backAdminMapper;
    
    public List<Admin> listAdmin(Admin admin){
        List<Admin> admins = backAdminMapper.listAdmin(admin);
        return admins;
    }
    
    public Admin check(Admin admin){
        AdminExample example = new AdminExample();
        example.or()
        .andUsernameEqualTo(admin.getUsername())
        .andPasswordEqualTo(admin.getPassword());
        
        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins.size()>1){
            throw new RuntimeException();
        }else if(admins==null||admins.size()==0){
            return null;
        }else{
            return admins.get(0);
        }
    }

}
