package com.hirerregistry.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hirerregistry.model.Role;
import com.hirerregistry.model.User;
import com.hirerregistry.repository.RoleRepository;
import com.hirerregistry.repository.UserRepository;
import com.hirerregistry.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRespository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(0);
		Role userRole=roleRespository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public int updateProfilePicture(int id, String profilePicture) {
		return userRepository.updateProfilePicture(id, profilePicture);
	}


}
