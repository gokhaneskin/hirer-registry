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
@Table(name="district")
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int district_id;
	
	@Column(name="district")
	private String district;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "province_id", nullable = false)
	private Province province;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="district")
	private List<Adress> adresses;

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}
	
}
