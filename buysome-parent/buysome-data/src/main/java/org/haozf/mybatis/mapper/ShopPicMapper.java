package org.haozf.mybatis.mapper;

import java.util.List;
import org.haozf.mybatis.model.ShopPic;
import org.haozf.mybatis.model.ShopPicExample;

public interface ShopPicMapper {
    long countByExample(ShopPicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopPic record);

    int insertSelective(ShopPic record);

    List<ShopPic> selectByExample(ShopPicExample example);

    ShopPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopPic record);

    int updateByPrimaryKey(ShopPic record);
}