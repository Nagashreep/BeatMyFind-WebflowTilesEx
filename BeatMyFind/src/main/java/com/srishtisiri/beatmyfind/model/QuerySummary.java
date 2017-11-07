package com.srishtisiri.beatmyfind.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuerySummary implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Query> userQueryList;
	private Comment newUserComment;
	private Query query;
	
	public List<Query> getUserQueryList() {
		return userQueryList;
	}
	public void setUserQueryList(List<Query> userQueryList) {
		this.userQueryList = userQueryList;
	}
	public Comment getNewUserComment() {
		return newUserComment;
	}
	public void setNewUserComment(Comment newUserComment) {
		this.newUserComment = newUserComment;
	}
	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	
	
}
