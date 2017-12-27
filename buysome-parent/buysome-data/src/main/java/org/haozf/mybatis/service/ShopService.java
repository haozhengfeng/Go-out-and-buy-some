package org.haozf.mybatis.service;

import java.util.List;

import org.haozf.mybatis.mapper.ShopMapper;
import org.haozf.mybatis.model.Shop;
import org.haozf.mybatis.model.ShopExample;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopService {
    @Autowired
    ShopMapper ShopMapper;
    
    public List<Shop> listShop(){
        ShopExample example = new ShopExample();
        return ShopMapper.selectByExample(example);
    }
    
    public Shop getShop(int id){
        return ShopMapper.selectByPrimaryKey(id);
    }
    
    public int addShop(Shop Shop){
        return ShopMapper.insertSelective(Shop);
    }
    
    public void deleteShop(int id){
        ShopMapper.deleteByPrimaryKey(id);
    }
    
    public int updateShop(Shop Shop){
        return ShopMapper.updateByPrimaryKey(Shop);
    }
}
