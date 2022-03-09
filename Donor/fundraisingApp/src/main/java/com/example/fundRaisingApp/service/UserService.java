package com.example.fundRaisingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.fundRaisingApp.model.UserModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "UserServiceFallBack")

	public UserModel getUserDetails(int userId) {

		String resourceUrl = "http://user-service/sprint1/user/getbyuserid/" + userId;

		UserModel user = restTemplate.getForObject(resourceUrl, UserModel.class);

		return user;

	}

	@SuppressWarnings("unused")
	private UserModel UserServiceFallBack(int userId) {

		UserModel user = new UserModel();
		user.setUserFullName("");
		user.setUserAddress("");
		user.setUserId(userId);
		user.getUserMobile();
		user.setUserAccountNumber(0);
		user.setUserFundAmount(0);
		user.setUserDescription("");
		user.getUserId();
		user.setUserEmail("");
		user.setUserName("");

		System.out.println("User Service is down!!! fallback route enabled...");
		return user;

	}

}
