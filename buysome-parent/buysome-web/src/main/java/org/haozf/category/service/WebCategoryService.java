package org.haozf.category.service;

import java.util.List;

import org.haozf.mybatis.mapper.CategoryMapper;
import org.haozf.mybatis.mapper.GoodsMapper;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.model.CategoryExample;
import org.haozf.mybatis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebCategoryService extends CategoryService{

    @Autowired
    CategoryMapper categoryMapper;
    
    @Autowired
    GoodsMapper goodsMapper;
    
    public List<Category> listCategory() {
        CategoryExample example = new CategoryExample();
        example.or().andIsdeleteEqualTo(0).andStatusEqualTo(1);
        List<Category> Categorys = categoryMapper.selectByExample(example);
        return Categorys;
    }
    
}
