package org.haozf.mybatis.service;

import java.util.List;

import org.haozf.mybatis.mapper.ShopMapper;
import org.haozf.mybatis.model.Shop;
import org.haozf.mybatis.model.ShopExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    ShopMapper shopMapper;
    
    public List<Shop> listShop(){
        ShopExample example = new ShopExample();
        return shopMapper.selectByExample(example);
    }
    
    public List<Shop> listShop(Shop shop) {
		ShopExample example = new ShopExample();
		List<Shop> shops = shopMapper.selectByExample(example);
		return shops;
	}
    
    public Shop getShop(int id){
        return shopMapper.selectByPrimaryKey(id);
    }
    
    public int addShop(Shop Shop){
        return shopMapper.insertSelective(Shop);
    }
    
    public void deleteShop(int id){
    	shopMapper.deleteByPrimaryKey(id);
    }
    
    public int updateShop(Shop Shop){
        return shopMapper.updateByPrimaryKey(Shop);
    }
}
