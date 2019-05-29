package com.hirerregistry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirerregistry.model.Province;
import com.hirerregistry.repository.ProvinceRepository;
import com.hirerregistry.service.ProvinceService;

@Service("provinceService")
public class ProvinceServiceImp implements ProvinceService {

	@Autowired
	ProvinceRepository provinceRepository;
	
	@Override
	public List<Province> findAll() {
		return provinceRepository.findAll();
	}

	@Override
	public Province findOne(int id) {
		return provinceRepository.getOne(id);
	}

}
