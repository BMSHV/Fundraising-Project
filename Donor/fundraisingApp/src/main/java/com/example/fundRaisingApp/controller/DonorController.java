package com.example.fundRaisingApp.controller;

import java.util.List;

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

import com.example.fundRaisingApp.model.DonorModel;
import com.example.fundRaisingApp.model.UserModel;
import com.example.fundRaisingApp.service.DonorServiceInterface;
import com.example.fundRaisingApp.service.UserService;



@RestController
@RequestMapping("/donor")
public class DonorController {

	@Autowired
	private DonorServiceInterface donorServiceInterface;
	
	@Autowired
	private UserService userService;


	
	@PostMapping("/saveamount")
	public ResponseEntity<DonorModel> saveDonorAmount(@RequestBody DonorModel donorModel) {
		DonorModel donorModelAddAmountController = donorServiceInterface.addDonorAmount(donorModel);

		ResponseEntity<DonorModel> responseEntityAddAmountController = new ResponseEntity<>(
				donorModelAddAmountController, HttpStatus.CREATED);
		return responseEntityAddAmountController;
	}

	
	@GetMapping("getbyid/{gid}")
	public ResponseEntity<?> getDetailsByDonorId(@PathVariable("gid") int donorId) {
		DonorModel donorModelGetByDonorId = donorServiceInterface.getDonorDetailsByDonorId(donorId);

		ResponseEntity<?> responseEntityDetailsController = new ResponseEntity<>(donorModelGetByDonorId, HttpStatus.OK);
		return responseEntityDetailsController;
	}

	
	@DeleteMapping("/delete/{did}")
	public ResponseEntity<?> deleteDetailsByDonorId(@PathVariable("did") int donorId) {
		donorServiceInterface.deleteDonorDetailsByDonorId(donorId);
		return new ResponseEntity<>("Donor details Deleted", HttpStatus.OK);
	}


	
	@PutMapping("/update")
	public ResponseEntity<?> updateDeatailsByDonorId(@RequestBody DonorModel donorModel) {

		DonorModel donorModelUpdateByDonorId = donorServiceInterface.updateDonorDetailsByDonorId(donorModel);

		ResponseEntity<?> responseEntityUpdateController = new ResponseEntity<>(donorModelUpdateByDonorId,
				HttpStatus.ACCEPTED);

		return responseEntityUpdateController;

	}

	
	@GetMapping("/userid/{uid}")
	public UserModel getDetailsByUserId(@PathVariable("uid") int userId) {
		UserModel userModel= userService.getUserDetails(userId);
		return userModel;
	}
	
	@GetMapping("/alldetails")
	public List<DonorModel> getAllDonorDetails()
	{
		List<DonorModel> listAllDonorDetailsController=donorServiceInterface.getAllDonors();
		return listAllDonorDetailsController;
	}

}
