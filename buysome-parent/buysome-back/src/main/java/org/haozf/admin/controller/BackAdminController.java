package org.haozf.admin.controller;

import java.util.List;
import java.util.Map;

import org.haozf.admin.service.BackAdminService;
import org.haozf.common.BaseController;
import org.haozf.common.JsonResult;
import org.haozf.common.Pagination;
import org.haozf.mybatis.model.Admin;
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
    BackAdminService backAdminService;
    
    @RequestMapping(value = "admin/list")
    public String list(Pagination pagination, Admin admin, Model model) {
        if(pagination.getPageNum()==0) pagination.setPageNum(1);
        if(pagination.getPageSize()==0) pagination.setPageSize(10);
        PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
        List<Admin> admins = backAdminService.listAdmin(admin);
        PageInfo<Admin> pageInfo=new PageInfo<Admin>(admins);
        model.addAttribute("page", pageInfo);
        model.addAttribute("admins", admins);
        return "admin/list";
    }
    
    @RequestMapping(value = "admin/toadd")
    public String toadd(Model model) {
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
        return "admin/edit";
    }
    
    @RequestMapping(value = "admin/edit")
    @ResponseBody
    public Map<String, String> edit(Admin admin, Model model) {
        return null;
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
