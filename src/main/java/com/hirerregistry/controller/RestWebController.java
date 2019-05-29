package com.hirerregistry.controller;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hirerregistry.model.Adress;
import com.hirerregistry.model.Annocomment;
import com.hirerregistry.model.Announcements;
import com.hirerregistry.model.District;
import com.hirerregistry.model.Province;
import com.hirerregistry.model.User;
import com.hirerregistry.model.Usercomment;
import com.hirerregistry.service.AdressService;
import com.hirerregistry.service.AnnocommentService;
import com.hirerregistry.service.AnnouncementsService;
import com.hirerregistry.service.DistrictService;
import com.hirerregistry.service.ProvinceService;
import com.hirerregistry.service.UserService;
import com.hirerregistry.service.UsercommentService;

@RestController
@RequestMapping("/api")
public class RestWebController {
	@Autowired
	DistrictService districtService;
	@Autowired
	ProvinceService provinceService;
	@Autowired
	AdressService adressService;
	@Autowired
	AnnouncementsService announcementService;
	@Autowired
	UserService userService;
	@Autowired
	AnnocommentService annocommentService;
	@Autowired
	UsercommentService usercommentService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "/updatePassword/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String updatePassword(@PathVariable int id,User userget) {
		User user=userService.findById(id);
		user.setPassword(bCryptPasswordEncoder.encode(userget.getPassword()));
		userService.updateUser(user);
//		user.setActive(0);
//		userService.updateUser(user);
		return "Başarılı";
	}
	
	@RequestMapping(value = "/unactivedUser/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String unactivedUser(@PathVariable int id) {
		User user=userService.findById(id);
		user.setActive(0);
		userService.updateUser(user);
		return "Başarılı";
	}
	
	@RequestMapping(value = "/activedUser/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String activedUser(@PathVariable int id) {
		User user=userService.findById(id);
		user.setActive(1);
		userService.updateUser(user);
		return "Başarılı";
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.POST)
	public String getUsers() {
		List<User> users=userService.findAll();
		JSONArray array = new JSONArray();
		for (User a : users) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", a.getId());
				object.put("firstname", a.getFirstname());
				object.put("lastname", a.getLastname());
				object.put("username", a.getEmail());
				object.put("active", a.getActive());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			array.put(object);
		}
		return array.toString();
	}
	
	@RequestMapping(value = "/updateAnnouncement/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String updateAnnouncement(@PathVariable int id,Announcements announcements) {
		Announcements announcement=announcementService.findOne(id);
		announcement.setDescription(announcements.getDescription());
		announcement.setHeat(announcements.getHeat());
		announcement.setM2(announcements.getM2());
		announcement.setPhone(announcements.getPhone());
		announcement.setPrice(announcements.getPrice());
		announcement.setRoom(announcements.getRoom());
		announcement.setTitle(announcements.getTitle());
		System.out.println(announcement.getHeat()+" "+announcement.getM2()+" "+announcement.getDescription());
		announcementService.saveAnnouncement(announcement);
		return "Başarılı";
	}
	
	@RequestMapping(value = "/activeFalse/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String activeFalseAnnouncement(@PathVariable int id) {
		Announcements announcement=announcementService.findOne(id);
		announcement.setActive(false);
		announcementService.saveAnnouncement(announcement);
		return "Başarılı";
	}
	
	@RequestMapping(value = "/deleteAnnouncement/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String deleteAnnouncement(@PathVariable int id) {
		System.out.println(id);
		announcementService.deleteAnnouncement(id);
		return "Başarılı";
	}
	
	@RequestMapping(value = "/saveUsercomment/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String saveUsercomment(@PathVariable int id,Usercomment usercomment) {
		Date date = new Date();
		User user=userService.findById(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User usercom = userService.findUserByEmail(auth.getName());
		usercomment.setDate(date);
		usercomment.setUser(user);
		usercomment.setComuser(usercom);
		System.out.println(usercomment.toString());
		usercommentService.saveUsercomment(usercomment);
		return "Başarılı";
	}
	
	
	@RequestMapping(value = "/usercomments/{id}", method = RequestMethod.POST)
	public String getusercomment(@PathVariable int id) {
		User user=userService.findById(id);
		List<Usercomment> usercomments=usercommentService.findByUsers(user);
		JSONArray array = new JSONArray();
		for (Usercomment a : usercomments) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", a.getUsercom_id());
				object.put("comment", a.getComment());
				object.put("date", a.getDate());
				object.put("userId", a.getComuser().getId());
				object.put("user", a.getComuser().getFirstname()+" "+a.getComuser().getLastname());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			array.put(object);
		}
		return array.toString();
	}
	
	
	@RequestMapping(value = "/saveAnnocomment/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String saveAnnocomment(@PathVariable int id,Annocomment annocomment) {
		Date date = new Date();
		Announcements announcements=announcementService.findOne(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		annocomment.setDate(date);
		annocomment.setUser(user);
		annocomment.setAnnouncements(announcements);
		annocommentService.saveAnnocomment(annocomment);
		return "Başarılı";
	}
	
	@RequestMapping(value = "/annocomments/{id}", method = RequestMethod.POST)
	public String getAnnocomment(@PathVariable int id) {
		Announcements announcement=announcementService.findOne(id);
		
		List<Annocomment> annocomments=annocommentService.findByAnnouncements(announcement);
		
		
		JSONArray array = new JSONArray();
		for (Annocomment a : annocomments) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", a.getAncom_id());
				object.put("comment", a.getComment());
				object.put("date", a.getDate());
				object.put("userId", a.getUser().getId());
				object.put("user", a.getUser().getFirstname()+" "+a.getUser().getLastname());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			array.put(object);
		}
		return array.toString();
	}
	
	
	@RequestMapping(value = "/saveAnnouncement", method = RequestMethod.POST)
	@ResponseBody
	public String saveAnnouncement(Announcements announcements) {
		Date date = new Date();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		announcements.setDate(date);
		announcements.setUser(user);
		announcements.setActive(true);
		System.out.println(announcements.toString());
		announcementService.saveAnnouncement(announcements);
		return null;
	}

	@RequestMapping(value = "/announcementsByUser/{id}", method = RequestMethod.POST)
	public String getAnnouncementsByUser(@PathVariable int id) {
		User user = userService.findById(id);
		List<Announcements> announcements = announcementService.findByUser(user);
		JSONArray array = new JSONArray();
		for (Announcements a : announcements) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", a.getAnnouncement_id());
				object.put("title", a.getTitle());
				object.put("price", a.getPrice());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			array.put(object);
		}
		return array.toString();
	}

	@RequestMapping(value = "/announcements/{id}", method = RequestMethod.POST)
	public String getAnnouncementsByAdressId(@PathVariable int id) {
		Adress adress = adressService.findOne(id);
		List<Announcements> announcements = announcementService.findByAdress(adress);
		JSONArray array = new JSONArray();
		for (Announcements a : announcements) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", a.getAnnouncement_id());
				object.put("title", a.getTitle());
				object.put("district", a.getAdress().getDistrict().getDistrict());
				object.put("adress", a.getAdress().getAdress());
				object.put("province", a.getAdress().getDistrict().getProvince().getProvince());
				object.put("price", a.getPrice());
				object.put("userid", a.getUser().getId());
				object.put("user", a.getUser().getFirstname() + " " + a.getUser().getLastname());
				object.put("date", a.getDate());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			array.put(object);
		}
		return array.toString();
	}

	@RequestMapping(value = "/adress/{id}", method = RequestMethod.POST)
	public String getAdressByDistrictId(@PathVariable int id) {
		System.out.println("Buraya geldi => " + id);
		District district = districtService.findOne(id);
		List<Adress> adresses = adressService.findByDistrict(district);
		JSONArray array = new JSONArray();
		for (Adress a : adresses) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", a.getAddress_id());
				object.put("name", a.getAdress());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			array.put(object);
		}
		return array.toString();
	}

	@RequestMapping(value = "/district/{id}", method = RequestMethod.POST)
	public String getDistrictByProvinceId(@PathVariable int id) {
		System.out.println("Buraya geldi => " + id);
		Province province = provinceService.findOne(id);
		List<District> districts = districtService.findByProvince(province);
		JSONArray array = new JSONArray();
		for (District d : districts) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", d.getDistrict_id());
				object.put("name", d.getDistrict());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			array.put(object);
		}
		return array.toString();
	}

}
