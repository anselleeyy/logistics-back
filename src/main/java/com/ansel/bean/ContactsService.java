package com.ansel.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 4.43 打印�?来业�?
 * 
 * @author lenovo
 *
 */
@Entity(name = "contactsservice")
public class ContactsService {
	
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(length = 50)
	private String sendGoodsCustomer;// 发货客户
	
	@Column(length = 50)
	private String goodsBillCode;// 货运单编�?
	
	@Column(length = 50)
	private String sendGoodsAddr;// 发货地址
	
	@Column(length = 50)
	private String receiveGoodsAddr;// 收货地址
	
	private double carriage;// 运费
	private double insurance;// 保险�?
	private double billMoney;// 实际总运�?
	private double moneyReceivable;// 应收金额
	private double receivedMoney;// 已收金额
	private double balance;// 余额
	private Date sendGoodsDate;// 发货日期
	
	public ContactsService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactsService( String sendGoodsCustomer, String goodsBillCode, String sendGoodsAddr,
			String receiveGoodsAddr, double carriage, double insurance, double billMoney, double moneyReceivable,
			double receivedMoney, double balance, Date sendGoodsDate) {
		super();
		this.sendGoodsCustomer = sendGoodsCustomer;
		this.goodsBillCode = goodsBillCode;
		this.sendGoodsAddr = sendGoodsAddr;
		this.receiveGoodsAddr = receiveGoodsAddr;
		this.carriage = carriage;
		this.insurance = insurance;
		this.billMoney = billMoney;
		this.moneyReceivable = moneyReceivable;
		this.receivedMoney = receivedMoney;
		this.balance = balance;
		this.sendGoodsDate = sendGoodsDate;
	}

	

	public String getSendGoodsCustomer() {
		return sendGoodsCustomer;
	}

	public void setSendGoodsCustomer(String sendGoodsCustomer) {
		this.sendGoodsCustomer = sendGoodsCustomer;
	}

	public String getGoodsBillCode() {
		return goodsBillCode;
	}

	public void setGoodsBillCode(String goodsBillCode) {
		this.goodsBillCode = goodsBillCode;
	}

	public String getSendGoodsAddr() {
		return sendGoodsAddr;
	}

	public void setSendGoodsAddr(String sendGoodsAddr) {
		this.sendGoodsAddr = sendGoodsAddr;
	}

	public String getReceiveGoodsAddr() {
		return receiveGoodsAddr;
	}

	public void setReceiveGoodsAddr(String receiveGoodsAddr) {
		this.receiveGoodsAddr = receiveGoodsAddr;
	}

	public double getCarriage() {
		return carriage;
	}

	public void setCarriage(double carriage) {
		this.carriage = carriage;
	}

	public double getInsurance() {
		return insurance;
	}

	public void setInsurance(double insurance) {
		this.insurance = insurance;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getSendGoodsDate() {
		return sendGoodsDate;
	}

	public void setSendGoodsDate(Date sendGoodsDate) {
		this.sendGoodsDate = sendGoodsDate;
	}

	@Override
	public String toString() {
		return "ContactsService [sendGoodsCustomer=" + sendGoodsCustomer + ", goodsBillCode="
				+ goodsBillCode + ", sendGoodsAddr=" + sendGoodsAddr + ", receiveGoodsAddr=" + receiveGoodsAddr
				+ ", carriage=" + carriage + ", insurance=" + insurance + ", billMoney=" + billMoney
				+ ", moneyReceivable=" + moneyReceivable + ", receivedMoney=" + receivedMoney + ", balance=" + balance
				+ ", sendGoodsDate=" + sendGoodsDate + "]";
	}

}
