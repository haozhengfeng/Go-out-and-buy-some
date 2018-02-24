package org.haozf.goods.service;

import java.util.List;

import org.haozf.mybatis.mapper.GoodsMapper;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsExample;
import org.haozf.mybatis.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebGoodsService extends GoodsService{
    
    @Autowired
    GoodsMapper goodsMapper;
    
    @Value("${goods.goodsCover.url}")
    String goodsCoverUrl;
    
    public Goods getGoods(int id){
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        if(goods!=null){
        	goods.setGoodscover(goodsCoverUrl + goods.getGoodscover());
        }
        return goods;
    }
    
    public List<Goods> listGoods(){
        GoodsExample example = new GoodsExample();
        example.or().andStatusEqualTo(1).andIsdeleteEqualTo(0);
        example.setOrderByClause(" id desc ");
        return goodsMapper.selectByExample(example);
    }

}
