package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 4.8 货物回执信息表
 * @author Ansel
 *
 */
@Entity(name = "goodsreceiptinfo")
public class GoodsReceiptInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50)
	private String goodsRevertCode;
	
	@Column(length = 50)
	private String driverName;
	
	@Column(length = 50)
	private String checkGoodsRecord;
	
	@Column(length = 50)
	private String receiveGoodsPerson;
	
	@Column(length = 50)
	private Date rceiveGoodsDate;

	public GoodsReceiptInfo() {
		super();
	}

	public GoodsReceiptInfo(int id, String goodsRevertCode, String driverName, String checkGoodsRecord,
			String receiveGoodsPerson, Date rceiveGoodsDate) {
		super();
		this.id = id;
		this.goodsRevertCode = goodsRevertCode;
		this.driverName = driverName;
		this.checkGoodsRecord = checkGoodsRecord;
		this.receiveGoodsPerson = receiveGoodsPerson;
		this.rceiveGoodsDate = rceiveGoodsDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodsRevertCode() {
		return goodsRevertCode;
	}

	public void setGoodsRevertCode(String goodsRevertCode) {
		this.goodsRevertCode = goodsRevertCode;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
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

	public Date getRceiveGoodsDate() {
		return rceiveGoodsDate;
	}

	public void setRceiveGoodsDate(Date rceiveGoodsDate) {
		this.rceiveGoodsDate = rceiveGoodsDate;
	}

	@Override
	public String toString() {
		return "GoodsReceiptInfo [id=" + id + ", goodsRevertCode=" + goodsRevertCode + ", driverName=" + driverName
				+ ", checkGoodsRecord=" + checkGoodsRecord + ", receiveGoodsPerson=" + receiveGoodsPerson
				+ ", rceiveGoodsDate=" + rceiveGoodsDate + "]";
	}
	
}
