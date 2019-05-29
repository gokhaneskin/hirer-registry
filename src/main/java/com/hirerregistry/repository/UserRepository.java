package com.hirerregistry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hirerregistry.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
	@Modifying
    @Transactional
    @Query("update User u set u.profilePicture = ?2 where u.id = ?1")
    int updateProfilePicture(int id, String profilePicture);
}
