package com.srishtisiri.beatmyfind.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

import com.srishtisiri.beatmyfind.action.util.MappingUtility;
import com.srishtisiri.beatmyfind.dao.impl.DataAccessDelegateImpl;
import com.srishtisiri.beatmyfind.entity.UserQuery;
import com.srishtisiri.beatmyfind.model.Query;
import com.srishtisiri.beatmyfind.model.QuerySummary;

@Service
public class QueryDetailsAction {
	
	@Autowired
	private DataAccessDelegateImpl delegateImpl;
	
	@Autowired
	private MappingUtility mappingUtil;
	
	public QuerySummary fetchQueryDetails(){
		QuerySummary querySummary = new QuerySummary();
		RequestContext requestContext = RequestContextHolder.getRequestContext();
		int queryId = Integer.parseInt(requestContext.getRequestParameters().get("queryId"));
		System.out.println("queryId: "+queryId);
		UserQuery userQuery = delegateImpl.fetchQueryDetails(queryId);
		Query query = mappingUtil.mapUserQueryToQuery(userQuery);
		querySummary.setQuery(query);
		return querySummary;
	}
	
	public QuerySummary addComment(){
		QuerySummary querySummary = new QuerySummary();
		System.out.println("Inside addComment action class");
		return querySummary;
	}
}
