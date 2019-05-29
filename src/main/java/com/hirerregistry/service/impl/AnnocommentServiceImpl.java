package com.hirerregistry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirerregistry.model.Annocomment;
import com.hirerregistry.model.Announcements;
import com.hirerregistry.repository.AnnocommentRepository;
import com.hirerregistry.service.AnnocommentService;

@Service("annocommentService")
public class AnnocommentServiceImpl implements AnnocommentService {

	@Autowired
	AnnocommentRepository annocommentRepository;
	
	@Override
	public List<Annocomment> findAll() {
		return annocommentRepository.findAll();
	}

	@Override
	public Annocomment findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annocomment saveAnnocomment(Annocomment annocomment) {
		// TODO Auto-generated method stub
		return annocommentRepository.save(annocomment);
	}

	@Override
	public void deleteAnnocomment(int id) {
		

	}

	@Override
	public List<Annocomment> findByAnnouncements(Announcements announcements) {
		// TODO Auto-generated method stub
		return annocommentRepository.findByAnnouncements(announcements);
	}

}
