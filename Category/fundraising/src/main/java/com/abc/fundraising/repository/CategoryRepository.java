package com.abc.fundraising.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.fundraising.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {	
	
	
	public Optional<CategoryEntity> findByCategoryName(String categoryName);
	

}
