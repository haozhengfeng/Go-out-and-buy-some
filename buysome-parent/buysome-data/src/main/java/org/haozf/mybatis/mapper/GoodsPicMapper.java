package org.haozf.mybatis.mapper;

import java.util.List;
import org.haozf.mybatis.model.GoodsPic;
import org.haozf.mybatis.model.GoodsPicExample;

public interface GoodsPicMapper {
    long countByExample(GoodsPicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsPic record);

    int insertSelective(GoodsPic record);

    List<GoodsPic> selectByExample(GoodsPicExample example);

    GoodsPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsPic record);

    int updateByPrimaryKey(GoodsPic record);
}