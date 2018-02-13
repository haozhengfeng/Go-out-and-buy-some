package org.haozf.goods.controller;

import java.util.List;

import org.haozf.admin.service.BackAdminService;
import org.haozf.category.service.BackCategoryService;
import org.haozf.common.BaseController;
import org.haozf.common.JsonResult;
import org.haozf.common.Pagination;
import org.haozf.goods.service.BackGoodsService;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.Shop;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.haozf.shop.service.BackShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController extends BaseController{
	
    @Autowired
    SecurityManager<Realm> securityManager;
    
	@Autowired
	BackGoodsService backGoodsService;
	
	@Autowired
	BackAdminService backAdminService;
	
	@Autowired
	BackShopService backShopService;
	
	@Autowired
	BackCategoryService backCategoryService;
	
	@RequestMapping(value = "goods/list")
    public String list(Pagination pagination, Goods goods, Model model) {
        if(pagination.getPageNum()==0) pagination.setPageNum(1);
        if(pagination.getPageSize()==0) pagination.setPageSize(10);
        PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
        List<Goods> goodss = backGoodsService.listGoods(goods);
        PageInfo<Goods> pageInfo=new PageInfo<Goods>(goodss);  
        model.addAttribute("page", pageInfo);
        model.addAttribute("goodss", goodss);
        
        //返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("sessionAdmin", sessionAdmin);
        
        return "goods/list";
    }
	
	@RequestMapping(value = "goods/toadd")
    public String toadd(Model model) {
	    //返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("admin", sessionAdmin);
        if(sessionAdmin.getShopid()==null){
            return "shop/toadd";
        }
        
        Shop shop = backShopService.getShop(sessionAdmin.getShopid());
        model.addAttribute("shop", shop);
        
        List<Category> categorys = backCategoryService.listCategory();
        model.addAttribute("categorys", categorys);
        
        return "goods/add";
    }
    
    @RequestMapping(value = "goods/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(@RequestParam(value = "file", required = false)MultipartFile file,Goods goods,Model model) {
        try {
            String goodsCover = backGoodsService.addGoodsCover(file);
            goods.setGoodscover(goodsCover);
            backGoodsService.addGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus("no");
            result.setMessage(e.getMessage());
            return result;
        }
        
        result.setStatus("yes");
        result.setMessage("添加成功");
        return result;
    }
	
}
