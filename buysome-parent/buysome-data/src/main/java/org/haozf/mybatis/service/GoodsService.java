package org.haozf.mybatis.service;

import java.util.List;

import org.haozf.mybatis.mapper.GoodsMapper;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired
    GoodsMapper GoodsMapper;
    
    public List<Goods> listGoods(){
        GoodsExample example = new GoodsExample();
        return GoodsMapper.selectByExample(example);
    }
    
    public Goods getGoods(int id){
        return GoodsMapper.selectByPrimaryKey(id);
    }
    
    public int addGoods(Goods goods){
        return GoodsMapper.insertSelective(goods);
    }
    
    public void deleteGoods(int id){
        GoodsMapper.deleteByPrimaryKey(id);
    }
    
    public int updateGoods(Goods goods){
        return GoodsMapper.updateByPrimaryKey(goods);
    }
}
