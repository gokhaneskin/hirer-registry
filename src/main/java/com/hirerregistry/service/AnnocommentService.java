package com.hirerregistry.service;

import java.util.List;

import com.hirerregistry.model.Annocomment;
import com.hirerregistry.model.Announcements;

public interface AnnocommentService {
	List<Annocomment> findAll();
	List<Annocomment> findByAnnouncements(Announcements announcements);
	Annocomment findOne(int id);
	Annocomment saveAnnocomment(Annocomment annocomment);
	void deleteAnnocomment(int id);
}
