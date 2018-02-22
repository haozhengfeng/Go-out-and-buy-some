package org.haozf.shop.service;

import java.util.List;

import org.haozf.mybatis.mapper.GoodsMapper;
import org.haozf.mybatis.mapper.ShopMapper;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsExample;
import org.haozf.mybatis.model.Shop;
import org.haozf.mybatis.model.ShopExample;
import org.haozf.mybatis.model.ShopExample.Criteria;
import org.haozf.mybatis.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebShopService extends ShopService{
    
    @Autowired
    ShopMapper shopMapper;
    
    @Autowired
    GoodsMapper goodsMapper;
    
    @Value("${shop.shopCover.url}")
    String shopCoverUrl;
    
    @Value("${goods.goodsCover.url}")
    String goodsCoverUrl;
    
    public Shop getShop(int id){
        Shop shop = shopMapper.selectByPrimaryKey(id);
        shop.setShopcover(shopCoverUrl + shop.getShopcover());
        return shop;
    }
    
    /**
     * 通过店主获取店铺
     * @param adminid
     * @return
     */
    public Shop getShopByAdmin(int adminid){
        ShopExample example = new ShopExample();
        example.or().andAdminidEqualTo(adminid);
        List<Shop> shops = shopMapper.selectByExample(example);
        if(shops.size()==1){
            return shops.get(0);
        }else if(shops.size()==0){
            return null;
        }else{
            throw new RuntimeException("用户店铺数量异常");
        }
    }
    
    /**
     * 通过店铺名称获取店铺
     * @param name
     * @return
     */
    public Shop getShopByName(Shop shop){
        ShopExample example = new ShopExample();
        
        Criteria or = example.or();
        or.andNameEqualTo(shop.getName());
        
        if(shop.getId()!=null){
            or.andIdNotEqualTo(shop.getId());
        }
        
        List<Shop> shops = shopMapper.selectByExample(example);
        if(shops.size()==1){
            return shops.get(0);
        }else if(shops.size()==0){
            return null;
        }else{
            throw new RuntimeException("用户店铺数量异常");
        }
    }
    
    /**
     * 获取店铺下的商品
     * @param shopid
     * @return 
     */
    public List<Goods> getShopGoods(int shopid){
        GoodsExample example = new GoodsExample();
        example.or().andShopidEqualTo(shopid)
                    .andIsdeleteEqualTo(0)
                    .andStatusEqualTo(1);
                    
        List<Goods> goodsList = goodsMapper.selectByExample(example);
        
        for(Goods goods:goodsList){
            goods.setGoodscover(goodsCoverUrl + goods.getGoodscover());
        }
        
        return goodsList;
    }
    
}
