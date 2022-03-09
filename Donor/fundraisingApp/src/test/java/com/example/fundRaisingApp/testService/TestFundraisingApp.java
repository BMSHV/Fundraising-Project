package com.example.fundRaisingApp.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fundRaisingApp.entity.DonorEntity;
import com.example.fundRaisingApp.model.DonorModel;
import com.example.fundRaisingApp.repository.DonorRepository;
import com.example.fundRaisingApp.service.DonorServiceImpl;
import com.example.fundRaisingApp.service.DonorServiceInterface;
import com.example.fundRaisingApp.util.Conversions;

@SpringBootTest
public class TestFundraisingApp {
	
	
	@InjectMocks
	private DonorServiceInterface donorService=new DonorServiceImpl();
	
	@Mock
	private DonorRepository donorRepository;
	
/*	@Test
	public void testGetDonorDetailsByDonorId()
	{
		DonorModel donorModel=new DonorModel();
		donorModel.setDonorName("swapnil");
		donorModel.setDonorId(1);
		donorModel.setDonorAddress("belgaum");
		donorModel.setDonorNumber(9740124059l);
		donorModel.setDonorEmail("swapnil@gmail.com");
		donorModel.setUserId(5);
		donorModel.setDonorAmount(5000);
		
		
		int donorId=1;
		
		Optional<DonorEntity> optionalDonorEntity=Optional.of(Conversions.modelToEntity(donorModel));
		
		when(donorRepository.findById(1)).thenReturn(optionalDonorEntity);
		
		DonorModel existingDonor = donorService.getDonorDetailsByUserId(donorId);
		
		assertEquals("swapnil",existingDonor.getDonorName());
		
	}
	*/
	
	
	
	/*@Test
	public void testAddDonorAmount()
	{
		DonorModel donorModel =new DonorModel();
		donorModel.setDonorName("swapnil");
		donorModel.setDonorId(1);
		donorModel.setDonorAddress("belgaum");
		donorModel.setDonorNumber(9740124059l);
		donorModel.setDonorEmail("swapnil@gmail.com");
		donorModel.setUserId(5);
		donorModel.setDonorAmount(5000);
		
		when(donorRepository.save(Conversions.modelToEntity(donorModel))).thenReturn(Conversions.modelToEntity(donorModel));
		
		verify(donorRepository,times(1)).save(Conversions.modelToEntity(donorModel));
		
	}*/
	
	
	
/*	@Test
	public void testDeleteDonorDetailsByDonorId()
	{
		DonorModel donorModel=new DonorModel();
		donorModel.setDonorName("swapnil");
		donorModel.setDonorId(5);
		donorModel.setDonorAddress("belgaum");
		donorModel.setDonorNumber(9740124059l);
		donorModel.setDonorEmail("swapnil@gmail.com");
		donorModel.setUserId(5);
		donorModel.setDonorAmount(5000);
		
		int donorId=5;
		
		Optional<DonorEntity> optionalDonorEntity= Optional.of(Conversions.modelToEntity(donorModel));
		
		when(donorRepository.findById(5)).thenReturn(optionalDonorEntity);
		
		donorService.deleteDonorDetailsByDonorId(donorModel.getDonorId());
		
		verify(donorRepository,times(1)).deleteById(donorId);
			
	}*/
	
	
	/*@Test
	public void testUpdateDonorDetailsByDonorId()
	{
		
		DonorModel donorModel=new DonorModel();
		donorModel.setDonorId(1);
		donorModel.setDonorName("swapnil");
		donorModel.setDonorEmail("swapnil@gmail.com");
		donorModel.setDonorAddress("belgaum");
		donorModel.setDonorAmount(1000);
		donorModel.setUserId(5);
		
		DonorModel newDonor=new DonorModel();
		
		when(donorRepository.save(Conversions.modelToEntity(donorModel))).thenReturn(Conversions.modelToEntity(donorModel));
		
		
		
		
		
	}*/
	
	
	
}
