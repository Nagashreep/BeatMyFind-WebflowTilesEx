package com.srishtisiri.beatmyfind.action;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srishtisiri.beatmyfind.action.util.MappingUtility;
import com.srishtisiri.beatmyfind.dao.impl.DataAccessDelegateImpl;
import com.srishtisiri.beatmyfind.entity.UserQuery;
import com.srishtisiri.beatmyfind.model.Query;
import com.srishtisiri.beatmyfind.model.QuerySummary;

@Service
public class QuerySummaryAction {
	
	@Autowired
	private DataAccessDelegateImpl delegateImpl;
	
	@Autowired
	private MappingUtility mappingUtil;
	
	public QuerySummary fetchOpenQueries(){
		QuerySummary querySummary = new QuerySummary();
		List<UserQuery> userQueryList =  delegateImpl.fetchOpenQueries();
		if(null!=userQueryList && !userQueryList.isEmpty()){
			System.out.println("Before mapping: "+userQueryList.size());
			List<Query> queryList = mappingUtil.mapUserQueryListToQueryList(userQueryList);
			System.out.println("After mapping: "+queryList.size());
			
			querySummary.setUserQueryList(queryList);
		}
		System.out.println("In service class..after fetching open queries");
		return querySummary;
	}
	
	public QuerySummary fetchClosedQueries(){
		QuerySummary querySummary = new QuerySummary();
		List<UserQuery> userQueryList =  delegateImpl.fetchClosedQueries();
		if(null!=userQueryList && !userQueryList.isEmpty()){
			System.out.println("Before mapping: "+userQueryList.size());
			List<Query> queryList = mappingUtil.mapUserQueryListToQueryList(userQueryList);
			System.out.println("After mapping: "+queryList.size());
			
			querySummary.setUserQueryList(queryList);
		}
		System.out.println("In service class..after fetching closed queries");
		return querySummary;
	}
	
	public QuerySummary fetchExpiredQueries(){
		QuerySummary querySummary = new QuerySummary();
		List<UserQuery> userQueryList =  delegateImpl.fetchExpiredQueries();
		if(null!=userQueryList && !userQueryList.isEmpty()){
			System.out.println("Before mapping: "+userQueryList.size());
			List<Query> queryList = mappingUtil.mapUserQueryListToQueryList(userQueryList);
			System.out.println("After mapping: "+queryList.size());
			
			querySummary.setUserQueryList(queryList);
		}
		System.out.println("In service class..after fetching expired queries");
		return querySummary;
	}
}
