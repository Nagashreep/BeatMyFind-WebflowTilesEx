package com.srishtisiri.beatmyfind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.srishtisiri.beatmyfind.model.User;

@Controller
public class LoginController {
	
	@RequestMapping(value="/")
	public String displayLoginForm(ModelMap model){
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	

}
