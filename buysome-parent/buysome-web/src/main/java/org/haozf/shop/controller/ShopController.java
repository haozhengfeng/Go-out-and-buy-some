package org.haozf.shop.controller;

import java.util.List;

import org.haozf.category.service.WebCategoryService;
import org.haozf.mybatis.common.BaseController;
import org.haozf.mybatis.common.Pagination;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.Shop;
import org.haozf.shop.service.WebShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController extends BaseController{
    
    @Autowired
    WebShopService webShopService;
    
    @Autowired
    WebCategoryService webCategoryService;
    
    @Value("${shop.shopCover.url}")
    String shopCoverUrl;
    
    @RequestMapping(value="shop/list")
    public String list(Pagination pagination,Shop shop,Model model){
        
        List<Category> categorys = webCategoryService.listCategory();
        model.addAttribute("categorys", categorys);
        
        List<Shop> shops = webShopService.listShop(shop);
        model.addAttribute("shops", shops);
        
        model.addAttribute("shopCoverUrl", shopCoverUrl); 
        return "shop/list";
    }
    
    @RequestMapping(value="shop/{id}")
    public String shop(@PathVariable("id") int id,Model model){

        Shop shop = webShopService.getShop(id);
        model.addAttribute("shop", shop);
        
        List<Goods> shopGoods = webShopService.getShopGoods(id);
        model.addAttribute("shopGoods", shopGoods);
        
        List<Category> categorys = webCategoryService.listCategory();
        model.addAttribute("categorys", categorys);
        
        return "shop/index";
    }
    
}
