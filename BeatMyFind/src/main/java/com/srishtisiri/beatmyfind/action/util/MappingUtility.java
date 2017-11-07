package com.srishtisiri.beatmyfind.action.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import com.srishtisiri.beatmyfind.entity.UserDetails;
import com.srishtisiri.beatmyfind.entity.UserQuery;
import com.srishtisiri.beatmyfind.model.Query;
import com.srishtisiri.beatmyfind.model.User;

@Component
public class MappingUtility {
	
	public List<Query> mapUserQueryListToQueryList(List<UserQuery> userQueryList){
		List<Query> queryList = new ArrayList<Query>();
		System.out.println("Inside mapUserQueryListToQueryList");
		System.out.println("Before mapping: "+userQueryList.get(0).getUserCommentsList().get(0).getCommentText());
		DozerBeanMapper mapper = new DozerBeanMapper();
		
		try{
			for(UserQuery userQuery:userQueryList){
				queryList.add(mapper.map(userQuery, Query.class));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("After mapping: "+queryList.get(0).getUserCommentsList().get(0).getCommentText());
		return queryList;
	}
	
	public UserDetails mapUserToUserDetails(User user){
		UserDetails userDetails = new UserDetails();
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.map(user, userDetails);
		return userDetails;
	}
	
	public User mapUserDetailsToUser(UserDetails userDetails){
		User user = new User();
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.map(userDetails, user);
		return user;
	}
	
	public Query mapUserQueryToQuery(UserQuery userQuery){
		Query query = new Query();
		DozerBeanMapper mapper = new DozerBeanMapper();
		System.out.println("Inside mapping util, before mapping: "+userQuery);
		mapper.map(userQuery, query);
		System.out.println("Inside mapping util, after mapping: "+query);
		return query;
		
		
	}

}
