package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 4.14 代收货款结算表
 * 
 * @author Ansel
 *
 */
@Entity(name = "proxyfeeclear")
public class ProxyFeeClear {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(length = 50)
	private String goodsBillCode;

	@Column(length = 50)
	private String customerCode;

	@Column
	private double accountReceivable;

	@Column
	private double factReceiveFund;

	@Column
	private double goodsPayChange;

	@Column(length = 15)
	private float commisionRate;

	@Column
	private double commisionReceivable;

	@Column
	private double receivedCommision;

	@Column
	private Date balanceDate;

	public ProxyFeeClear() {
		super();
	}

	public ProxyFeeClear(String goodsBillCode, String customerCode, double accountReceivable, double factReceiveFund,
			double goodsPayChange, float commisionRate, double commisionReceivable, double receivedCommision,
			Date balanceDate) {
		super();
		this.goodsBillCode = goodsBillCode;
		this.customerCode = customerCode;
		this.accountReceivable = accountReceivable;
		this.factReceiveFund = factReceiveFund;
		this.goodsPayChange = goodsPayChange;
		this.commisionRate = commisionRate;
		this.commisionReceivable = commisionReceivable;
		this.receivedCommision = receivedCommision;
		this.balanceDate = balanceDate;
	}

	public String getGoodsBillCode() {
		return goodsBillCode;
	}

	public void setGoodsBillCode(String goodsBillCode) {
		this.goodsBillCode = goodsBillCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public double getAccountReceivable() {
		return accountReceivable;
	}

	public void setAccountReceivable(double accountReceivable) {
		this.accountReceivable = accountReceivable;
	}

	public double getFactReceiveFund() {
		return factReceiveFund;
	}

	public void setFactReceiveFund(double factReceiveFund) {
		this.factReceiveFund = factReceiveFund;
	}

	public double getGoodsPayChange() {
		return goodsPayChange;
	}

	public void setGoodsPayChange(double goodsPayChange) {
		this.goodsPayChange = goodsPayChange;
	}

	public float getCommisionRate() {
		return commisionRate;
	}

	public void setCommisionRate(float commisionRate) {
		this.commisionRate = commisionRate;
	}

	public double getCommisionReceivable() {
		return commisionReceivable;
	}

	public void setCommisionReceivable(double commisionReceivable) {
		this.commisionReceivable = commisionReceivable;
	}

	public double getReceivedCommision() {
		return receivedCommision;
	}

	public void setReceivedCommision(double receivedCommision) {
		this.receivedCommision = receivedCommision;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	@Override
	public String toString() {
		return "ProxyFeeClear [goodsBillCode=" + goodsBillCode + ", customerCode=" + customerCode
				+ ", accountReceivable=" + accountReceivable + ", factReceiveFund=" + factReceiveFund
				+ ", goodsPayChange=" + goodsPayChange + ", commisionRate=" + commisionRate + ", commisionReceivable="
				+ commisionReceivable + ", receivedCommision=" + receivedCommision + ", balanceDate=" + balanceDate
				+ "]";
	}

}
