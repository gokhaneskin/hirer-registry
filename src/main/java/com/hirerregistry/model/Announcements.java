package com.hirerregistry.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "announcements")
public class Announcements {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int announcement_id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;

	@Column(name = "date")
	private Date date;

	@Column(name = "type")
	private String type;

	@Column(name = "m2")
	private int m2;

	@Column(name = "room")
	private String room;

	@Column(name = "heat")
	private String heat;

	@Column(name = "active")
	private boolean active;
	
	@Column(name = "phone")
	private String phone;

	private String profilePicture;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adres_id", nullable = false)
	private Adress adress;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="announcements")
	private List<Annocomment> annocomments;

	
	@Override
	public String toString() {
		return "Announcements [announcement_id=" + announcement_id + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", date=" + date + ", type=" + type + ", m2=" + m2 + ", room=" + room + ", heat="
				+ heat + ", active=" + active + ", phone=" + phone + ", user=" + user + ", adress=" + adress
				+ ", annocomments=" + annocomments + "]";
	}

	public List<Annocomment> getAnnocomments() {
		return annocomments;
	}

	public void setAnnocomments(List<Annocomment> annocomments) {
		this.annocomments = annocomments;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAnnouncement_id() {
		return announcement_id;
	}

	public void setAnnouncement_id(int announcement_id) {
		this.announcement_id = announcement_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getHeat() {
		return heat;
	}

	public void setHeat(String heat) {
		this.heat = heat;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	

}
