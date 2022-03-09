package com.abc.fundraising.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.fundraising.model.Donor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@Service
public class DonorService 
{
	    @Autowired
		private RestTemplate restTemplate;

	 @HystrixCommand(fallbackMethod = "donorServiceFallBack", commandProperties = { 
	    		 
	    		 @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	    		 ,@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
	    		 @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
	    		 @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
	    		 
	    		 
	     })

		public Donor getDonorDetails(int donorId) {

			String resourceUrl = "http://donor-service/donorspring/donor/getbyid/" + donorId;

			Donor donor = restTemplate.getForObject(resourceUrl, Donor.class);

			return donor;

		}

		@SuppressWarnings("unused")
		private Donor donorServiceFallBack(int donorId) {
			
			Donor donor = new Donor();
			donor.setDonorId(donorId);
			donor.setDonorName("");
			donor.setDonorMobile("");
			donor.setDonorEmail("");
			donor.setDonatedAmount(0);
			donor.setDonorAddress("");
			

			System.out.println("Donor Service is down!!! fallback route enabled...");
			return donor;

			/*
			 * return
			 * "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. "
			 * + " Service will be back shortly - " + LocalDate.now();
			 */
		}



	}
