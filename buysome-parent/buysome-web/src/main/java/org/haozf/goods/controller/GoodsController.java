package org.haozf.goods.controller;

import java.util.List;

import org.haozf.category.service.WebCategoryService;
import org.haozf.goods.common.GoodsJsonResult;
import org.haozf.goods.service.WebGoodsPicService;
import org.haozf.goods.service.WebGoodsService;
import org.haozf.mybatis.common.BaseController;
import org.haozf.mybatis.common.JsonResult;
import org.haozf.mybatis.common.Pagination;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsPic;
import org.haozf.mybatis.model.Shop;
import org.haozf.shop.service.WebShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController extends BaseController{
    
    @Autowired
    WebGoodsService webGoodsService;
    
    @Autowired
    WebGoodsPicService webGoodsPicService;
    
    @Autowired
    WebCategoryService webCategoryService;
    
    @Autowired
    WebShopService webShopService;
    
    @Value("${goods.goodsCover.url}")
    String goodsCoverUrl;
    
    @RequestMapping(value = "goods/list")
    public String list(Pagination pagination, Goods goods, Model model) {
        
        List<Category> categorys = webCategoryService.listCategory();
        model.addAttribute("categorys", categorys);
        
        List<Goods> goodss = webGoodsService.listGoods(goods);
        model.addAttribute("goodss", goodss);
        
        model.addAttribute("goodsCoverUrl", goodsCoverUrl);
        model.addAttribute("categorycode", goods.getCategorycode());
        return "goods/list";
    }
    
    @RequestMapping(value = "goods/ajaxlist")
    @ResponseBody
    public JsonResult ajaxlist(Pagination pagination, Goods goods, Model model) {
        GoodsJsonResult result = new GoodsJsonResult();
        try {
        	if(pagination.getPageNum()==0) pagination.setPageNum(1);
			if(pagination.getPageSize()==0) pagination.setPageSize(20);
			PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
			List<Goods> goodss = webGoodsService.listGoods(goods);
			PageInfo<Goods> pageInfo=new PageInfo<Goods>(goodss);  

			result.setStatus("yes");
	        result.setMessage("加载成功");
	        result.setGoods(goodss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setStatus("no");
	        result.setMessage("加载失败");
	        return result;
		}
        return result;
    }
    
    @RequestMapping(value="goods/{id}")
    public String goods(@PathVariable("id") int id,Model model){

        Goods goods = webGoodsService.getGoods(id);
        model.addAttribute("goods", goods);
        
        List<GoodsPic> goodsPics = webGoodsPicService.getGoodsPics(id);
        model.addAttribute("goodsPics", goodsPics);
        
        Shop shop = webShopService.getShop(goods.getShopid());
        model.addAttribute("shop", shop);
        
        List<Goods> shopGoods = webShopService.getShopGoods(goods.getShopid());
        model.addAttribute("shopGoods", shopGoods);
        
        List<Category> categorys = webCategoryService.listCategory();
        model.addAttribute("categorys", categorys);
        
        model.addAttribute("goodsCoverUrl", goodsCoverUrl);
        return "goods/index";
    }
}
