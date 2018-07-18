package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 4.15 杂费结算表
 * @author Ansel
 *
 */
@Entity(name = "extraclear")
public class ExtraClear {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50)
	private String subjectName;
	
	@Column
	private double balanceMoney;
	
	@Column(length = 50)
	private String remark;
	
	@Column
	private Date balanceDate;
	
	@Column(length = 50)
	private String balanceType;

	public ExtraClear() {
		super();
	}

	public ExtraClear(int id, String subjectName, double balanceMoney, String remark, Date balanceDate,
			String balanceType) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.balanceMoney = balanceMoney;
		this.remark = remark;
		this.balanceDate = balanceDate;
		this.balanceType = balanceType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public double getBalanceMoney() {
		return balanceMoney;
	}

	public void setBalanceMoney(double balanceMoney) {
		this.balanceMoney = balanceMoney;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(String balanceType) {
		this.balanceType = balanceType;
	}

	@Override
	public String toString() {
		return "ExtraClear [id=" + id + ", subjectName=" + subjectName + ", balanceMoney=" + balanceMoney + ", remark="
				+ remark + ", balanceDate=" + balanceDate + ", balanceType=" + balanceType + "]";
	}

}
