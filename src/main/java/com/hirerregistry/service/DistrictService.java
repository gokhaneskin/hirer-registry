package com.hirerregistry.service;

import java.util.List;


import com.hirerregistry.model.District;
import com.hirerregistry.model.Province;

public interface DistrictService {
	List<District> finyAllByProvinceId(int id);
	List<District> findByProvince(Province province);
	District findOne(int id);
}
