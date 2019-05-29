package com.hirerregistry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hirerregistry.model.User;
import com.hirerregistry.model.Usercomment;

@Repository("usercommentRepository")
public interface UsercommentRepository extends JpaRepository<Usercomment, Integer> {
	List<Usercomment> findByUser(User user);
}
