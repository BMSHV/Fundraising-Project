package com.example.fundRaisingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fundRaisingApp.entity.DonorEntity;
import com.example.fundRaisingApp.exception.IdNotFoundException;
import com.example.fundRaisingApp.model.DonorModel;
import com.example.fundRaisingApp.model.UserModel;
import com.example.fundRaisingApp.repository.DonorRepository;
import com.example.fundRaisingApp.util.Conversions;

@Service
public class DonorServiceImpl implements DonorServiceInterface {




	@Autowired
	private DonorRepository donorRepository;


	@Override
	public DonorModel addDonorAmount(DonorModel donorModel) {

		DonorEntity donorEntityAmount = donorRepository.save(Conversions.modelToEntity(donorModel));

		return Conversions.entityToModel(donorEntityAmount);

	}

	
	@Override
	public DonorModel getDonorDetailsByDonorId(int donorId) throws IdNotFoundException {

		Optional<DonorEntity> optionalByDonorId = donorRepository.findById(donorId);

		if (optionalByDonorId.isEmpty()) {
			throw new IdNotFoundException("Sorry! The id does not exist: " + donorId);
		} else {
			return Conversions.entityToModel(optionalByDonorId.get());
		}

	}


	@Override
	public void deleteDonorDetailsByDonorId(int donorId) throws IdNotFoundException {

		Optional<DonorEntity> optionalDelete = donorRepository.findById(donorId);

		if (optionalDelete.isEmpty()) {
			throw new IdNotFoundException("Sorry! Id does not Exist: " + donorId);
		} else {
			donorRepository.deleteById(donorId);
		}

	}

	


	@Override
	public DonorModel updateDonorDetailsByDonorId(DonorModel donorModel) throws IdNotFoundException {
		DonorEntity donorEntityConverted = Conversions.modelToEntity(donorModel);

		Optional<DonorEntity> optionalUpdate = donorRepository.findById(donorEntityConverted.getDonorId());

		if (optionalUpdate.isEmpty()) {
			throw new IdNotFoundException("Sorry! Id does not exist");
		}

		DonorEntity donorEntityUpdate = donorRepository.save(donorEntityConverted);
		return Conversions.entityToModel(donorEntityUpdate);

	}

	
	
	
	@Override
	public List<DonorModel> getAllDonors() {
		
		List<DonorEntity> listDetails=donorRepository.findAll();
		
		return Conversions.donorEntityToModelList(listDetails);
		
		
	}

	public UserModel getUserDetailsByUserId(int userId)
	{
		UserModel userModel=new UserModel();
		return userModel;
		
		
	}

}
