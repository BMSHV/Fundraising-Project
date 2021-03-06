package com.springboot.sprint1.controller;

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

import com.springboot.sprint1.model.AllDetails;
import com.springboot.sprint1.model.Category;
import com.springboot.sprint1.model.Donor;
import com.springboot.sprint1.model.Post;
import com.springboot.sprint1.model.User;
import com.springboot.sprint1.service.CategoryService;
import com.springboot.sprint1.service.DonorService;
import com.springboot.sprint1.service.PostService;
import com.springboot.sprint1.service.UserService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DonorService donorService;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		return new ResponseEntity<>(postService.createPost(post),HttpStatus.CREATED);
				
	}
	
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> deletePost(@PathVariable("uid") int postId) {
		postService.deletePost(postId);
		return new ResponseEntity<>("Post Deleted with id: "+postId, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Post> updatePost(@RequestBody Post post) {
		
		return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
	}	
	
	@GetMapping("/get/{uid}")
	public ResponseEntity<?> fetchProductDetails(@PathVariable("uid") int postId) {
		AllDetails post = postService.getPostById(postId);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	@GetMapping("/getbycategoryname/{categoryname}")
	public Category fetchCategoryByUserId(@PathVariable("categoryname") String categoryName){
		return categoryService.getCategoryDetails(categoryName);
	}
	
	@GetMapping("/getbyuserid/{userid}")
	public ResponseEntity<User> fetchUser(@PathVariable("userid") int userId){
		User user = userService.getUserDetails(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	@GetMapping("/getbydonorid/{donorid}")
	public Donor fetchDonor(@PathVariable("donorid") int donorId){
		return donorService.getDonorDetails(donorId);
		
	}
	
	@GetMapping("/getbypostid/{id}")
	public ResponseEntity<?> fetchPost(@PathVariable("id") int postId) {
		return new ResponseEntity<>(postService.getPostDetails(postId), HttpStatus.OK);
	}

}
