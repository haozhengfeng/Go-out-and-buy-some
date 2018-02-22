package org.haozf.goods.service;

import java.util.List;

import org.haozf.mybatis.mapper.GoodsPicMapper;
import org.haozf.mybatis.model.GoodsPic;
import org.haozf.mybatis.model.GoodsPicExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebGoodsPicService {
    
    @Autowired
    GoodsPicMapper goodsPicMapper;

    @Value("${goods.goods.url}")
    String goodsUrl;
    
    public List<GoodsPic> getGoodsPics(int goodsid){
        GoodsPicExample example = new GoodsPicExample();
        example.or().andGoodsidEqualTo(goodsid);
        return goodsPicMapper.selectByExample(example);
    }

}
