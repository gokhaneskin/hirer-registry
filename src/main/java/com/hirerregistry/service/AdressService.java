package com.hirerregistry.service;

import java.util.List;

import com.hirerregistry.model.Adress;
import com.hirerregistry.model.District;

public interface AdressService {
	List<Adress> findAll();
	List<Adress> findByDistrict(District district);
	Adress findOne(int id);
}
