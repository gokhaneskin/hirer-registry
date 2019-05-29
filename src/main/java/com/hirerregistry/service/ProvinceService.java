package com.hirerregistry.service;

import java.util.List;

import com.hirerregistry.model.Province;

public interface ProvinceService {
	List<Province> findAll();
	Province findOne(int id);
}
