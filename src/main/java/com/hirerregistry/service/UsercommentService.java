package com.hirerregistry.service;

import java.util.List;

import com.hirerregistry.model.User;
import com.hirerregistry.model.Usercomment;

public interface UsercommentService {
	List<Usercomment> findAll();
	List<Usercomment> findByUsers(User user);
	Usercomment findOne(int id);
	Usercomment saveUsercomment(Usercomment usercomment);
	void deleteUsercomment(int id);
}
