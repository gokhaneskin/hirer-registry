package com.hirerregistry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hirerregistry.model.Province;

@Repository("provinceRepository")
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

}
