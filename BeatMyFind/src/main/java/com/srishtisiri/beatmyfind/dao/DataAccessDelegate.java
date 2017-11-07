package com.srishtisiri.beatmyfind.dao;

import java.util.List;

import com.srishtisiri.beatmyfind.entity.UserDetails;
import com.srishtisiri.beatmyfind.entity.UserQuery;

public interface DataAccessDelegate {
	
	public UserDetails fetchUserDetails(UserDetails user);
	
	public UserDetails saveUser(UserDetails user);
	
	public List<UserQuery> fetchOpenQueries();
	
	public List<UserQuery> fetchClosedQueries();
	
	public List<UserQuery> fetchExpiredQueries();
	
	public UserQuery fetchQueryDetails(int queryId);

}
