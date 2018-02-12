package org.haozf.category.controller;

import java.util.List;

import org.haozf.common.Pagination;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "category/list")
    public String list(Pagination pagination, Category category, Model model) {
        if(pagination.getPageNum()==0) pagination.setPageNum(1);
        if(pagination.getPageSize()==0) pagination.setPageSize(10);
        PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
        List<Category> categorys = categoryService.listCategory(category);
        PageInfo pageInfo=new PageInfo(categorys);  
        model.addAttribute("page", pageInfo);
        model.addAttribute("categorys", categorys);
        return "category/list";
    }
}
