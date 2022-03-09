package com.abc.fundraising.util;

import java.util.ArrayList;
import java.util.List;

import com.abc.fundraising.entity.AdminEntity;

import com.abc.fundraising.model.Admin;

public class EntityModelUtil 
{
	public static AdminEntity adminModelToEntity(Admin admin)
	{
		AdminEntity adminEntity = new AdminEntity();
		
		adminEntity.setAdminId(admin.getAdminId());
		adminEntity.setAdminName(admin.getAdminName());
		adminEntity.setPostId(admin.getPostId());
		adminEntity.setUserId(admin.getUserId());
		adminEntity.setCategoryId(admin.getCategoryId());
		adminEntity.setDonorId(admin.getDonorId());
		
		
		return adminEntity;
		
	}
	
	public static Admin adminEntityToModel(AdminEntity adminEntity)
	{
		Admin admin = new Admin();
		
		admin.setAdminId(adminEntity.getAdminId());
		admin.setAdminName(adminEntity.getAdminName());
		admin.setCategoryId(adminEntity.getCategoryId());
		admin.setDonorId(adminEntity.getDonorId());
		admin.setPostId(adminEntity.getPostId());
		admin.setUserId(adminEntity.getUserId());
		
		
		return admin;
	}
	
	public static List<Admin> adminEntityToModelList(List<AdminEntity> entityList) {

		List<Admin> adminList = new ArrayList<>();

		entityList.forEach(entity -> {
			Admin admin = new Admin();
			admin.setAdminId(entity.getAdminId());
			admin.setAdminName(entity.getAdminName());
			admin.setCategoryId(entity.getCategoryId());
			admin.setPostId(entity.getPostId());
			admin.setUserId(entity.getUserId());
		adminList.add(admin);
		});

		return adminList;
		}

}
