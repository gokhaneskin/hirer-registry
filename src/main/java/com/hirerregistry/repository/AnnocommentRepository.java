package com.hirerregistry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hirerregistry.model.Annocomment;
import com.hirerregistry.model.Announcements;

@Repository("annocommentRepository")
public interface AnnocommentRepository extends JpaRepository<Annocomment, Integer> {
	List<Annocomment> findByAnnouncements(Announcements announcements);
}
