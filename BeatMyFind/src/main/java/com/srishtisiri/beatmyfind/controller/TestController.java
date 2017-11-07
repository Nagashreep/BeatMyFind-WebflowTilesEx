package com.srishtisiri.beatmyfind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srishtisiri.beatmyfind.dao.impl.DataAccessDelegateImpl;

@RestController
public class TestController {
	
	@Autowired
	public DataAccessDelegateImpl dataAccessDelegateImpl;
	
	@RequestMapping(value="/test")
	public String printUserDetails(){
//		dataAccessDelegateImpl.fetchUserDetails();
		return "home";
	}

}
