package com.hirerregistry.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hirerregistry.model.User;
import com.hirerregistry.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("membership/login");
		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("membership/signup");
		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "Bu mail adresi daha önceden oluşturuldu!");
		}
		if (bindingResult.hasErrors()) {
			model.setViewName("membership/signup");
		} else {
			userService.saveUser(user);
			model.addObject("msg", "Kullanıcı Başarılı Bir Şekilde Oluşturuldu!");
			model.addObject("user", new User());
			model.setViewName("membership/login");
		}
		return model;
	}

	@RequestMapping(value = { "/","/index" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		if (user!=null) {
			model.addObject("userName", user.getFirstname() + " " + user.getLastname());
			model.addObject("userId", user.getId());
		}
		model.setViewName("index");
		return model;
	}
	@RequestMapping(value = { "/admin/deneme" }, method = RequestMethod.GET)
	public ModelAndView deneme() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/deneme");
		return model;
	}
	@RequestMapping(value = { "/access_denied" }, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
	

}
