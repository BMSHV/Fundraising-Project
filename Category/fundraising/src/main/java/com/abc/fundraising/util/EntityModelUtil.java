package com.abc.fundraising.util;

import java.util.ArrayList;
import java.util.List;

import com.abc.fundraising.entity.CategoryEntity;
import com.abc.fundraising.model.Category;

public class EntityModelUtil {

	public static CategoryEntity categoryModelToEntity(Category category) {

		CategoryEntity categoryEntity = new CategoryEntity();
		
		categoryEntity.setCategoryId(category.getCategoryId());
		categoryEntity.setCategoryName(category.getCategoryName());

		return categoryEntity;
	}

	public static Category  categoryEntityToModel(CategoryEntity categoryEntity) {

		Category category = new Category();
		category.setCategoryId(categoryEntity.getCategoryId());
		category.setCategoryName(categoryEntity.getCategoryName());

		return category;
	}
	
	public static List<Category> categoryEntityToModelList(List<CategoryEntity> entityList) {
		
		List<Category> categoryList = new ArrayList<>();
		
		entityList.forEach(entity -> {
			Category category = new Category();
			
			category.setCategoryId(entity.getCategoryId());
			category.setCategoryName(entity.getCategoryName());
			
			categoryList.add(category);
		});
		
	
	return categoryList;
	}
}
