package org.haozf.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.haozf.admin.service.BackAdminService;
import org.haozf.common.BaseController;
import org.haozf.mybatis.model.Admin;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends BaseController{
    
    @Autowired
    SecurityManager<Realm> securityManager;
    
    @Autowired
    BackAdminService backAdminService;
    
    @RequestMapping("admin/toLogin")
    public String toLogin(HttpServletRequest request){
        if(securityManager.getSubject()!=null){
            return "redirect:/";
        }
        return "admin/login";
    }
    
    @RequestMapping("admin/login")
    public String login(Admin admin,HttpServletRequest request){
    	log.info(admin.getUsername()+"管理员登录");
    	admin = backAdminService.check(admin);
        //验证用户名密码
        if(admin != null){
        	Realm realm = new Realm();
        	realm.setMember(admin);
            securityManager.login(realm);
            return "redirect:/";
        }
        
        return "redirect:toLogin";
    }
    
    @RequestMapping("admin/logout")
    public String logout(HttpServletRequest request){
    	if(securityManager.getSubject()==null){
            return "redirect:/";
        }
    	
    	Admin admin = (Admin)securityManager.getSubject().getMember();
    	log.info(admin.getUsername()+"退出系统");
    	
        //TODO 清除session
        securityManager.logout();
        return "redirect:/";
    }
}
