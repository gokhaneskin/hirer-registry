package com.hirerregistry.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="addresses")
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int address_id;
	
	@Column(name="address")
	private String adress;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="adress")
	private List<Announcements> announcements;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id", nullable = false)
	private District district;

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<Announcements> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<Announcements> announcements) {
		this.announcements = announcements;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
}
