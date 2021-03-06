package com.abc.fundraising.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.fundraising.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserService 
{
	@Autowired
	private RestTemplate restTemplate;

 @HystrixCommand(fallbackMethod = "userServiceFallBack", commandProperties = { 
    		 
    		 @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    		 ,@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
    		 @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
    		 @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
    		 
    		 
     })

	public User getUserDetails(int userId) {

		String resourceUrl = "http://user-service/sprint1/user/getbyuserid/" +userId;

		User user = restTemplate.getForObject(resourceUrl, User.class);

		return user;

	}

	@SuppressWarnings("unused")
	private User userServiceFallBack(int userId) {
		
		User user = new User();
		user.setUserId(userId);
		user.setUserName("");
		user.setUserFullName("");
		user.setUserMobile("");
		user.setUserEmail("");
		user.setUserAccountNumber(0);
		user.setCategoryName("");
		user.setUserAddress("");
		user.setUserFundAmount(0);
		user.setUserDescription("");
		user.setUserFundAmount(0);
		
		System.out.println("User Service is down!!! fallback route enabled...");
		return user;

		/*
		 * return
		 * "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. "
		 * + " Service will be back shortly - " + LocalDate.now();
		 */
	}

}
