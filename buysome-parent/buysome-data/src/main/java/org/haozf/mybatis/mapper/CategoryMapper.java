package org.haozf.mybatis.mapper;

import java.util.List;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.model.CategoryExample;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}