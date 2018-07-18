package com.ansel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 4.16 投诉信息表
 * 
 * @author Ansel
 *
 */
@Entity(name = "complaintinfo")
public class ComplaintInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50)
	private String customer;

	@Column(length = 50)
	private String goodsBillCode;

	@Column(length = 50)
	private String appealContent;

	@Column(length = 50)
	private String appealDate;

	@Column
	private boolean ifHandle;

	@Column(length = 50)
	private String dealDate;

	@Column(length = 50)
	private String dealResult;

	@Column
	private boolean ifCallback;

	@Column(length = 50)
	private String callBackDate;

	@Column(length = 50)
	private String dealPerson;

	public ComplaintInfo() {

	}

	public ComplaintInfo(int id, String customer, String goodsBillCode, String appealContent, String appealDate,
			boolean ifHandle, String dealDate, String dealResult, boolean ifCallback, String callBackDate,
			String dealPerson) {
		// super();
		this.id = id;
		this.customer = customer;
		this.goodsBillCode = goodsBillCode;
		this.appealContent = appealContent;
		this.appealDate = appealDate;
		this.ifHandle = ifHandle;
		this.dealDate = dealDate;
		this.dealResult = dealResult;
		this.ifCallback = ifCallback;
		this.callBackDate = callBackDate;
		this.dealPerson = dealPerson;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getGoodsBillCode() {
		return goodsBillCode;
	}

	public void setGoodsBillCode(String goodsBillCode) {
		this.goodsBillCode = goodsBillCode;
	}

	public String getAppealContent() {
		return appealContent;
	}

	public void setAppealContent(String appealContent) {
		this.appealContent = appealContent;
	}

	public String getAppealDate() {
		return appealDate;
	}

	public void setAppealDate(String appealDate) {
		this.appealDate = appealDate;
	}

	public boolean getIfHandle() {
		return ifHandle;
	}

	public void setIfHandle(boolean ifHandle) {
		this.ifHandle = ifHandle;
	}

	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public String getDealResult() {
		return dealResult;
	}

	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}

	public boolean getIfCallback() {
		return ifCallback;
	}

	public void setIfCallback(boolean ifCallback) {
		this.ifCallback = ifCallback;
	}

	public String getCallBackDate() {
		return callBackDate;
	}

	public void setCallBackDate(String callBackDate) {
		this.callBackDate = callBackDate;
	}

	public String getDealPerson() {
		return dealPerson;
	}

	public void setDealPerson(String dealPerson) {
		this.dealPerson = dealPerson;
	}

	@Override
	public String toString() {
		return "ComplaintInfo [id=" + id + ", customer=" + customer + ", goodsBillCode=" + goodsBillCode
				+ ", appealContent=" + appealContent + ", appealDate=" + appealDate + ", ifHandle=" + ifHandle
				+ ", dealDate=" + dealDate + ", dealResult=" + dealResult + ", ifCallback=" + ifCallback
				+ ", callBackDate=" + callBackDate + ", dealPerson=" + dealPerson + "]";
	}

}
