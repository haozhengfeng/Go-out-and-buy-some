package org.haozf.mybatis.service;

import java.util.List;

import org.haozf.mybatis.mapper.CategoryMapper;
import org.haozf.mybatis.model.Category;
import org.haozf.mybatis.model.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	CategoryMapper categoryMapper;

	public List<Category> listCategory() {
		CategoryExample example = new CategoryExample();
		return categoryMapper.selectByExample(example);
	}

	public List<Category> listCategory(Category category) {
		CategoryExample example = new CategoryExample();
		List<Category> Categorys = categoryMapper.selectByExample(example);
		return Categorys;
	}

	public Category getCategory(int id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	public int addCategory(Category category) {
		return categoryMapper.insertSelective(category);
	}

	public void deleteCategory(int id) {
		categoryMapper.deleteByPrimaryKey(id);
	}

	public int updateCategory(Category Category) {
		return categoryMapper.updateByPrimaryKey(Category);
	}
}
