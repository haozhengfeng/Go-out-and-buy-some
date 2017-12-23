package org.haozf.member.service;

import java.util.List;

import org.haozf.mybatis.mapper.UserMapper;
import org.haozf.mybatis.model.User;
import org.haozf.mybatis.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberService {
    
    @Autowired
    UserMapper userMapper;
    
    public List<User> getUser(){
        UserExample example = new UserExample();
        example.setOrderByClause("id");
        return userMapper.selectByExample(example);
    }

}
