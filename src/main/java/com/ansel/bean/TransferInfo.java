package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 4.10 中转信息表
 * @author Ansel
 *
 */
@Entity(name = "transferinfo")
public class TransferInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50)
	private String goodsBillCode;
	
	@Column(length = 50)
	private String transferStation;
	
	@Column(length = 50)
	private String transferCheck;
	
	@Column
	private Date checkTime;
	
	@Column(length = 50)
	private String description;
	
	@Column(length = 50)
	private String transferCompany;
	
	@Column(length = 50)
	private String transferAddr;
	
	@Column(length = 50)
	private String transferStationTel;
	
	@Column(length = 50)
	private double transferFee;
	
	@Column(length = 50)
	private String afterTransferBill;

	public TransferInfo() {
		super();
	}

	public TransferInfo(int id, String goodsBillCode, String transferStation, String transferCheck, Date checkTime,
			String description, String transferCompany, String transferAddr, String transferStationTel,
			double transferFee, String afterTransferBill) {
		super();
		this.id = id;
		this.goodsBillCode = goodsBillCode;
		this.transferStation = transferStation;
		this.transferCheck = transferCheck;
		this.checkTime = checkTime;
		this.description = description;
		this.transferCompany = transferCompany;
		this.transferAddr = transferAddr;
		this.transferStationTel = transferStationTel;
		this.transferFee = transferFee;
		this.afterTransferBill = afterTransferBill;
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

	public String getTransferStation() {
		return transferStation;
	}

	public void setTransferStation(String transferStation) {
		this.transferStation = transferStation;
	}

	public String getTransferCheck() {
		return transferCheck;
	}

	public void setTransferCheck(String transferCheck) {
		this.transferCheck = transferCheck;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransferCompany() {
		return transferCompany;
	}

	public void setTransferCompany(String transferCompany) {
		this.transferCompany = transferCompany;
	}

	public String getTransferAddr() {
		return transferAddr;
	}

	public void setTransferAddr(String transferAddr) {
		this.transferAddr = transferAddr;
	}

	public String getTransferStationTel() {
		return transferStationTel;
	}

	public void setTransferStationTel(String transferStationTel) {
		this.transferStationTel = transferStationTel;
	}

	public double getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(double transferFee) {
		this.transferFee = transferFee;
	}

	public String getAfterTransferBill() {
		return afterTransferBill;
	}

	public void setAfterTransferBill(String afterTransferBill) {
		this.afterTransferBill = afterTransferBill;
	}

	@Override
	public String toString() {
		return "TransferInfo [id=" + id + ", goodsBillCode=" + goodsBillCode + ", transferStation=" + transferStation
				+ ", transferCheck=" + transferCheck + ", checkTime=" + checkTime + ", description=" + description
				+ ", transferCompany=" + transferCompany + ", transferAddr=" + transferAddr + ", transferStationTel="
				+ transferStationTel + ", transferFee=" + transferFee + ", afterTransferBill=" + afterTransferBill
				+ "]";
	}

}
