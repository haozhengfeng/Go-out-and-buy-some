package org.haozf.mybatis.mapper;

import java.util.List;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.model.AdminExample;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}