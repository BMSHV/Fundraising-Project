package com.springboot.sprint1.util;

import org.springframework.stereotype.Component;

import com.springboot.sprint1.entity.PostEntity;
import com.springboot.sprint1.model.Post;

@Component
public class EntityModelUtil {
	
	public   PostEntity postModelToEntity(Post post) {
		
		PostEntity postEntity = new PostEntity();
		postEntity.setPostId(post.getPostId());
		postEntity.setUserId(post.getUserId());
		postEntity.setDonorId(post.getDonorId());
		postEntity.setPostDate(post.getPostDate());
		postEntity.setCategoryName(post.getCategoryName());
		postEntity.setUserDescription(post.getUserDescription());
		postEntity.setFundNeeded(post.getFundNeeded());
		postEntity.setFundCollected(post.getFundCollected());
		return postEntity;
		
	}
	
	public  Post postEntityToModel(PostEntity postEntity) {
		
		Post post = new Post();
		post.setPostId(postEntity.getPostId());
		post.setUserId(postEntity.getUserId());
		post.setDonorId(postEntity.getDonorId());
		post.setPostDate(postEntity.getPostDate());
		post.setCategoryName(postEntity.getCategoryName());
		post.setUserDescription(postEntity.getUserDescription());
		post.setFundNeeded(postEntity.getFundNeeded());
		post.setFundCollected(postEntity.getFundCollected());
		return post;
				
	}

}
