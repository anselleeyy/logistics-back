package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 4.7 客户回执信息表
 * 
 * @author Ansel
 *
 */
@Entity(name = "customerreceiptinfo")
public class CustomerReceiptInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50)
	private String goodsBillCode;
	
	@Column(length = 50)
	private String customer;
	
	@Column(length = 50)
	private String checkGoodsRecord;
	
	@Column(length = 50)
	private String receiveGoodsPerson;
	
	@Column
	private Date receiveGoodsDate;
	
	private int carryBillEventId;

	public CustomerReceiptInfo() {
		super();
	}

	public CustomerReceiptInfo(int id, String goodsBillCode, String customer, String checkGoodsRecord,
			String receiveGoodsPerson, Date receiveGoodsDate, int carryBillEventId) {
		super();
		this.id = id;
		this.goodsBillCode = goodsBillCode;
		this.customer = customer;
		this.checkGoodsRecord = checkGoodsRecord;
		this.receiveGoodsPerson = receiveGoodsPerson;
		this.receiveGoodsDate = receiveGoodsDate;
		this.carryBillEventId = carryBillEventId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodsBillCode() {
		return goodsBillCode;
	}

	public void setGoodsBillCode(String goodsBillCode) {
		this.goodsBillCode = goodsBillCode;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCheckGoodsRecord() {
		return checkGoodsRecord;
	}

	public void setCheckGoodsRecord(String checkGoodsRecord) {
		this.checkGoodsRecord = checkGoodsRecord;
	}

	public String getReceiveGoodsPerson() {
		return receiveGoodsPerson;
	}

	public void setReceiveGoodsPerson(String receiveGoodsPerson) {
		this.receiveGoodsPerson = receiveGoodsPerson;
	}

	public Date getReceiveGoodsDate() {
		return receiveGoodsDate;
	}

	public void setReceiveGoodsDate(Date receiveGoodsDate) {
		this.receiveGoodsDate = receiveGoodsDate;
	}

	public int getCarryBillEventId() {
		return carryBillEventId;
	}

	public void setCarryBillEventId(int carryBillEventId) {
		this.carryBillEventId = carryBillEventId;
	}

	@Override
	public String toString() {
		return "CustomerReceiptInfo [id=" + id + ", goodsBillCode=" + goodsBillCode + ", customer=" + customer
				+ ", checkGoodsRecord=" + checkGoodsRecord + ", receiveGoodsPerson=" + receiveGoodsPerson
				+ ", receiveGoodsDate=" + receiveGoodsDate + ", carryBillEventId=" + carryBillEventId + "]";
	}

}
