package com.abc.fundraising.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.fundraising.entity.AdminEntity;
import com.abc.fundraising.exception.AdminNotFoundException;
import com.abc.fundraising.exception.PostNotFoundException;
import com.abc.fundraising.model.Admin;
import com.abc.fundraising.model.AdminDetails;
import com.abc.fundraising.model.Category;
import com.abc.fundraising.model.Donor;
import com.abc.fundraising.model.Post;
import com.abc.fundraising.model.User;
import com.abc.fundraising.repository.AdminRepository;
import com.abc.fundraising.util.EntityModelUtil;

@Service
public class AdminServiceImpl implements AdminService {

	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PostService postService;

	@Autowired
	private DonorService donarService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;

	@Override
	public Admin saveAdmin(Admin admin) {

		AdminEntity savedAdmin = adminRepository.save(EntityModelUtil.adminModelToEntity(admin));

		return EntityModelUtil.adminEntityToModel(savedAdmin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		List<AdminEntity> admin = adminRepository.findAll();
		return EntityModelUtil.adminEntityToModelList(admin);
	}

	@Override
	public AdminDetails getAdminById(int adminId) throws AdminNotFoundException {

		AdminDetails admindetails = new AdminDetails();

		Optional<AdminEntity> optionalPost = adminRepository.findById(adminId);

		if (optionalPost.isEmpty()) {
			throw new AdminNotFoundException("Sorry! Admin is not existing with id: " + adminId);
		}
		AdminEntity admin = optionalPost.get();
		admindetails.setAdmin(EntityModelUtil.adminEntityToModel(admin));
		Donor donor = donarService.getDonorDetails(admin.getDonorId());
		Category category = categoryService.getCategoryDetails(admin.getCategoryId());
		Post post = postService.getPostDetails(admin.getPostId());
		User user = userService.getUserDetails(admin.getUserId());

		admindetails.setDonor(donor);
		admindetails.setCategory(category);
		admindetails.setPost(post);
		admindetails.setUser(user);

		return admindetails;

	}

	@Override
	public void deleteAdmin(int adminId) {

		Optional<AdminEntity> optionalPost = adminRepository.findById(adminId);

		if (optionalPost.isPresent()) {
			adminRepository.deleteById(adminId);
		} else {
			throw new AdminNotFoundException("Sorry! Admin is not existing with id: " + adminId);
		}
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Optional<AdminEntity> optionalUserEntity = adminRepository.findById(admin.getAdminId());

		if (optionalUserEntity.isEmpty()) {
			throw new AdminNotFoundException("Sorry! User is not existing with id: " + admin.getAdminId());
		}

		AdminEntity updatedAdminEntity = adminRepository.save(EntityModelUtil.adminModelToEntity(admin));
		System.out.println("Updated the admin details");

		return EntityModelUtil.adminEntityToModel(updatedAdminEntity);
	}

	public User getUserDetails(int userId) {

		User user = userService.getUserDetails(userId);
		return user;

	}

	public Donor getDonorDetails(int donorId) {

		Donor donor = donarService.getDonorDetails(donorId);
		return donor;
	}

	public Post getPostDetails(int postId) {

		Post post = postService.getPostDetails(postId);
		return post;
	}

	@Override
	public Category getCategotyDetails(int categoryId) {
		Category category = categoryService.getCategoryDetails(categoryId);
		return category;
	}

	@Override
	public Admin getAdminDetails(int adminId) {
		Optional<AdminEntity> optionalAdminEntity = adminRepository.findById(adminId);
		if(optionalAdminEntity.isEmpty()) {
			throw new PostNotFoundException("Sorry Admin is not found with id :" +adminId);
		}
		return EntityModelUtil.adminEntityToModel(optionalAdminEntity.get());
	}

}