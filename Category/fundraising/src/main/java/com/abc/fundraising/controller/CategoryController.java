package com.abc.fundraising.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.fundraising.model.Category;
import com.abc.fundraising.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/save")
	public ResponseEntity<Category> addProduct(@RequestBody Category category) {
		
		Category newCategory = categoryService.saveCategory(category);
		ResponseEntity<Category> responseEntity = new ResponseEntity<>(newCategory, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/all")
	public List<Category> fetchAllProducts() {
		List<Category> categories = categoryService.getAllCategory();
		return categories;

	}

	@GetMapping("/get/{cid}")
	public ResponseEntity<?> fetchCategoryDetails(@PathVariable("cid") int categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	@GetMapping("/getbyname/{cname}")
	public ResponseEntity<?> fetchProductDetailsByNane(@PathVariable("cname") String cname) {
		Category category = categoryService.getCategoryByName(cname);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<?> deleteCategory(@PathVariable("cid") int categoryId) {
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>("Category Deleted with id: "+categoryId, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Category> modifyCategory(@RequestBody Category category) {
		Category updatedCategory = categoryService.updateCategory(category);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}	

}
