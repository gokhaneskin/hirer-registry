package com.hirerregistry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hirerregistry.model.District;
import com.hirerregistry.model.Province;

@Repository("districtRepository")
public interface DistrictRepository extends JpaRepository<District, Integer>{
	List<District> findByProvince(Province province);
}
