package com.abc.fundraising.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.fundraising.model.Category;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CategoryService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "categoryServiceFallBack")
	public Category getCategoryDetails(int categoryId) {

		String resourceUrl = "http://sprint1/fundraising/category/get/" + categoryId;

		Category category = restTemplate.getForObject(resourceUrl, Category.class);

		return category;

	}
	
	@SuppressWarnings("unused")
	private Category categoryServiceFallBack(int categoryId) {
		
		Category category = new Category();
		category.setCategoryId(categoryId);
		category.setCategoryName("");

		System.out.println("Category Service is down!!! fallback route enabled...");
		return category;

	}

    

}