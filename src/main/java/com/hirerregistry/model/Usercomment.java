package com.hirerregistry.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "usercomment")
public class Usercomment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int usercom_id;

	@Column(name = "comment")
	private String comment;

	@Column(name = "date")
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comuser_id", nullable = false)
	private User comuser;

	public int getUsercom_id() {
		return usercom_id;
	}

	public void setUsercom_id(int usercom_id) {
		this.usercom_id = usercom_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getComuser() {
		return comuser;
	}

	public void setComuser(User comuser) {
		this.comuser = comuser;
	}

	@Override
	public String toString() {
		return "Usercomment [usercom_id=" + usercom_id + ", comment=" + comment + ", date=" + date + ", user=" + user
				+ ", comuser=" + comuser + "]";
	}
	
	
}
