package org.haozf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.haozf.category.service.WebCategoryService;
import org.haozf.common.BaseController;
import org.haozf.goods.service.WebGoodsService;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

@Controller
public class IndexController extends BaseController{
    
    @Autowired
    MemberService memberService;
    
    @Autowired
    WebCategoryService webCategoryService;
    
    @Autowired
    WebGoodsService webGoodsService;
    
    @Value("${goods.goodsCover.url}")
    String goodsCoverUrl;
    
    
    @RequestMapping(value={"","index"})
    public String index(Model model){
    	List<Category> categorys = webCategoryService.listCategory();
    	model.addAttribute("categorys", categorys);
    	
    	PageHelper.startPage(1, 6);
        List<Goods> goods = webGoodsService.listGoods();
        
    	//加载最新商品
        if(goods!=null){
        	model.addAttribute("latestGoods", goods.get(0));
        }
        	
    	//加载热门商品
        if(goods!=null){
            goods.remove(0);
        	model.addAttribute("hotGoods", goods);
        }
        model.addAttribute("goodsCoverUrl", goodsCoverUrl);	
    	
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
