package org.haozf.mybatis.mapper;

import java.util.List;
import org.haozf.mybatis.model.Member;
import org.haozf.mybatis.model.MemberExample;

public interface MemberMapper {
    long countByExample(MemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}