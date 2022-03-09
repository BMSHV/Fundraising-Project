package com.example.fundRaisingApp.service;

import java.util.List;

import com.example.fundRaisingApp.model.DonorModel;
import com.example.fundRaisingApp.model.UserModel;

public interface DonorServiceInterface {

	public DonorModel addDonorAmount(DonorModel donorModel);

	public DonorModel getDonorDetailsByDonorId(int donorId);

	public DonorModel updateDonorDetailsByDonorId(DonorModel donorModel);

	public void deleteDonorDetailsByDonorId(int donorId);

	public UserModel getUserDetailsByUserId(int userId);
	
	public List<DonorModel> getAllDonors();

}
