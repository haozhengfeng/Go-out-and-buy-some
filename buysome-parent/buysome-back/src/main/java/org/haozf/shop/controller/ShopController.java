package org.haozf.shop.controller;

import java.util.List;

import org.haozf.admin.service.BackAdminService;
import org.haozf.mybatis.common.BaseController;
import org.haozf.mybatis.common.JsonResult;
import org.haozf.mybatis.common.Pagination;
import org.haozf.mybatis.model.Admin;
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
public class ShopController extends BaseController{

	@Autowired
    SecurityManager<Realm> securityManager;
	
	@Autowired
	BackShopService backShopService;

	@Autowired
	BackAdminService backAdminService;

	@RequestMapping(value = "shop/list")
	public String list(Pagination pagination, Shop shop, Model model) {
		if (pagination.getPageNum() == 0)
			pagination.setPageNum(1);
		if (pagination.getPageSize() == 0)
			pagination.setPageSize(10);
		PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
		List<Shop> shops = backShopService.listShop(shop);
		PageInfo<Shop> pageInfo = new PageInfo<Shop>(shops);
		model.addAttribute("page", pageInfo);
		model.addAttribute("shops", shops);
		
		//返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("sessionAdmin", sessionAdmin);
		
		return "shop/list";
	}

	@RequestMapping(value = "shop/toadd")
	public String toadd(int id, Model model) {
		Admin admin = backAdminService.getAdmin(id);
		model.addAttribute("admin", admin);
		return "shop/add";
	}
	
	@RequestMapping(value = "shop/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult add(@RequestParam(value = "file", required = false)MultipartFile file,Shop shop,Model model) {
		
		try {
			String shopCover = backShopService.addShopCover(file);
			shop.setShopcover(shopCover);
			backShopService.addShop(shop);
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

	@RequestMapping(value = "shop/toedit")
	public String toedit(Shop shop, Model model) {
		
		shop = backShopService.getShop(shop.getId());
		model.addAttribute("shop", shop);
		
		//返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("sessionAdmin", sessionAdmin);

        Admin admin = backAdminService.getAdmin(shop.getAdminid());
        model.addAttribute("admin", admin);
        
		return "shop/edit";
	}
	
	@RequestMapping(value = "shop/edit",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(@RequestParam(value = "file", required = false)MultipartFile file,Shop shop, Model model) {
	    
	    try {
	        String shopCover = backShopService.addShopCover(file);
            shop.setShopcover(shopCover);
            backShopService.updateShop(shop);
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
    
    @RequestMapping(value = "shop/delete")
    @ResponseBody
    public JsonResult delete(Shop shop, Model model) {
        backShopService.deleteShop(shop);
        result.setStatus("yes");
        result.setMessage("删除成功");
        return result;
    }
    
    @RequestMapping(value = "shop/status")
    @ResponseBody
    public JsonResult status(Shop shop, Model model) {
        backShopService.statusShop(shop);
        result.setStatus("yes");
        result.setMessage("修改成功");
        return result;
    }
	

}
