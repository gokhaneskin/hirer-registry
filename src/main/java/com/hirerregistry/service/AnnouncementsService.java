package com.hirerregistry.service;

import java.util.List;

import com.hirerregistry.model.Adress;
import com.hirerregistry.model.Announcements;
import com.hirerregistry.model.User;

public interface AnnouncementsService {
	List<Announcements> findAll();
	Announcements findOne(int id);
	Announcements saveAnnouncement(Announcements announcement);
	void deleteAnnouncement(int id);
	List<Announcements> findByAdress(Adress adress);
	List<Announcements> findByUser(User user);
}
