package com.abc.usersprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.usersprint.model.Category;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CategoryService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "categoryServiceFallBack")
	public Category getCategoryDetails(String categoryName) {

		String resourceUrl = "http://sprint1/fundraising/category/getbyname/" + categoryName;

		Category category = restTemplate.getForObject(resourceUrl, Category.class);

		return category;

	}
	
	@SuppressWarnings("unused")
	private Category categoryServiceFallBack(String categoryName) {
		
		Category category = new Category();
	    category.setCategoryId(0);
		category.setCategoryName(categoryName);

		System.out.println("Category Service is down!!! fallback route enabled...");
		return category;

	}

    

}
