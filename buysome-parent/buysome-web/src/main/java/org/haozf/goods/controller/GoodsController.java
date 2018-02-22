package org.haozf.goods.controller;

import java.util.List;

import org.haozf.common.BaseController;
import org.haozf.goods.service.WebGoodsPicService;
import org.haozf.goods.service.WebGoodsService;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsPic;
import org.haozf.mybatis.model.Shop;
import org.haozf.shop.service.WebShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController extends BaseController{
    
    @Autowired
    WebGoodsService webGoodsService;
    
    @Autowired
    WebGoodsPicService webGoodsPicService;
    
    @Autowired
    WebShopService webShopService;
    
    @RequestMapping(value="goods/{id}")
    public String shop(@PathVariable("id") int id,Model model){

        Goods goods = webGoodsService.getGoods(id);
        model.addAttribute("goods", goods);
        
        List<GoodsPic> goodsPics = webGoodsPicService.getGoodsPics(id);
        model.addAttribute("goodsPics", goodsPics);
        
        Shop shop = webShopService.getShop(goods.getShopid());
        model.addAttribute("shop", shop);
        
        List<Goods> shopGoods = webShopService.getShopGoods(goods.getShopid());
        model.addAttribute("shopGoods", shopGoods);
        
        return "goods/index";
    }
}
