package com.hirerregistry.service;

import java.util.List;

import com.hirerregistry.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public User findById(int id);
	List<User> findAll();
	public void saveUser(User user);
	public void updateUser(User user);
	public int updateProfilePicture(int id, String profilePicture);
}
