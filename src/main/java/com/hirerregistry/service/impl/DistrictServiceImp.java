package com.hirerregistry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.hirerregistry.model.District;
import com.hirerregistry.model.Province;
import com.hirerregistry.repository.DistrictRepository;
import com.hirerregistry.service.DistrictService;

@Service("districtService")
public class DistrictServiceImp implements DistrictService {

	@Autowired
	DistrictRepository districtRepository;
	
	@Query("select d from district d where d.province_id =:id")
	@Override
	public List<District> finyAllByProvinceId(@Param("id")int id) {
		return districtRepository.findAll();
	}

	@Override
	public List<District> findByProvince(Province province) {
		return districtRepository.findByProvince(province);
	}

	@Override
	public District findOne(int id) {
		return districtRepository.getOne(id);
	}

}
