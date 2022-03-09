package com.springboot.sprint1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.sprint1.model.Donor;

@Service
public class DonorService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "donorServiceFallBack")

	public Donor getDonorDetails(int donorId) {

		String resourceUrl = "http://donor-service/donorspring/donor/getbyid/" + donorId;

		return restTemplate.getForObject(resourceUrl, Donor.class);

		

	}

	@SuppressWarnings("unused")
	private Donor donorServiceFallBack(int donorId) {

		Donor donor = new Donor();
		donor.setDonorId(donorId);
		donor.setDonorName("");
		donor.setDonorAddress("");
		donor.setDonorEmail("");
		donor.setDonorAddress("");
		donor.setDonorAmount(0.0);
		

		System.out.println("Donor Service is down!!! fallback route enabled...");
		return donor;

	}

}
