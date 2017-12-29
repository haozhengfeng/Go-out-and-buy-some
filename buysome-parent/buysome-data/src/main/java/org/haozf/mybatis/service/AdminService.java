package org.haozf.mybatis.service;

import java.util.List;

import org.haozf.mybatis.mapper.AdminMapper;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.model.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    @Autowired
    AdminMapper adminMapper;
    
    public List<Admin> listAdmin(){
        AdminExample example = new AdminExample();
        return adminMapper.selectByExample(example);
    }
    
    public Admin getAdmin(int id){
        return adminMapper.selectByPrimaryKey(id);
    }
    
    public int addAdmin(Admin admin){
        return adminMapper.insertSelective(admin);
    }
    
    public void deleteAdmin(int id){
        adminMapper.deleteByPrimaryKey(id);
    }
    
    public int updateAdmin(Admin admin){
        return adminMapper.updateByPrimaryKey(admin);
    }

}