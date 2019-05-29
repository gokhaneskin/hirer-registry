package com.hirerregistry.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "password")
	private String password;

	@Column(name = "active")
	private int active;
	
	private String profilePicture;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	private List<Announcements> announcements;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	private List<Annocomment> annocomments;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	private List<Usercomment> usercomment;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="comuser")
	private List<Usercomment> comuser;

	
	
	public List<Usercomment> getUsercomment() {
		return usercomment;
	}

	public void setUsercomment(List<Usercomment> usercomment) {
		this.usercomment = usercomment;
	}

	public List<Usercomment> getComuser() {
		return comuser;
	}

	public void setComuser(List<Usercomment> comuser) {
		this.comuser = comuser;
	}

	public List<Annocomment> getAnnocomments() {
		return annocomments;
	}

	public void setAnnocomments(List<Annocomment> annocomments) {
		this.annocomments = annocomments;
	}

	public void setAnnouncements(List<Announcements> announcements) {
		this.announcements = announcements;
	}

	public List<Announcements> getAnnouncements() {
		return announcements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
}
