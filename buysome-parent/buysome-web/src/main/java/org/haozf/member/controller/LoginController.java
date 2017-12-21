package org.haozf.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.haozf.common.BaseController;
import org.haozf.member.model.Member;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends BaseController{
    
    @Autowired
    SecurityManager<Realm> securityManager;
    
    @RequestMapping("member/toLogin")
    public String toLogin(HttpServletRequest request){
        if(securityManager.getSubject()!=null){
            return "redirect:/";
        }
        return "login";
    }
    
    @RequestMapping("member/login")
    public String login(Member member,HttpServletRequest request){
        //验证用户名密码
        if("123".equals(member.getName())&&"123".equals(member.getPassword())){
            member.setId("123");
            securityManager.login(member);
            return "redirect:/";
        }
        
        return "redirect:toLogin";
    }
    
    @RequestMapping("member/logout")
    public String logout(HttpServletRequest request){
        //TODO 清除session
        securityManager.logout();
        return "redirect:/";
    }
}
