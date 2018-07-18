package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 4.22 财务费用表
 * 
 * @author Ansel
 *
 */
@Entity(name = "financefee")
public class FinanceFee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double fee;
	private String payoutMonth;
	private Date writeDate;

	public FinanceFee() {

	}

	public FinanceFee(int id, double fee, String payoutMonth, Date writeDate) {
		super();
		this.id = id;
		this.fee = fee;
		this.payoutMonth = payoutMonth;
		this.writeDate = writeDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getPayoutMonth() {
		return payoutMonth;
	}

	public void setPayoutMonth(String payoutMonth) {
		this.payoutMonth = payoutMonth;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "FinanceFee [id=" + id + ", fee=" + fee + ", payoutMonth=" + payoutMonth + ", writeDate="
				+ writeDate + "]";
	}

}
