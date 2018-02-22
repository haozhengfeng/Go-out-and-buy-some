package org.haozf.mybatis.service;

import java.util.List;

import org.haozf.mybatis.common.BaseService;
import org.haozf.mybatis.mapper.MemberMapper;
import org.haozf.mybatis.model.Member;
import org.haozf.mybatis.model.MemberExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberService extends BaseService{
    @Autowired
    MemberMapper MemberMapper;
    
    public List<Member> listMember(){
        MemberExample example = new MemberExample();
        return MemberMapper.selectByExample(example);
    }
    
    public Member getMember(int id){
        return MemberMapper.selectByPrimaryKey(id);
    }
    
    public int addMember(Member Member){
        return MemberMapper.insertSelective(Member);
    }
    
    public void deleteMember(int id){
        MemberMapper.deleteByPrimaryKey(id);
    }
    
    public int updateMember(Member Member){
        return MemberMapper.updateByPrimaryKey(Member);
    }
}
