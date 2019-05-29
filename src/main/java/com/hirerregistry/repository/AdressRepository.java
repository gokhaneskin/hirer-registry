package com.hirerregistry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hirerregistry.model.Adress;
import com.hirerregistry.model.District;

@Repository("adressRepository")
public interface AdressRepository extends JpaRepository<Adress, Integer> {
	List<Adress> findByDistrict(District district);
}
