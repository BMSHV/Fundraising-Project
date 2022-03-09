package com.abc.fundraising.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.fundraising.entity.CategoryEntity;
import com.abc.fundraising.exception.CategoryNotFoundException;
import com.abc.fundraising.model.Category;
import com.abc.fundraising.repository.CategoryRepository;
import com.abc.fundraising.util.EntityModelUtil;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {		
		
		CategoryEntity categoryEntity = categoryRepository.save(EntityModelUtil.categoryModelToEntity(category));
		
		return EntityModelUtil.categoryEntityToModel(categoryEntity);
	}
    @Override
	public List<Category> getAllCategory() {
    	
		List<CategoryEntity> categories= categoryRepository.findAll();
		
		return EntityModelUtil.categoryEntityToModelList(categories);
	}

	@Override
	public Category getCategoryById(int categoryId) throws CategoryNotFoundException {
		
		Optional<CategoryEntity> optionalCategory = categoryRepository.findById(categoryId);
		
		if(optionalCategory.isEmpty()) {
			throw new CategoryNotFoundException("Sorry! Category is not existing with id: "+ categoryId);
		}
		return EntityModelUtil.categoryEntityToModel(optionalCategory.get());		
	}

	@Override
	public Category updateCategory(Category category) {
		
		Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(category.getCategoryId());
		
		if(optionalCategoryEntity.isEmpty()) {
			throw new CategoryNotFoundException("Sorry! Category is not existing with id: "+category.getCategoryId());
		}
		
		CategoryEntity updatedCategoryEntity = categoryRepository.save(EntityModelUtil.categoryModelToEntity(category));
		
		return EntityModelUtil.categoryEntityToModel(updatedCategoryEntity);
	}

	@Override
	public void deleteCategory(int categoryId) {
	
		Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(categoryId);
		
		if(optionalCategoryEntity.isPresent()) {			
			categoryRepository.deleteById(categoryId);			
		}
		else {
			throw new CategoryNotFoundException("Sorry! Category is not existing with id: "+categoryId);
		}			
	}

	@Override
	public Category getCategoryByName(String categoryName) throws CategoryNotFoundException{
		
		Optional<CategoryEntity> optionalCategory = categoryRepository.findByCategoryName(categoryName);
		
		if(optionalCategory.isEmpty()) {
			
			throw new CategoryNotFoundException("Sorry! Category is not existing with name: "+ categoryName);
		}
		
		return EntityModelUtil.categoryEntityToModel(optionalCategory.get());		
	}
	

}
