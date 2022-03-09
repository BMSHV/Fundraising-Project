package com.springboot.sprint1.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sprint1.entity.PostEntity;
import com.springboot.sprint1.exception.PostNotFoundException;
import com.springboot.sprint1.model.AllDetails;
import com.springboot.sprint1.model.Category;
import com.springboot.sprint1.model.Donor;
import com.springboot.sprint1.model.Post;
import com.springboot.sprint1.model.User;
import com.springboot.sprint1.repository.PostRepository;
import com.springboot.sprint1.util.EntityModelUtil;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private DonorService donorService;

	@Autowired
	private CategoryService categoryService;

	@Override
	public Post createPost(Post post) {

		post.setPostDate(LocalDate.now());

		int donorId = post.getDonorId();
		Donor donor = donorService.getDonorDetails(donorId);

		float fundCollected = (float) donor.getDonorAmount();
		post.setFundCollected(post.getFundCollected() + fundCollected);

		int userId = post.getUserId();
		User user = userService.getUserDetails(userId);

		float fundNeeded = user.getUserFundAmount();
		post.setFundNeeded(fundNeeded - fundCollected);
		
		return EntityModelUtil.postEntityToModel(postRepository.save(EntityModelUtil.postModelToEntity(post)));

	}

	@Override
	public AllDetails getPostById(int postId) throws PostNotFoundException {

		AllDetails allDetails = new AllDetails();

		Optional<PostEntity> optionalPost = postRepository.findById(postId);

		if (optionalPost.isEmpty()) {
			throw new PostNotFoundException("Sorry ! Post is not available with id :" + postId);

		}
		PostEntity postEntity = optionalPost.get();
		allDetails.setPost(EntityModelUtil.postEntityToModel(postEntity));
		User user = userService.getUserDetails(postEntity.getUserId());
		Donor donor = donorService.getDonorDetails(postEntity.getDonorId());
		Category category = categoryService.getCategoryDetails(postEntity.getCategoryName());

		allDetails.setUser(user);
		allDetails.setDonor(donor);
		allDetails.setCategory(category);

		return allDetails;
	}

	@Override
	public void deletePost(int userId) {

		Optional<PostEntity> optionalPostEntity = postRepository.findById(userId);

		if (optionalPostEntity.isPresent()) {
			postRepository.deleteById(userId);
		}

		else {
			throw new PostNotFoundException("Sorry ! User is not available with id :" + userId);
		}

	}

	@Override
	public Post updatePost(Post post) {

		post.setPostDate(LocalDate.now());


		Optional<PostEntity> optionalPostEntity = postRepository.findById(post.getPostId());

		if (optionalPostEntity.isEmpty()) {

			throw new PostNotFoundException("Sorry ! User is not available with id :" + post.getPostId());
		}

		PostEntity updatedPost = postRepository.save(EntityModelUtil.postModelToEntity(post));

		return EntityModelUtil.postEntityToModel(updatedPost);

	}

	public Category getCategoryDetails(String categoryName) {

		return categoryService.getCategoryDetails(categoryName);

	}

	public User getUserDetails(int userId) {

		return userService.getUserDetails(userId);
	}

	public Donor getDonorDetails(int donorId) {

		return donorService.getDonorDetails(donorId);
	}

	@Override
	public Post getPostDetails(int postId) throws PostNotFoundException {

		Optional<PostEntity> optionalPostEntity = postRepository.findById(postId);
		if (optionalPostEntity.isEmpty()) {
			throw new PostNotFoundException("Sorry User is not found with id :" + postId);
		}
		return EntityModelUtil.postEntityToModel(optionalPostEntity.get());
	}

}
