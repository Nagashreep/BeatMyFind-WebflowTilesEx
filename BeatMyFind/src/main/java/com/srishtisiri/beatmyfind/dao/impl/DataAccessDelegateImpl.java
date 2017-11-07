package com.srishtisiri.beatmyfind.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.srishtisiri.beatmyfind.dao.DataAccessDelegate;
import com.srishtisiri.beatmyfind.entity.UserDetails;
import com.srishtisiri.beatmyfind.entity.UserQuery;
import com.srishtisiri.beatmyfind.entity.UserQueryStatus;

@Repository
public class DataAccessDelegateImpl implements DataAccessDelegate{
	
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public UserDetails fetchUserDetails(UserDetails user){
		List<UserDetails> userDetailsList = null;
		try{
			Map<String,String> criteriaMap = new HashMap<String,String>();
			criteriaMap.put("userName", user.getUserName());
			criteriaMap.put("userPassword", user.getUserPassword());
			Session session = this.sessionFactory.openSession();
			Criteria criretia = session.createCriteria(UserDetails.class);
			userDetailsList = criretia.add(Restrictions.allEq(criteriaMap)).list();
			session.close();
			System.out.println("List from DB: "+userDetailsList);
			if(null==userDetailsList || userDetailsList.isEmpty()){
				//invalid user details
			}else if(userDetailsList.size()>1){
				//should never happen 
			}else{
				return userDetailsList.get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public UserDetails saveUser(UserDetails user){
		Session session = this.sessionFactory.openSession();
		try{
			System.out.println("Before saving in delegate");
			session.save(user);
			System.out.println("After saving in delegate: "+user.getUserId());
		}catch(Exception e){
			e.printStackTrace();
		}
		session.close();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserQuery> fetchOpenQueries(){
		Session session = this.sessionFactory.openSession();
		List<UserQuery> userQueries = new ArrayList<UserQuery>();
		try{
			System.out.println("Before fetching open queries");
			Criteria criretia = session.createCriteria(UserQuery.class);
			userQueries = criretia.add(Restrictions.eq("queryStatus", UserQueryStatus.OPEN.toString())).list();
			System.out.println("After fetching open queries:Size>> "+userQueries.size());
			System.out.println("List from DB: "+userQueries);
			System.out.println("List from DB:.Comment "+userQueries.get(0).getUserCommentsList());
			if(userQueries.get(0).getUserCommentsList()!=null){
				System.out.println(userQueries.get(0).getUserCommentsList().get(0).getCommentText());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.close();
		return userQueries;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserQuery> fetchExpiredQueries(){
		Session session = this.sessionFactory.openSession();
		List<UserQuery> userQueries = new ArrayList<UserQuery>();
		try{
			System.out.println("Before fetching expired queries");
			Criteria criretia = session.createCriteria(UserQuery.class);
			userQueries = criretia.add(Restrictions.eq("queryStatus", UserQueryStatus.EXPIRED.toString()).ignoreCase()).list();
			System.out.println("After fetching expired queries:Size>> "+userQueries.size());
		}catch(Exception e){
			e.printStackTrace();
		}
		session.close();
		return userQueries;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserQuery> fetchClosedQueries(){
		Session session = this.sessionFactory.openSession();
		List<UserQuery> userQueries = new ArrayList<UserQuery>();
		try{
			System.out.println("Before fetching closed queries");
			Criteria criretia = session.createCriteria(UserQuery.class);
			userQueries = criretia.add(Restrictions.eq("queryStatus", UserQueryStatus.CLOSED.toString()).ignoreCase()).list();
			System.out.println("After fetching closed queries:Size>> "+userQueries.size());
		}catch(Exception e){
			e.printStackTrace();
		}
		session.close();
		return userQueries;
	}
	
	public UserQuery fetchQueryDetails(int queryId){
		UserQuery userQuery = null;
		Session session = this.sessionFactory.openSession();
		try{
			System.out.println("Before fetching user query");
			Criteria criretia = session.createCriteria(UserQuery.class);
			userQuery = (UserQuery) criretia.add(Restrictions.eq("queryId", queryId)).uniqueResult();
			System.out.println("After fetching user query>> "+userQuery);
		}catch(Exception e){
			e.printStackTrace();
		}
		return userQuery;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
