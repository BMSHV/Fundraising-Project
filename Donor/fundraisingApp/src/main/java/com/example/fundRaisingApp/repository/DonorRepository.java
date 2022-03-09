package com.example.fundRaisingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fundRaisingApp.entity.DonorEntity;

@Repository
public interface DonorRepository extends JpaRepository<DonorEntity, Integer> {



}
