package com.ansel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 4.11 中转公司信息表
 * @author Ansel
 *
 */
@Entity(name = "transfercominfo")
public class TransferComInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50)
	private String city;
	
	@Column(length = 50)
	private String companyName;
	
	@Column(length = 50)
	private String linkPhone;
	
	@Column(length = 200)
	private String detailAddress;

	public TransferComInfo() {
		super();
	}

	public TransferComInfo(int id, String city, String companyName, String linkPhone, String detailAddress) {
		super();
		this.id = id;
		this.city = city;
		this.companyName = companyName;
		this.linkPhone = linkPhone;
		this.detailAddress = detailAddress;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	@Override
	public String toString() {
		return "TransferComInfo [id=" + id + ", city=" + city + ", companyName=" + companyName + ", linkPhone="
				+ linkPhone + ", detailAddress=" + detailAddress + "]";
	}
	
}
