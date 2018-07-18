package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 4.13 客户运单结算表
 * 
 * @author Ansel
 *
 */
@Entity(name = "customerbillclear")
public class CustomerBillClear {
	@Column
	private String CustomerCode;
	
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(length = 50)
	private String goodsBillCode;

	@Column
	private double billMoney;

	@Column
	private double moneyReceivable;

	@Column
	private double receivedMoney;

	@Column
	private double prepayMoney;

	@Column
	private double carriageReduceFund;

	@Column
	private double balance;

	@Column
	private Date balanceTime;

	@Column
	private double insurance;

	@Column
	private double payKickback;

	@Column
	private double carryGoodsFee;

	@Column(length = 50)
	private String balanceType;

	public CustomerBillClear() {
		super();
	}

	public CustomerBillClear(String customerCode, String goodsBillCode, double billMoney, double moneyReceivable,
			double receivedMoney, double prepayMoney, double carriageReduceFund, double balance, Date balanceTime,
			double insurance, double payKickback, double carryGoodsFee, String balanceType) {
		super();
		CustomerCode = customerCode;
		this.goodsBillCode = goodsBillCode;
		this.billMoney = billMoney;
		this.moneyReceivable = moneyReceivable;
		this.receivedMoney = receivedMoney;
		this.prepayMoney = prepayMoney;
		this.carriageReduceFund = carriageReduceFund;
		this.balance = balance;
		this.balanceTime = balanceTime;
		this.insurance = insurance;
		this.payKickback = payKickback;
		this.carryGoodsFee = carryGoodsFee;
		this.balanceType = balanceType;
	}

	public String getCustomerCode() {
		return CustomerCode;
	}

	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}

	public String getGoodsBillCode() {
		return goodsBillCode;
	}

	public void setGoodsBillCode(String goodsBillCode) {
		this.goodsBillCode = goodsBillCode;
	}

	public double getBillMoney() {
		return billMoney;
	}

	public void setBillMoney(double billMoney) {
		this.billMoney = billMoney;
	}

	public double getMoneyReceivable() {
		return moneyReceivable;
	}

	public void setMoneyReceivable(double moneyReceivable) {
		this.moneyReceivable = moneyReceivable;
	}

	public double getReceivedMoney() {
		return receivedMoney;
	}

	public void setReceivedMoney(double receivedMoney) {
		this.receivedMoney = receivedMoney;
	}

	public double getPrepayMoney() {
		return prepayMoney;
	}

	public void setPrepayMoney(double prepayMoney) {
		this.prepayMoney = prepayMoney;
	}

	public double getCarriageReduceFund() {
		return carriageReduceFund;
	}

	public void setCarriageReduceFund(double carriageReduceFund) {
		this.carriageReduceFund = carriageReduceFund;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getBalanceTime() {
		return balanceTime;
	}

	public void setBalanceTime(Date balanceTime) {
		this.balanceTime = balanceTime;
	}

	public double getInsurance() {
		return insurance;
	}

	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}

	public double getPayKickback() {
		return payKickback;
	}

	public void setPayKickback(double payKickback) {
		this.payKickback = payKickback;
	}

	public double getCarryGoodsFee() {
		return carryGoodsFee;
	}

	public void setCarryGoodsFee(double carryGoodsFee) {
		this.carryGoodsFee = carryGoodsFee;
	}

	public String getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(String balanceType) {
		this.balanceType = balanceType;
	}

	@Override
	public String toString() {
		return "CustomerBillClear [CustomerCode=" + CustomerCode + ", goodsBillCode=" + goodsBillCode + ", billMoney="
				+ billMoney + ", moneyReceivable=" + moneyReceivable + ", receivedMoney=" + receivedMoney
				+ ", prepayMoney=" + prepayMoney + ", carriageReduceFund=" + carriageReduceFund + ", balance=" + balance
				+ ", balanceTime=" + balanceTime + ", insurance=" + insurance + ", payKickback=" + payKickback
				+ ", carryGoodsFee=" + carryGoodsFee + ", balanceType=" + balanceType + "]";
	}

	
	

}
