package org.haozf.goods.controller;

import java.util.List;

import org.haozf.common.Pagination;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping(value = "goods/list")
    public String list(Pagination pagination, Goods goods, Model model) {
        if(pagination.getPageNum()==0) pagination.setPageNum(1);
        if(pagination.getPageSize()==0) pagination.setPageSize(10);
        PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
        List<Goods> goodss = goodsService.listGoods(goods);
        PageInfo pageInfo=new PageInfo(goodss);  
        model.addAttribute("page", pageInfo);
        model.addAttribute("goodss", goodss);
        return "goods/list";
    }
}
