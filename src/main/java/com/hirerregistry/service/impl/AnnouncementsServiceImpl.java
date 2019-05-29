package com.hirerregistry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirerregistry.model.Adress;
import com.hirerregistry.model.Announcements;
import com.hirerregistry.model.User;
import com.hirerregistry.repository.AnnouncementsRepository;
import com.hirerregistry.repository.UserRepository;
import com.hirerregistry.service.AnnouncementsService;

@Service("announcementsService")
public class AnnouncementsServiceImpl implements AnnouncementsService {

	@Autowired
	AnnouncementsRepository announcementsRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Announcements> findAll() {
		return announcementsRepository.findAllByActiveTrue();
	}

	@Override
	public Announcements findOne(int id) {
		return announcementsRepository.getOne(id);
	}

	@Override
	public Announcements saveAnnouncement(Announcements announcement) {
//		announcement.setActive(true);
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User user = userRepository.findByEmail(auth.getName());
//		announcement.setUser(user);
		return announcementsRepository.save(announcement);
	}

	@Override
	public void deleteAnnouncement(int id) {
		announcementsRepository.delete(id);
	}

	@Override
	public List<Announcements> findByAdress(Adress adress) {
		return announcementsRepository.findByAdressAndActiveTrue(adress);
	}

	@Override
	public List<Announcements> findByUser(User user) {
		return announcementsRepository.findByUser(user);
	}


}
