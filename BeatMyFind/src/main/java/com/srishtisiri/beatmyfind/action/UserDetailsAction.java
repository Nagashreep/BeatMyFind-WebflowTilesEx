package com.srishtisiri.beatmyfind.action;

import java.util.Date;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srishtisiri.beatmyfind.action.util.MappingUtility;
import com.srishtisiri.beatmyfind.dao.impl.DataAccessDelegateImpl;
import com.srishtisiri.beatmyfind.entity.UserDetails;
import com.srishtisiri.beatmyfind.model.User;

@Service
public class UserDetailsAction {
	
	@Autowired
	DataAccessDelegateImpl delegateImpl;
	
	@Autowired
	private MappingUtility mappingUtil;
	
	public User saveUser(User user){
		System.out.println("User object in Action class>>saveUser "+user.toString());
		UserDetails userDetails = mappingUtil.mapUserToUserDetails(user);
		userDetails.setCreationDate(new Date());
		userDetails = delegateImpl.saveUser(userDetails);
		System.out.println("UserDetails obj in Action class: "+userDetails.toString());
		User savedUser = mappingUtil.mapUserDetailsToUser(userDetails);
		return savedUser;
		
	}
	
	public User authenticateAndSetUser(User user){
		System.out.println("User object in Action class>>authenticateAndSetUser: "+user.toString());
		UserDetails userDetails = mappingUtil.mapUserToUserDetails(user);
		userDetails = delegateImpl.fetchUserDetails(userDetails);
		System.out.println("UserDetails obj in Action class: "+userDetails.toString());
		User savedUser = mappingUtil.mapUserDetailsToUser(userDetails);
		return savedUser;
	}
	
}
