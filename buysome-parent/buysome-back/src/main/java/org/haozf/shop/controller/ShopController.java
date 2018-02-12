package org.haozf.shop.controller;

import java.util.List;

import org.haozf.common.Pagination;
import org.haozf.mybatis.model.Shop;
import org.haozf.mybatis.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class ShopController {

	@Autowired
	ShopService shopService;
	
	@RequestMapping(value = "shop/list")
    public String list(Pagination pagination, Shop shop, Model model) {
        if(pagination.getPageNum()==0) pagination.setPageNum(1);
        if(pagination.getPageSize()==0) pagination.setPageSize(10);
        PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
        List<Shop> shops = shopService.listShop(shop);
        PageInfo pageInfo=new PageInfo(shops);  
        model.addAttribute("page", pageInfo);
        model.addAttribute("shops", shops);
        return "shop/list";
    }
}
