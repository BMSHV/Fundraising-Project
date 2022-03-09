package com.abc.fundraising.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.fundraising.entity.AdminEntity;

@Repository
public interface AdminRepository  extends JpaRepository<AdminEntity,Integer>
{

}
