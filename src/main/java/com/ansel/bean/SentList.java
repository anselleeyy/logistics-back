package com.ansel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 4.39 装货发车清单
 * 
 * @author lenovo
 *
 */
@Entity
@Table(name = "sentlist")
public class SentList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;// 序号
	
	private int userId;// 用户ID

	@Column(length = 50)
	private String sendGoodsCustomer;// 发货客户
	
	@Column(length = 50)
	private String goodsName;// 货物名称
	
	@Column(length = 50)
	private String goodsCode;// 货物编号
	
	@Column(length = 50)
	private String transferDestination;// 中转目的�?
	
	@Column(length = 50)
	private String sendGoodsCustomerTel;// 发货客户电话
	
	private double cashPay;// 现付
	
	private double pickupPay;// 提付
	
	private double backCost;// 回结
	
	@Column(length = 50)
	private String helpAcceptFund;// 代收�?
	
	@Column(length = 50)
	private String remark;// 备注
	
	@Column(length = 50)
	private String driverName;// 司机名称
	
	@Column(length = 50)
	private String carCardNo;// 车牌�?
	
	@Column(length = 50)
	private String mobile;// 手机
	
	private int pieceAmount;// 件数
	
	@Column(length = 50)
	private String goodsRevertBillCode;// 货运回执单编�?

	public SentList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SentList(int id, int userId, String sendGoodsCustomer, String goodsName, String goodsCode,
			String transferDestination, String sendGoodsCustomerTel, double cashPay, double pickupPay, double backCost,
			String helpAcceptFund, String remark, String driverName, String carCardNo, String mobile, int pieceAmount,
			String goodsRevertBillCode) {
		super();
		this.id = id;
		this.userId = userId;
		this.sendGoodsCustomer = sendGoodsCustomer;
		this.goodsName = goodsName;
		this.goodsCode = goodsCode;
		this.transferDestination = transferDestination;
		this.sendGoodsCustomerTel = sendGoodsCustomerTel;
		this.cashPay = cashPay;
		this.pickupPay = pickupPay;
		this.backCost = backCost;
		this.helpAcceptFund = helpAcceptFund;
		this.remark = remark;
		this.driverName = driverName;
		this.carCardNo = carCardNo;
		this.mobile = mobile;
		this.pieceAmount = pieceAmount;
		this.goodsRevertBillCode = goodsRevertBillCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSendGoodsCustomer() {
		return sendGoodsCustomer;
	}

	public void setSendGoodsCustomer(String sendGoodsCustomer) {
		this.sendGoodsCustomer = sendGoodsCustomer;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getTransferDestination() {
		return transferDestination;
	}

	public void setTransferDestination(String transferDestination) {
		this.transferDestination = transferDestination;
	}

	public String getSendGoodsCustomerTel() {
		return sendGoodsCustomerTel;
	}

	public void setSendGoodsCustomerTel(String sendGoodsCustomerTel) {
		this.sendGoodsCustomerTel = sendGoodsCustomerTel;
	}

	public double getCashPay() {
		return cashPay;
	}

	public void setCashPay(double cashPay) {
		this.cashPay = cashPay;
	}

	public double getPickupPay() {
		return pickupPay;
	}

	public void setPickupPay(double pickupPay) {
		this.pickupPay = pickupPay;
	}

	public double getBackCost() {
		return backCost;
	}

	public void setBackCost(double backCost) {
		this.backCost = backCost;
	}

	public String getHelpAcceptFund() {
		return helpAcceptFund;
	}

	public void setHelpAcceptFund(String helpAcceptFund) {
		this.helpAcceptFund = helpAcceptFund;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCarCardNo() {
		return carCardNo;
	}

	public void setCarCardNo(String carCardNo) {
		this.carCardNo = carCardNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getPieceAmount() {
		return pieceAmount;
	}

	public void setPieceAmount(int pieceAmount) {
		this.pieceAmount = pieceAmount;
	}

	public String getGoodsRevertBillCode() {
		return goodsRevertBillCode;
	}

	public void setGoodsRevertBillCode(String goodsRevertBillCode) {
		this.goodsRevertBillCode = goodsRevertBillCode;
	}

	@Override
	public String toString() {
		return "SentList [id=" + id + ", userId=" + userId + ", sendGoodsCustomer=" + sendGoodsCustomer + ", goodsName="
				+ goodsName + ", goodsCode=" + goodsCode + ", transferDestination=" + transferDestination
				+ ", sendGoodsCustomerTel=" + sendGoodsCustomerTel + ", cashPay=" + cashPay + ", pickupPay=" + pickupPay
				+ ", backCost=" + backCost + ", helpAcceptFund=" + helpAcceptFund + ", remark=" + remark
				+ ", driverName=" + driverName + ", carCardNo=" + carCardNo + ", mobile=" + mobile + ", pieceAmount="
				+ pieceAmount + ", goodsRevertBillCode=" + goodsRevertBillCode + "]";
	}

}
