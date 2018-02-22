package org.haozf;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.haozf.admin.service.BackAdminService;
import org.haozf.category.service.BackCategoryService;
import org.haozf.goods.service.BackGoodsService;
import org.haozf.mybatis.common.BaseController;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.service.MemberService;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.haozf.shop.service.BackShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController extends BaseController{
    
	@Autowired
    SecurityManager<Realm> securityManager;
	
    @Autowired
    MemberService memberService;
    
    @Autowired
    BackAdminService backAdminService;
    
    @Autowired
    BackShopService backShopService;
    
    @Autowired
    BackGoodsService backGoodsService;
    
    @Autowired
    BackCategoryService backCategoryService;
    
    @RequestMapping(value={"","index"})
    public String index(Model model){
    	
    	//查询数量
    	model.addAttribute("adminTotal", backAdminService.total());
    	model.addAttribute("shopTotal", backShopService.total());
    	model.addAttribute("goodsTotal", backGoodsService.total());
    	model.addAttribute("categoryTotal", backCategoryService.total());
    	
    	//返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("sessionAdmin", sessionAdmin);
    	
        return "index";
    }
    
    @RequestMapping("ajax")
    @ResponseBody
    public Map ajax(HttpServletRequest request){
        Map<String, String> rt = new HashMap<String, String>();
        rt.put("redis_session_id", request.getSession().getId());
        return rt;
    }

}
