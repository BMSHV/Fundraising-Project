package com.springboot.sprint1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.sprint1.model.User;

@Service
public class UserService {
	
	@Autowired
	private RestTemplate restTemplate;

     @HystrixCommand(fallbackMethod = "userServiceFallBack")

	public User getUserDetails(int userId) {

		String resourceUrl = "http://user-service/sprint1/user/getbyuserid/" + userId;


		return restTemplate.getForObject(resourceUrl, User.class);

	}

	@SuppressWarnings("unused")
	private User userServiceFallBack(int userId) {
		
		User user = new User();
		user.setUserFullName("");
		user.setUserAddress("");
		user.setUserId(userId);
		user.setUserMobile("");
		user.setUserAccountNumber(0);
		user.setUserFundAmount(0);
		user.setUserDescription("");
		user.setUserIdProof("");
		user.setUserEmail("");
		user.setUserName("");
		

		System.out.println("User Service is down!!! fallback route enabled...");
		return user;

	}


}
