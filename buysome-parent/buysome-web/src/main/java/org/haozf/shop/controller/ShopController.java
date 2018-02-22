package org.haozf.shop.controller;

import java.util.List;

import org.haozf.mybatis.common.Pagination;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.Shop;
import org.haozf.mybatis.service.GoodsService;
import org.haozf.shop.service.WebShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {
    
    @Autowired
    WebShopService webShopService;
    
    @RequestMapping(value="shop/list")
    public String list(Pagination pagination){
        return "";
    }
    
    @RequestMapping(value="shop/{id}")
    public String shop(@PathVariable("id") int id,Model model){

        Shop shop = webShopService.getShop(id);
        model.addAttribute("shop", shop);
        
        List<Goods> shopGoods = webShopService.getShopGoods(id);
        model.addAttribute("shopGoods", shopGoods);
        
        return "shop/index";
    }
    
}
