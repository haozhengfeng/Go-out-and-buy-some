package org.haozf.mybatis.mapper;

import java.util.List;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsExample;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}