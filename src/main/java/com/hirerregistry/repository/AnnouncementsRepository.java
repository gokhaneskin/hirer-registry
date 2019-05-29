package com.hirerregistry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hirerregistry.model.Adress;
import com.hirerregistry.model.Announcements;
import com.hirerregistry.model.User;

@Repository("announcementsRepository")
public interface AnnouncementsRepository extends JpaRepository<Announcements, Integer>{
	List<Announcements> findByAdressAndActiveTrue(Adress adress);
	List<Announcements> findAllByActiveTrue();
	List<Announcements> findByUser(User user);
}
