package com.abc.fundraising.service;

import java.util.List;

import com.abc.fundraising.model.Category;

public interface CategoryService {

    public Category saveCategory(Category category);
	
	public List<Category> getAllCategory() ;
	
	public Category getCategoryById(int categoryId);
	
	public Category getCategoryByName(String categoryName);
	
	public Category updateCategory(Category category);
	
	public void deleteCategory(int categoryId);
}
