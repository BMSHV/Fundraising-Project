package com.abc.usersprint.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.usersprint.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

	public Optional<UserEntity> findByUserIdProof(String idProof); 
	
	
	
}
