package com.hirerregistry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirerregistry.model.Adress;
import com.hirerregistry.model.District;
import com.hirerregistry.repository.AdressRepository;
import com.hirerregistry.service.AdressService;

@Service("adressService")
public class AdressServiceImpl implements AdressService {

	@Autowired
	AdressRepository adressRepository;

	@Override
	public List<Adress> findAll() {
		return adressRepository.findAll();
	}

	@Override
	public Adress findOne(int id) {
		return adressRepository.getOne(id);
	}

	@Override
	public List<Adress> findByDistrict(District district) {
		return adressRepository.findByDistrict(district);
	}

}
