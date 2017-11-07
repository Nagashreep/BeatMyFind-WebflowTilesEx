package com.srishtisiri.beatmyfind.model;

import java.io.Serializable;
import java.util.Date;

import com.srishtisiri.beatmyfind.entity.UserQuery;

public class Comment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int commentId;
	private String commentText;
	private User user;
	private UserQuery userQuery;
	private Date creationDate;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserQuery getUserQuery() {
		return userQuery;
	}
	public void setUserQuery(UserQuery userQuery) {
		this.userQuery = userQuery;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString(){
		return "CommentId: "+getCommentId()+" COmmentText: "+getCommentText()+" User: "+getUser()+" UserQuery: "+getUserQuery()+" creationDate: "+getCreationDate();
	}


}
