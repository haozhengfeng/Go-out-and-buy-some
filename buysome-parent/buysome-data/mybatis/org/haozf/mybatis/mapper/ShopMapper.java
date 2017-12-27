package org.haozf.mybatis.mapper;

import java.util.List;
import org.haozf.mybatis.model.Shop;
import org.haozf.mybatis.model.ShopExample;

public interface ShopMapper {
    long countByExample(ShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shop record);

    int insertSelective(Shop record);

    List<Shop> selectByExample(ShopExample example);

    Shop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}