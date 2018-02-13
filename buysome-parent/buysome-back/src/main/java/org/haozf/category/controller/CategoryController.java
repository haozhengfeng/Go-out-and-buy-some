package org.haozf.category.controller;

import java.util.List;

import org.haozf.category.service.BackCategoryService;
import org.haozf.common.BaseController;
import org.haozf.common.JsonResult;
import org.haozf.common.Pagination;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.model.Category;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CategoryController extends BaseController{
    
    @Autowired
    SecurityManager<Realm> securityManager;
    
	@Autowired
	BackCategoryService categoryService;
	
	@RequestMapping(value = "category/list")
    public String list(Pagination pagination, Category category, Model model) {
        if(pagination.getPageNum()==0) pagination.setPageNum(1);
        if(pagination.getPageSize()==0) pagination.setPageSize(10);
        PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
        List<Category> categorys = categoryService.listCategory(category);
        PageInfo<Category> pageInfo=new PageInfo<Category>(categorys);  
        model.addAttribute("page", pageInfo);
        model.addAttribute("categorys", categorys);
        
        //返回当前登录用户
        Admin sessionAdmin = (Admin)securityManager.getSubject().getMember();
        model.addAttribute("sessionAdmin", sessionAdmin);
        
        return "category/list";
    }
	
	@RequestMapping(value = "category/toadd")
    public String toadd(Model model) {
        return "category/add";
    }
	
	
	@RequestMapping(value = "category/add")
    @ResponseBody
    public JsonResult add(Category category, Model model) {
        try {
            categoryService.addCategory(category);
        } catch (Exception e) {
            result.setStatus("no");
            result.setMessage(e.getMessage());
            return result;
        }
        
        result.setStatus("yes");
        result.setMessage("添加成功");
        return result;
    }
	
	@RequestMapping(value = "category/toedit")
    public String toedit(int id,Model model) {
	    Category category = categoryService.getCategory(id);
	    model.addAttribute("category", category);
        return "category/edit";
    }
	
	
    @RequestMapping(value = "category/edit",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Category category, Model model) {
        
        try {
            categoryService.updateCategory(category);
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
    
    @RequestMapping(value = "category/delete")
    @ResponseBody
    public JsonResult delete(Category category,Model model) {
        categoryService.deleteCategory(category);
        result.setStatus("yes");
        result.setMessage("删除成功");
        return result;
    }
    
    @RequestMapping(value = "category/status")
    @ResponseBody
    public JsonResult status(Category category, Model model) {
        categoryService.statusCategory(category);
        result.setStatus("yes");
        result.setMessage("修改成功");
        return result;
    }
}
