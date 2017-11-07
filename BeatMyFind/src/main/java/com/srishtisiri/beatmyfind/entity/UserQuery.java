package com.srishtisiri.beatmyfind.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User_Query")
public class UserQuery implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Query_Id")
	private int queryId;
	
	@Column(name="Query_Text")
	private String queryText;
	
	@Column(name="Query_Status")
	private String queryStatus;
	
	@ManyToOne
	@JoinColumn(name="User_Id")
	private UserDetails user;
	
	@Column(name="Creation_Date")
	private Date creationDate;
	
	@OneToMany(mappedBy = "userQuery", cascade = CascadeType.ALL)
	private List<UserComments> userCommentsList;

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

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<UserComments> getUserCommentsList() {
		return userCommentsList;
	}

	public void setUserCommentsList(List<UserComments> userCommentsList) {
		this.userCommentsList = userCommentsList;
	}
	
	@Override
	public String toString(){
		return "queryId: "+getQueryId()+" QueryStatus: "+getQueryStatus()+" queryText: "+getQueryText()+" CreationDate: "+getCreationDate();
	}
}
