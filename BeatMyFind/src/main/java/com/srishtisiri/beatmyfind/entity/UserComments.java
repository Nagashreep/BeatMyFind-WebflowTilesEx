package com.srishtisiri.beatmyfind.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_COMMENTS")
public class UserComments implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Comment_Id")
	private int commentId;
	
	@Column(name="Comment_Text")
	private String commentText;
	
	@ManyToOne
	@JoinColumn(name="User_Id")
	private UserDetails user;
	
	@ManyToOne
	@JoinColumn(name="Query_Id")
	private UserQuery userQuery;
	
	@Column(name="Creation_Date")
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
	
	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	@Override
	public String toString(){
		return "CommentId: "+getCommentId()+" COmmentText: "+getCommentText()+" User: "+getUser()+" UserQuery: "+getUserQuery()+" creationDate: "+getCreationDate();
	}
}
