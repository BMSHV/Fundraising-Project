package com.abc.fundraising.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.fundraising.model.Post;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class PostService 
{
	 @Autowired
		private RestTemplate restTemplate;

	 @HystrixCommand(fallbackMethod = "postServiceFallBack", commandProperties = { 
	    		 
	    		 @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	    		 ,@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
	    		 @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
	    		 @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
	    		 
	    		 
	     })

		public Post getPostDetails(int postId) {

			String resourceUrl = "http://post-service/sprint1/post/getbypostid/" + postId;

			Post post = restTemplate.getForObject(resourceUrl, Post.class);

			return post;

		}

		@SuppressWarnings("unused")
		private Post postServiceFallBack(int postId) {
			Post post = new Post();
			post.setCategoryName("");
			post.setDonorId(0);
			post.setFundNeeded(0);
			post.setPostDate(LocalDate.now());
			post.setUserDescription("");
			post.setUserId(0);
			post.setPostId(postId);
 
			System.out.println("Post Service is down!!! fallback route enabled...");
			return post;

			/*
			 * return
			 * "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. "
			 * + " Service will be back shortly - " + LocalDate.now();
			 */
		}



}
