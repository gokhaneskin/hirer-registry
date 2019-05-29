package com.hirerregistry.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hirerregistry.model.Annocomment;
import com.hirerregistry.model.Announcements;
import com.hirerregistry.model.Province;
import com.hirerregistry.model.User;
import com.hirerregistry.service.AdressService;
import com.hirerregistry.service.AnnocommentService;
import com.hirerregistry.service.AnnouncementsService;
import com.hirerregistry.service.ProvinceService;
import com.hirerregistry.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	AnnouncementsService announcementsService;
	@Autowired
	UserService userService;
	@Autowired
	AdressService adressService;
	@Autowired
	ProvinceService provinceService;
	@Autowired
	AnnocommentService annocommentService;

	@Value("${app.user.root}")
	private String userRoot;

	@Value("${app.anno.root}")
	private String annoRoot;
	
	@RequestMapping(value = "/annoPicture-picture/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] annoPicture(@PathVariable("id") int id) throws IOException {

		Announcements announcement = announcementsService.findOne(id);

		String profilePicture = annoRoot + File.separator + announcement.getAnnouncement_id() + File.separator + announcement.getProfilePicture();
		if (new File(profilePicture).exists()) {
			return IOUtils.toByteArray(new FileInputStream(profilePicture));
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/uploadAnnoPhoto/{id}", method = RequestMethod.POST)
	public String uploadAnnoPhoto(@RequestParam("file") MultipartFile file, @PathVariable("id") int id) {
		Announcements announcement = announcementsService.findOne(id);
		String fileName = announcement.getAnnouncement_id() + "_thumbnail.jpg";
		if (!file.isEmpty()) {
			try {
				String saveDirectory = annoRoot + File.separator + announcement.getAnnouncement_id() + File.separator;
				File test = new File(saveDirectory);
				if (!test.exists()) {
					test.mkdirs();
				}

				byte[] bytes = file.getBytes();

				ByteArrayInputStream imageInputStream = new ByteArrayInputStream(bytes);
				BufferedImage image = ImageIO.read(imageInputStream);
				BufferedImage thumbnail = Scalr.resize(image, 600);

				File thumbnailOut = new File(saveDirectory + fileName);
				ImageIO.write(thumbnail, "png", thumbnailOut);

				announcement.setProfilePicture(fileName);
				announcementsService.saveAnnouncement(announcement);
				System.out.println("Image Saved::: " + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/user/profile/myprofile";

	}

	@RequestMapping(value = { "/profile/addAnnoPhoto/{id}" }, method = RequestMethod.GET)
	public ModelAndView addAnnoPhoto(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("user", user);
		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		Announcements announcement = announcementsService.findOne(id);
		if (announcement.getUser() == user) {
			model.addObject("announcement", announcement);
			model.setViewName("user/profile/addAnnoPhoto");
		} else {

			model.setViewName("errors/access_denied");
		}

		return model;
	}

	@RequestMapping(value = "/userprofile-picture/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] userPicture(@PathVariable("id") int id) throws IOException {

		User u = userService.findById(id);

		String profilePicture = userRoot + File.separator + u.getId() + File.separator + u.getProfilePicture();
		if (new File(profilePicture).exists()) {
			return IOUtils.toByteArray(new FileInputStream(profilePicture));
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/profile-picture", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] profilePicture() throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = userService.findUserByEmail(auth.getName());

		String profilePicture = userRoot + File.separator + u.getId() + File.separator + u.getProfilePicture();
		if (new File(profilePicture).exists()) {
			return IOUtils.toByteArray(new FileInputStream(profilePicture));
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		String fileName = user.getEmail() + "_thumbnail.jpg";
		if (!file.isEmpty()) {
			try {
				String saveDirectory = userRoot + File.separator + user.getId() + File.separator;
				File test = new File(saveDirectory);
				if (!test.exists()) {
					test.mkdirs();
				}

				byte[] bytes = file.getBytes();

				ByteArrayInputStream imageInputStream = new ByteArrayInputStream(bytes);
				BufferedImage image = ImageIO.read(imageInputStream);
				BufferedImage thumbnail = Scalr.resize(image, 200);

				File thumbnailOut = new File(saveDirectory + fileName);
				ImageIO.write(thumbnail, "png", thumbnailOut);

				userService.updateProfilePicture(user.getId(), fileName);
				System.out.println("Image Saved::: " + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/user/profile/myprofile";
	}

	@RequestMapping(value = { "/profile/myprofile" }, method = RequestMethod.GET)
	public ModelAndView loadMyProfile() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("user", user);
		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		List<Province> provinces = provinceService.findAll();
		model.addObject("provinces", provinces);
		List<Announcements> announcements = announcementsService.findByUser(user);
		model.addObject("announcements", announcements);
		model.setViewName("user/profile/myprofile");
		return model;
	}

	@RequestMapping(value = { "/profile/myAnnoDetail/{id}" }, method = RequestMethod.GET)
	public ModelAndView loadMyAnnoDetail(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("user", user);
		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		List<Province> provinces = provinceService.findAll();
		model.addObject("provinces", provinces);
		Announcements announcement = announcementsService.findOne(id);
		if (announcement.getUser() == user) {
			model.addObject("announcement", announcement);
			model.setViewName("user/profile/myAnnoDetail");
		} else {

			model.setViewName("errors/access_denied");
		}

		return model;
	}

	@RequestMapping(value = { "/profile/user_detail/{id}" }, method = RequestMethod.GET)
	public ModelAndView loadProfile(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView();
		User hirerUser = userService.findById(id);
		model.addObject("hirerUser", hirerUser);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		model.setViewName("user/profile/user_detail");
		return model;
	}

	@RequestMapping(value = { "/ajax" }, method = RequestMethod.GET)
	public ModelAndView ajax() {

		ModelAndView model = new ModelAndView();
		List<Announcements> announcements = announcementsService.findAll();
		model.addObject("announcementList", announcements);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		model.setViewName("user/ajaxdeneme");
		return model;
	}

	@RequestMapping(value = { "/announcements" }, method = RequestMethod.GET)
	public ModelAndView announcementList() {
		ModelAndView model = new ModelAndView();
		List<Announcements> announcements = announcementsService.findAll();
		model.addObject("announcementList", announcements);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		List<Province> provinces = provinceService.findAll();
		model.addObject("provinces", provinces);
		model.setViewName("user/announcements");
		return model;
	}

	@RequestMapping(value = { "/announcement_detail/{id}" }, method = RequestMethod.GET)
	public ModelAndView announcementDetail(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView();
		Announcements announcement = announcementsService.findOne(id);
		model.addObject("announcement", announcement);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		List<Annocomment> annocomments = annocommentService.findByAnnouncements(announcement);
		model.addObject("annocomments", annocomments);
		model.setViewName("user/announcement_detail");
		return model;
	}
}
