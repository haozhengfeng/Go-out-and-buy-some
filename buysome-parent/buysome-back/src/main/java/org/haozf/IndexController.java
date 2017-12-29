package org.haozf;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.haozf.common.BaseController;
import org.haozf.mybatis.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController extends BaseController{
    
    @Autowired
    MemberService memberService;
    
    @RequestMapping(value={"","index"})
    public String index(){
//        System.out.println(memberService.listMember());
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
