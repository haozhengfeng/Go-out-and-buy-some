package org.haozf.admin.controller;

import java.util.List;

import org.haozf.admin.service.BackAdminService;
import org.haozf.mybatis.common.BaseController;
import org.haozf.mybatis.common.JsonResult;
import org.haozf.mybatis.common.Pagination;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.service.ShopService;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
public class BackAdminController extends BaseController{
    
	@Autowired
    SecurityManager<Realm> securityManager;
	
    @Autowired
    BackAdminService backAdminService;
    
    @Autowired
    ShopService shopService;
    
    @RequestMapping(value = "admin/list")
    public String list(Pagination pagination, Admin admin, Model model) {
        
    	if(pagination.getPageNum()==0) pagination.setPageNum(1);
        if(pagination.getPageSize()==0) pagination.setPageSize(10);
        PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
        List<Admin> admins = backAdminService.listAdmin(admin);
        PageInfo<Admin> pageInfo=new PageInfo<Admin>(admins);
        model.addAttribute("page", pageInfo);
        model.addAttribute("admins", admins);
        
        //返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("sessionAdmin", sessionAdmin);
        
        return "admin/list";
    }
    
    @RequestMapping(value = "admin/toadd")
    public String toadd(Model model) {
    	
    	//返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("sessionAdmin", sessionAdmin);
        
        return "admin/add";
    }
    
    @RequestMapping(value = "admin/add")
    @ResponseBody
    public JsonResult add(Admin admin, Model model) {
        try {
            backAdminService.addAdmin(admin);
        } catch (Exception e) {
            result.setStatus("no");
            result.setMessage(e.getMessage());
            return result;
        }
        
        result.setStatus("yes");
        result.setMessage("添加成功");
        return result;
    }
    
    @RequestMapping(value = "admin/toedit")
    public String toedit(int id, Model model) {
        Admin admin = backAdminService.getAdmin(id);
        model.addAttribute("admin", admin);
        
        //返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("sessionAdmin", sessionAdmin);
        
        return "admin/edit";
    }
    
    @RequestMapping(value = "admin/edit")
    @ResponseBody
    public JsonResult edit(Admin admin, Model model) {
    	backAdminService.updateAdmin(admin);
    	result.setStatus("yes");
        result.setMessage("修改成功");
        return result;
    }
    
    @RequestMapping(value = "admin/delete")
    @ResponseBody
    public JsonResult delete(Admin admin, Model model) {
        backAdminService.deleteAdmin(admin);
        result.setStatus("yes");
        result.setMessage("删除成功");
        return result;
    }
    
    @RequestMapping(value = "admin/status")
    @ResponseBody
    public JsonResult status(Admin admin, Model model) {
        backAdminService.statusAdmin(admin);
        result.setStatus("yes");
        result.setMessage("修改成功");
        return result;
    }
}
