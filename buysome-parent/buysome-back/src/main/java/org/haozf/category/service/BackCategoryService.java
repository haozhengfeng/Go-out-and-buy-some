package org.haozf.category.service;

import java.util.Date;
import java.util.List;

import org.haozf.mybatis.mapper.CategoryMapper;
import org.haozf.mybatis.mapper.GoodsMapper;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.model.CategoryExample;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsExample;
import org.haozf.mybatis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackCategoryService extends CategoryService{

    @Autowired
    CategoryMapper categoryMapper;
    
    @Autowired
    GoodsMapper goodsMapper;
    
    public List<Category> listCategory() {
        CategoryExample example = new CategoryExample();
        example.or().andIsdeleteEqualTo(0);
        List<Category> Categorys = categoryMapper.selectByExample(example);
        return Categorys;
    }
    
    public List<Category> listCategory(Category category) {
        CategoryExample example = new CategoryExample();
        example.or().andIsdeleteEqualTo(0);
        List<Category> Categorys = categoryMapper.selectByExample(example);
        return Categorys;
    }
    
    
    public int addCategory(Category category) {
        category.setAddtime(new Date());
        return super.addCategory(category);
    }
    
    /**
     * 删除分类
     * @param category
     */
    public void deleteCategory(Category category) {
        category = super.getCategory(category.getId());
        if(category == null) return;
        
        //判断商品是否使用分类
        List<Goods> goodsCategory = getGoodsCategory(category.getCode());
        if(goodsCategory.size()>0) throw new RuntimeException("有商品使用此分类不能删除");
        
        //删除更新字段
        category.setIsdelete(1);
        super.updateCategory(category);
    }
    
    /**
     * 启用停用分类
     * @param shop
     */
    public void statusCategory(Category category){
        category = super.getCategory(category.getId());
        if(category == null) return;
        if(category.getStatus()==0){
            category.setStatus(1);
        }else {
            category.setStatus(0);
        }
        super.updateCategory(category);
    }
    
    /**
     * 获取使用某分类的商品
     * @param categorycode
     * @return
     */
    public List<Goods> getGoodsCategory(int categorycode){
        GoodsExample example = new GoodsExample();
        example.or().andCategorycodeEqualTo(categorycode);
        return goodsMapper.selectByExample(example);
    }
    
}
