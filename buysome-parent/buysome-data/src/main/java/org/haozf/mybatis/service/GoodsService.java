package org.haozf.mybatis.service;

import java.util.List;

import org.haozf.mybatis.common.BaseService;
import org.haozf.mybatis.mapper.GoodsMapper;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends BaseService{
    @Autowired
    GoodsMapper goodsMapper;
    
    public List<Goods> listGoods(){
        GoodsExample example = new GoodsExample();
        return goodsMapper.selectByExample(example);
    }
    
    public List<Goods> listGoods(Goods goods) {
		GoodsExample example = new GoodsExample();
		List<Goods> goodss = goodsMapper.selectByExample(example);
		return goodss;
	}
    
    public Goods getGoods(int id){
        return goodsMapper.selectByPrimaryKey(id);
    }
    
    public int addGoods(Goods goods){
        return goodsMapper.insertSelective(goods);
    }
    
    public void deleteGoods(int id){
        goodsMapper.deleteByPrimaryKey(id);
    }
    
    public int updateGoods(Goods goods){
        return goodsMapper.updateByPrimaryKey(goods);
    }
}
