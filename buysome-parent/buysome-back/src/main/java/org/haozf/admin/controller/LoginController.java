package org.haozf.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.haozf.admin.service.BackAdminService;
import org.haozf.mybatis.common.BaseController;
import org.haozf.mybatis.common.JsonResult;
import org.haozf.mybatis.model.Admin;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @RequestMapping(value="admin/login",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult login(Admin admin,HttpServletRequest request){
    	admin = backAdminService.check(admin);
    	
        //验证用户名密码
        if(admin != null){
        	
        	if(admin.getStatus()==0){
        	    result.setStatus("no");
                result.setMessage("用户已停用，请联系管理员");
                return result;
        	}
        	
        	log.info("角色："+admin.getRoleid()+" 用户："+admin.getUsername()+"登录！");
        	
        	Realm realm = new Realm();
        	realm.setMember(admin);
            securityManager.login(realm);
            result.setStatus("yes");
            result.setMessage("登录成功");
            return result;
        }
        
        result.setStatus("no");
        result.setMessage("用户名或密码错误");
        return result;
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
