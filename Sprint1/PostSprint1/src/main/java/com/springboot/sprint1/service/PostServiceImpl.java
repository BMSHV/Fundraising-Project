package com.springboot.sprint1.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sprint1.entity.PostEntity;
import com.springboot.sprint1.exception.PostNotFoundException;
import com.springboot.sprint1.exception.UserNotFoundException;
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
	
	@Autowired
	private EntityModelUtil entityModelUtil;
	
	/******************************************
	 - Method Name      : createPost
	 - Input Parameters : Post post
	 - Return type      : Post
	 - Author           : Harshavardhan
	 - Creation Date    : 07-03-2022
	 - Description      : Storing the values into  the database.
	  ******************************************/

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
				
		
		return entityModelUtil.postEntityToModel(postRepository.save(entityModelUtil.postModelToEntity(post)));

	}
	
	/******************************************
	 - Method Name      : getPostById
	 - Input Parameters : int postId
	 - Return type      : AllDetails
	 - Author           : Harshavardhan
	 - Creation Date    : 07-03-2022
	 - Description      : Displaying the post,user,donor and category values.
	  ******************************************/

	@Override
	public AllDetails getPostById(int postId) throws PostNotFoundException {

		AllDetails allDetails = new AllDetails();

		Optional<PostEntity> optionalPost = postRepository.findById(postId);

		if (optionalPost.isEmpty()) {
			throw new PostNotFoundException("Sorry ! Post is not available with id :" + postId);

		}
		PostEntity postEntity = optionalPost.get();
		allDetails.setPost(entityModelUtil.postEntityToModel(postEntity));
		User user = userService.getUserDetails(postEntity.getUserId());
		Donor donor = donorService.getDonorDetails(postEntity.getDonorId());
		Category category = categoryService.getCategoryDetails(postEntity.getCategoryName());

		allDetails.setUser(user);
		allDetails.setDonor(donor);
		allDetails.setCategory(category);

		return allDetails;
	}

	/******************************************
	 - Method Name      : deletePost
	 - Input Parameters : int postId
	 - Return type      : void
	 - Author           : Harshavardhan
	 - Creation Date    : 07-03-2022
	 - Description      : Deleting the values from  the database.
	  ******************************************/
	
	@Override
	public void deletePost(int postId) {

		Optional<PostEntity> optionalPostEntity = postRepository.findById(postId);

		if (optionalPostEntity.isPresent()) {
			postRepository.deleteById(postId);
		}

		else {
			throw new PostNotFoundException("Sorry ! Post is not available with id :" + postId);
		}

	}
	
	/******************************************
	 - Method Name      : updatePost
	 - Input Parameters : Post post
	 - Return type      : Post
	 - Author           : Harshavardhan
	 - Creation Date    : 07-03-2022
	 - Description      : Updating the values into  the database.
	  ******************************************/

	@Override
	public Post updatePost(Post post) {

		post.setPostDate(LocalDate.now());


		Optional<PostEntity> optionalPostEntity = postRepository.findById(post.getPostId());

		if (optionalPostEntity.isEmpty()) {

			throw new PostNotFoundException("Sorry ! Post is not available with id :" + post.getPostId());
		}

		PostEntity updatedPost = postRepository.save(entityModelUtil.postModelToEntity(post));

		return entityModelUtil.postEntityToModel(updatedPost);

	}
	
	/******************************************
	 - Method Name      : getCategoryDetails
	 - Input Parameters : String categoryName
	 - Return type      : Category
	 - Author           : Harshavardhan
	 - Creation Date    : 07-03-2022
	 - Description      : Getting Category details from  the database.
	  ******************************************/

	public Category getCategoryDetails(String categoryName) {

		return categoryService.getCategoryDetails(categoryName);

	}


	/******************************************
	 - Method Name      : getUserDetails
	 - Input Parameters : int userId
	 - Return type      : User
	 - Author           : Harshavardhan
	 - Creation Date    : 07-03-2022
	 - Description      : Getting user details from  the database.
	  ******************************************/
	
	public User getUserDetails(int userId) throws UserNotFoundException {
		
		return userService.getUserDetails(userId);
	}
	

	/******************************************
	 - Method Name      : getDonorDetails
	 - Input Parameters : int donorId
	 - Return type      : Donor
	 - Author           : Harshavardhan
	 - Creation Date    : 07-03-2022
	 - Description      : Getting donor details from  the database.
	  ******************************************/

	public Donor getDonorDetails(int donorId) {

		return donorService.getDonorDetails(donorId);
	}


	/******************************************
	 - Method Name      : getPostDetails
	 - Input Parameters : int postId
	 - Return type      : Post
	 - Author           : Harshavardhan
	 - Creation Date    : 07-03-2022
	 - Description      : Getting Post details from  the database.
	  ******************************************/
	
	@Override
	public Post getPostDetails(int postId) throws PostNotFoundException {

		Optional<PostEntity> optionalPostEntity = postRepository.findById(postId);
		if (optionalPostEntity.isEmpty()) {
			throw new PostNotFoundException("Sorry User is not found with id :" + postId);
		}
		return entityModelUtil.postEntityToModel(optionalPostEntity.get());
	}

}
