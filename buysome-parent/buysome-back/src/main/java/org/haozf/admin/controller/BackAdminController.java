package org.haozf.admin.controller;

import java.util.List;
import java.util.Map;

import org.haozf.admin.service.BackAdminService;
import org.haozf.common.BaseController;
import org.haozf.common.Pagination;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.service.AdminService;
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
        PageInfo pageInfo=new PageInfo(admins);  
        model.addAttribute("page", pageInfo);
        model.addAttribute("admins", admins);
        return "admin/list";
    }
    
    
    @RequestMapping(value = "admin/edit")
    @ResponseBody
    public Map edit(Admin admin, Model model) {
        
        return null;
    }

}
