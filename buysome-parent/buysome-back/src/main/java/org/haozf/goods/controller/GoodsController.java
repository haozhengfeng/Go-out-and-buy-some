package org.haozf.goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.haozf.admin.service.BackAdminService;
import org.haozf.category.service.BackCategoryService;
import org.haozf.goods.common.GoodsJsonResult;
import org.haozf.goods.service.BackGoodsPicService;
import org.haozf.goods.service.BackGoodsService;
import org.haozf.mybatis.common.BaseController;
import org.haozf.mybatis.common.JsonResult;
import org.haozf.mybatis.common.Pagination;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsPic;
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
	
	@Autowired
	BackGoodsPicService backGoodsPicService;
	
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
        
        Shop shop = backShopService.getShopByAdmin(sessionAdmin.getId());
        model.addAttribute("shop", shop);
        
        return "goods/list";
    }
	
	@RequestMapping(value = "goods/toadd")
    public String toadd(Model model) {
	    //返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("admin", sessionAdmin);
        if(sessionAdmin.getShopid()==null){
            return "redirect:/shop/toadd?id="+sessionAdmin.getId();
        }
        
        Shop shop = backShopService.getShop(sessionAdmin.getShopid());
        model.addAttribute("shop", shop);
        
        List<Category> categorys = backCategoryService.listCategory();
        model.addAttribute("categorys", categorys);
        
        return "goods/add";
    }
    
    @RequestMapping(value = "goods/add",method=RequestMethod.POST)
    @ResponseBody
    public GoodsJsonResult add(@RequestParam(value = "file", required = false)MultipartFile file,Goods goods,Model model) {
        GoodsJsonResult result = new GoodsJsonResult();
        try {
            String goodsCover = backGoodsService.addGoodsCover(file);
            goods.setGoodscover(goodsCover);
            backGoodsService.addGoods(goods);
            result.setGoods(goods);
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
    
    
    @RequestMapping(value = "goods/toedit")
    public String toedit(Goods goods, Model model) {
        
        goods = backGoodsService.getGoods(goods.getId());
        model.addAttribute("goods", goods);
        
        //返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("sessionAdmin", sessionAdmin);
        
        Shop shop = backShopService.getShop(goods.getShopid());
        model.addAttribute("shop", shop);
        
        Admin admin = backAdminService.getAdmin(shop.getAdminid());
        model.addAttribute("admin", admin);
        
        List<Category> categorys = backCategoryService.listCategory();
        model.addAttribute("categorys", categorys);
        
        List<GoodsPic> goodsPics = backGoodsPicService.getGoodsPics(goods.getId());
        model.addAttribute("goodsPics", goodsPics);
        
        return "goods/edit";
    }
    
    @RequestMapping(value = "goods/edit",method=RequestMethod.POST)
    @ResponseBody
    public GoodsJsonResult edit(@RequestParam(value = "file", required = false)MultipartFile file,Goods goods, Model model) {
        GoodsJsonResult result = new GoodsJsonResult();
        try {
            String goodsCover = backGoodsService.addGoodsCover(file);
            goods.setGoodscover(goodsCover);
            backGoodsService.updateGoods(goods);
            result.setGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus("no");
            result.setMessage(e.getMessage());
            return result;
        }
        
        result.setStatus("yes");
        result.setMessage("修改成功");
        return result;
    }
    
    
    
    @RequestMapping(value = "goods/delete")
    @ResponseBody
    public JsonResult delete(Goods goods, Model model) {
        backGoodsService.deleteGoods(goods);
        result.setStatus("yes");
        result.setMessage("删除成功");
        return result;
    }
    
    @RequestMapping(value = "goods/status")
    @ResponseBody
    public JsonResult status(Goods goods, Model model) {
    	backGoodsService.statusGoods(goods);
        result.setStatus("yes");
        result.setMessage("修改成功");
        return result;
    }
	
    
    @RequestMapping(value = "goods/goodsPicUpload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult goodsPicUpload(@RequestParam(value = "file")  MultipartFile[] files,HttpServletRequest request ){
        if(files!=null&&files.length>0){  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i];  
                if (!file.isEmpty()) {  
                    try {
                        GoodsPic goodsPic = new GoodsPic();
                        goodsPic.setGoodsid(Integer.parseInt(request.getParameter("goodsid")));
                        //处理上传的文件
                        String diskfileName = backGoodsPicService.goodsCover(file);
                        goodsPic.setPicpath(diskfileName);
                        //处理文件对应的数据
                        backGoodsPicService.addGoodsPic(goodsPic);
                    } catch (Exception e) {  
                        e.printStackTrace();  
                        result.setStatus("no");
                        result.setMessage(e.getMessage());
                        return result;
                    }
                }
            }  
        }
        result.setStatus("yes");
        result.setMessage("上传商品图片成功");
        return result;
    }
    
    @RequestMapping(value = "goods/deleteGoodsPic", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteGoodsPic(int id,HttpServletRequest request ){
        
        try {
            backGoodsPicService.deleteGoodsPic(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus("no");
            result.setMessage(e.getMessage());
            return result;
        }
        
        result.setStatus("yes");
        result.setMessage("上传商品图片成功");
        return result;
    }
    
}
