package com.ansel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 4.29 城市扩充表
 * @author Ansel
 *
 */
@Entity(name = "cityexpand")
public class CityExpand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int cityId;

	@Column(length = 50)
	private String rangeCity;

	public CityExpand() {

	}

	public CityExpand(int id, int cityId, String rangeCity) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.rangeCity = rangeCity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getRangeCity() {
		return rangeCity;
	}

	public void setRangeCity(String rangeCity) {
		this.rangeCity = rangeCity;
	}

	@Override
	public String toString() {
		return "CityExpand [id=" + id + ", cityId=" + cityId + ", rangeCity=" + rangeCity + "]";
	}

}
