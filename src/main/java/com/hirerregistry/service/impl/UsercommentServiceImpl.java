package com.hirerregistry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirerregistry.model.User;
import com.hirerregistry.model.Usercomment;
import com.hirerregistry.repository.UsercommentRepository;
import com.hirerregistry.service.UsercommentService;

@Service("usercommentService")
public class UsercommentServiceImpl implements UsercommentService {

	@Autowired
	UsercommentRepository usercommentRepository;
	
	@Override
	public List<Usercomment> findAll() {
		
		return usercommentRepository.findAll();
	}

	@Override
	public List<Usercomment> findByUsers(User user) {
		return usercommentRepository.findByUser(user);
	}

	@Override
	public Usercomment findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usercomment saveUsercomment(Usercomment usercomment) {
		return usercommentRepository.save(usercomment);
	}

	@Override
	public void deleteUsercomment(int id) {
		// TODO Auto-generated method stub

	}

}
