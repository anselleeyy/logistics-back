package com.ansel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 4.28 地区城市表
 * 
 * @author Ansel
 *
 */
@Entity(name = "region")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50, nullable = false)
	private String city;

	public Region() {

	}

	public Region(int id, String city) {
		super();
		this.id = id;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", city=" + city + "]";
	}

}
