package com.abc.usersprint.util;

import com.abc.usersprint.entity.UserEntity;
import com.abc.usersprint.model.User;

public class EntityModelUtil {

	public static UserEntity userModelToEntity(User user) {

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(user.getUserId());
		userEntity.setUserFullName(user.getUserFullName());
		userEntity.setUserName(user.getUserName());
		userEntity.setUserEmail(user.getUserEmail());
		userEntity.setUserMobile(user.getUserMobile());
		userEntity.setUserDescription(user.getUserDescription());
		userEntity.setUserIdProof(user.getUserIdProof());
		userEntity.setCategoryName(user.getCategoryName());
		userEntity.setUserAddress(user.getUserAddress());
		userEntity.setUserFundAmount(user.getUserFundAmount());
		userEntity.setUserAccountNumber(user.getUserAccountNumber());
		return userEntity;

	}

	public static User userEntityToModel(UserEntity userEntity) {

		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setUserFullName(userEntity.getUserFullName());
		user.setUserName(userEntity.getUserName());
		user.setUserEmail(userEntity.getUserEmail());
		user.setUserMobile(userEntity.getUserMobile());
        user.setUserDescription(userEntity.getUserDescription());
        user.setUserIdProof(userEntity.getUserIdProof());
        user.setCategoryName(userEntity.getCategoryName());
        user.setUserAddress(userEntity.getUserAddress());
        user.setUserFundAmount(userEntity.getUserFundAmount());
        user.setUserAccountNumber(userEntity.getUserAccountNumber());    

		return user;

	}
	

}
