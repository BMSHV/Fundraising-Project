package com.example.fundRaisingApp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.fundRaisingApp.entity.DonorEntity;
import com.example.fundRaisingApp.model.DonorModel;

public class Conversions {

	public static DonorEntity modelToEntity(DonorModel donorModel) {

		DonorEntity donorEntity = new DonorEntity();

		donorEntity.setDonorId(donorModel.getDonorId());
		donorEntity.setDonorName(donorModel.getDonorName());
		donorEntity.setDonorEmail(donorModel.getDonorEmail());
		donorEntity.setDonorAddress(donorModel.getDonorAddress());
		donorEntity.setDonorNumber(donorModel.getDonorNumber());
		donorEntity.setDonorAmount(donorModel.getDonorAmount());
		donorEntity.setUserId(donorModel.getUserId());

		return donorEntity;

	}

	public static DonorModel entityToModel(DonorEntity donorEntity) {

		DonorModel donorModel = new DonorModel();

		donorModel.setDonorId(donorEntity.getDonorId());
		donorModel.setDonorName(donorEntity.getDonorName());
		donorModel.setDonorEmail(donorEntity.getDonorEmail());
		donorModel.setDonorAddress(donorEntity.getDonorAddress());
		donorModel.setDonorNumber(donorEntity.getDonorNumber());
		donorModel.setDonorAmount(donorEntity.getDonorAmount());
		donorModel.setUserId(donorEntity.getUserId());

		return donorModel;

	}
	
	
	
	
	/*public static Optional<DonorModel> optionalDonorEntityToModel(Optional<DonorEntity>)
	{
		
			
		
		
		
		
		
		
	}*/
	
	public static List<DonorModel> donorEntityToModelList(List<DonorEntity> entityList) {

		List<DonorModel> donorList = new ArrayList<>();

		entityList.forEach(entity -> {
			DonorModel donor = new DonorModel();
			donor.setDonorId(entity.getDonorId());
			donor.setDonorAddress(entity.getDonorAddress());
			donor.setDonorName(entity.getDonorName());
			donor.setDonorEmail(entity.getDonorEmail());
			donor.setDonorNumber(entity.getDonorNumber());
			donor.setDonorAmount(entity.getDonorAmount());
			
			donorList.add(donor);
		});

		return donorList;
	}

}
