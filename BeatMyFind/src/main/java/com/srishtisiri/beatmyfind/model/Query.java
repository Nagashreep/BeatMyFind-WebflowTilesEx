package com.srishtisiri.beatmyfind.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Query implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int queryId;
	
	private String queryText;
	
	private String queryStatus;
	
	private User userName;
	
	private Date creationDate;
	
	private List<Comment> userCommentsList;

	public List<Comment> getUserCommentsList() {
		return userCommentsList;
	}

	public void setUserCommentsList(List<Comment> userCommentsList) {
		this.userCommentsList = userCommentsList;
	}

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(String queryStatus) {
		this.queryStatus = queryStatus;
	}

	public User getUserName() {
		return userName;
	}

	public void setUserName(User userName) {
		this.userName = userName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString(){
		return "queryId: "+getQueryId()+" QueryStatus: "+getQueryStatus()+" queryText: "+getQueryText()+" CreationDate: "+getCreationDate();
	}

}
