package com.hirerregistry.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="annocomment")
public class Annocomment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ancom_id;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "announcement_id", nullable = false)
	private Announcements announcements;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Override
	public String toString() {
		return "Annocomment [ancom_id=" + ancom_id + ", comment=" + comment + ", date=" + date + ", announcements="
				+ announcements + ", user=" + user + "]";
	}

	public Announcements getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(Announcements announcements) {
		this.announcements = announcements;
	}

	public int getAncom_id() {
		return ancom_id;
	}

	public void setAncom_id(int ancom_id) {
		this.ancom_id = ancom_id;
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

	
}
