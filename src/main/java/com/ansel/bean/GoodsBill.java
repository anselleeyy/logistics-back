package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 4.3 货运单主表
 * 
 * @author Ansel
 *
 */
@Entity(name = "goodsbill")
public class GoodsBill {

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(length = 50)
	private String goodsBillCode;

	@Column(length = 50)
	private String sendGoodsCustomerNo;

	@Column(length = 50)
	private String sendGoodsCustomer;

	@Column(length = 50)
	private String sendGoodsCustomerTel;

	@Column(length = 50)
	private String sendGoodsCustomerAddr;

	@Column(length = 50)
	private String receiveGoodsCustomerCode;

	@Column(length = 50)
	private String receiveGoodsCustomer;

	@Column(length = 50)
	private String receiveGoodsCustomerTel;

	@Column(length = 50)
	private String receiveGoodsCustomerAddr;

	@Column
	private Date sendGoodsDate;

	@Column(length = 50)
	private String sendGoodsAddr;

	@Column(length = 50)
	private String receiveGoodsAddr;

	@Column
	private Date predeliveryDate;

	@Column
	private Date factDealDate;

	@Column
	private double helpAcceptPayment;

	@Column(length = 50)
	private String acceptProcedureRate;

	@Column(length = 50)
	private String payMode;

	@Column(length = 50)
	private String fetchGoodsMode;

	@Column(length = 50)
	private String writeBillPerson;

	@Column
	private Date writeDate;

	@Column(length = 50)
	private boolean validity;

	@Column(length = 50)
	private boolean ifAudit;

	@Column(length = 50)
	private boolean ifSettleAccounts;

	@Column(length = 50)
	private String transferStation;

	@Column
	private double transferFee;

	@Column
	private double reduceFund;

	@Column
	private double payKickback;

	@Column
	private double moneyOfChangePay;

	@Column
	private double carryGoodsFee;

	@Column
	private double carriage;

	@Column
	private double insurance;

	@Column(length = 50)
	private String employeeCode;

	@Column(length = 50)
	private String remark;

	@Column(length = 100)
	private String acceptStation;

	public GoodsBill() {
		super();
	}

	public GoodsBill(String goodsBillCode, String sendGoodsCustomerNo, String sendGoodsCustomer,
			String sendGoodsCustomerTel, String sendGoodsCustomerAddr, String receiveGoodsCustomerCode,
			String receiveGoodsCustomer, String receiveGoodsCustomerTel, String receiveGoodsCustomerAddr,
			Date sendGoodsDate, String sendGoodsAddr, String receiveGoodsAddr, Date predeliveryDate, Date factDealDate,
			double helpAcceptPayment, String acceptProcedureRate, String payMode, String fetchGoodsMode,
			String writeBillPerson, Date writeDate, boolean validity, boolean ifAudit, boolean ifSettleAccounts,
			String transferStation, double transferFee, double reduceFund, double payKickback, double moneyOfChangePay,
			double carryGoodsFee, double carriage, double insurance, String employeeCode, String remark,
			String acceptStation) {
		super();
		this.goodsBillCode = goodsBillCode;
		this.sendGoodsCustomerNo = sendGoodsCustomerNo;
		this.sendGoodsCustomer = sendGoodsCustomer;
		this.sendGoodsCustomerTel = sendGoodsCustomerTel;
		this.sendGoodsCustomerAddr = sendGoodsCustomerAddr;
		this.receiveGoodsCustomerCode = receiveGoodsCustomerCode;
		this.receiveGoodsCustomer = receiveGoodsCustomer;
		this.receiveGoodsCustomerTel = receiveGoodsCustomerTel;
		this.receiveGoodsCustomerAddr = receiveGoodsCustomerAddr;
		this.sendGoodsDate = sendGoodsDate;
		this.sendGoodsAddr = sendGoodsAddr;
		this.receiveGoodsAddr = receiveGoodsAddr;
		this.predeliveryDate = predeliveryDate;
		this.factDealDate = factDealDate;
		this.helpAcceptPayment = helpAcceptPayment;
		this.acceptProcedureRate = acceptProcedureRate;
		this.payMode = payMode;
		this.fetchGoodsMode = fetchGoodsMode;
		this.writeBillPerson = writeBillPerson;
		this.writeDate = writeDate;
		this.validity = validity;
		this.ifAudit = ifAudit;
		this.ifSettleAccounts = ifSettleAccounts;
		this.transferStation = transferStation;
		this.transferFee = transferFee;
		this.reduceFund = reduceFund;
		this.payKickback = payKickback;
		this.moneyOfChangePay = moneyOfChangePay;
		this.carryGoodsFee = carryGoodsFee;
		this.carriage = carriage;
		this.insurance = insurance;
		this.employeeCode = employeeCode;
		this.remark = remark;
		this.acceptStation = acceptStation;
	}

	public String getGoodsBillCode() {
		return goodsBillCode;
	}

	public void setGoodsBillCode(String goodsBillCode) {
		this.goodsBillCode = goodsBillCode;
	}

	public String getSendGoodsCustomerNo() {
		return sendGoodsCustomerNo;
	}

	public void setSendGoodsCustomerNo(String sendGoodsCustomerNo) {
		this.sendGoodsCustomerNo = sendGoodsCustomerNo;
	}

	public String getSendGoodsCustomer() {
		return sendGoodsCustomer;
	}

	public void setSendGoodsCustomer(String sendGoodsCustomer) {
		this.sendGoodsCustomer = sendGoodsCustomer;
	}

	public String getSendGoodsCustomerTel() {
		return sendGoodsCustomerTel;
	}

	public void setSendGoodsCustomerTel(String sendGoodsCustomerTel) {
		this.sendGoodsCustomerTel = sendGoodsCustomerTel;
	}

	public String getSendGoodsCustomerAddr() {
		return sendGoodsCustomerAddr;
	}

	public void setSendGoodsCustomerAddr(String sendGoodsCustomerAddr) {
		this.sendGoodsCustomerAddr = sendGoodsCustomerAddr;
	}

	public String getReceiveGoodsCustomerCode() {
		return receiveGoodsCustomerCode;
	}

	public void setReceiveGoodsCustomerCode(String receiveGoodsCustomerCode) {
		this.receiveGoodsCustomerCode = receiveGoodsCustomerCode;
	}

	public String getReceiveGoodsCustomer() {
		return receiveGoodsCustomer;
	}

	public void setReceiveGoodsCustomer(String receiveGoodsCustomer) {
		this.receiveGoodsCustomer = receiveGoodsCustomer;
	}

	public String getReceiveGoodsCustomerTel() {
		return receiveGoodsCustomerTel;
	}

	public void setReceiveGoodsCustomerTel(String receiveGoodsCustomerTel) {
		this.receiveGoodsCustomerTel = receiveGoodsCustomerTel;
	}

	public String getReceiveGoodsCustomerAddr() {
		return receiveGoodsCustomerAddr;
	}

	public void setReceiveGoodsCustomerAddr(String receiveGoodsCustomerAddr) {
		this.receiveGoodsCustomerAddr = receiveGoodsCustomerAddr;
	}

	public Date getSendGoodsDate() {
		return sendGoodsDate;
	}

	public void setSendGoodsDate(Date sendGoodsDate) {
		this.sendGoodsDate = sendGoodsDate;
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

	public Date getPredeliveryDate() {
		return predeliveryDate;
	}

	public void setPredeliveryDate(Date predeliveryDate) {
		this.predeliveryDate = predeliveryDate;
	}

	public Date getFactDealDate() {
		return factDealDate;
	}

	public void setFactDealDate(Date factDealDate) {
		this.factDealDate = factDealDate;
	}

	public double getHelpAcceptPayment() {
		return helpAcceptPayment;
	}

	public void setHelpAcceptPayment(double helpAcceptPayment) {
		this.helpAcceptPayment = helpAcceptPayment;
	}

	public String getAcceptProcedureRate() {
		return acceptProcedureRate;
	}

	public void setAcceptProcedureRate(String acceptProcedureRate) {
		this.acceptProcedureRate = acceptProcedureRate;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getFetchGoodsMode() {
		return fetchGoodsMode;
	}

	public void setFetchGoodsMode(String fetchGoodsMode) {
		this.fetchGoodsMode = fetchGoodsMode;
	}

	public String getWriteBillPerson() {
		return writeBillPerson;
	}

	public void setWriteBillPerson(String writeBillPerson) {
		this.writeBillPerson = writeBillPerson;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public boolean getValidity() {
		return validity;
	}

	public void setValidity(boolean validity) {
		this.validity = validity;
	}

	public boolean getIfAudit() {
		return ifAudit;
	}

	public void setIfAudit(boolean ifAudit) {
		this.ifAudit = ifAudit;
	}

	public boolean getIfSettleAccounts() {
		return ifSettleAccounts;
	}

	public void setIfSettleAccounts(boolean ifSettleAccounts) {
		this.ifSettleAccounts = ifSettleAccounts;
	}

	public String getTransferStation() {
		return transferStation;
	}

	public void setTransferStation(String transferStation) {
		this.transferStation = transferStation;
	}

	public double getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(double transferFee) {
		this.transferFee = transferFee;
	}

	public double getReduceFund() {
		return reduceFund;
	}

	public void setReduceFund(double reduceFund) {
		this.reduceFund = reduceFund;
	}

	public double getPayKickback() {
		return payKickback;
	}

	public void setPayKickback(double payKickback) {
		this.payKickback = payKickback;
	}

	public double getMoneyOfChangePay() {
		return moneyOfChangePay;
	}

	public void setMoneyOfChangePay(double moneyOfChangePay) {
		this.moneyOfChangePay = moneyOfChangePay;
	}

	public double getCarryGoodsFee() {
		return carryGoodsFee;
	}

	public void setCarryGoodsFee(double carryGoodsFee) {
		this.carryGoodsFee = carryGoodsFee;
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

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAcceptStation() {
		return acceptStation;
	}

	public void setAcceptStation(String acceptStation) {
		this.acceptStation = acceptStation;
	}

	@Override
	public String toString() {
		return "GoodsBill [goodsBillCode=" + goodsBillCode + ", sendGoodsCustomerNo=" + sendGoodsCustomerNo
				+ ", sendGoodsCustomer=" + sendGoodsCustomer + ", sendGoodsCustomerTel=" + sendGoodsCustomerTel
				+ ", sendGoodsCustomerAddr=" + sendGoodsCustomerAddr + ", receiveGoodsCustomerCode="
				+ receiveGoodsCustomerCode + ", receiveGoodsCustomer=" + receiveGoodsCustomer
				+ ", receiveGoodsCustomerTel=" + receiveGoodsCustomerTel + ", receiveGoodsCustomerAddr="
				+ receiveGoodsCustomerAddr + ", sendGoodsDate=" + sendGoodsDate + ", sendGoodsAddr=" + sendGoodsAddr
				+ ", receiveGoodsAddr=" + receiveGoodsAddr + ", predeliveryDate=" + predeliveryDate + ", factDealDate="
				+ factDealDate + ", helpAcceptPayment=" + helpAcceptPayment + ", acceptProcedureRate="
				+ acceptProcedureRate + ", payMode=" + payMode + ", fetchGoodsMode=" + fetchGoodsMode
				+ ", writeBillPerson=" + writeBillPerson + ", writeDate=" + writeDate + ", validity=" + validity
				+ ", ifAudit=" + ifAudit + ", ifSettleAccounts=" + ifSettleAccounts + ", transferStation="
				+ transferStation + ", transferFee=" + transferFee + ", reduceFund=" + reduceFund + ", payKickback="
				+ payKickback + ", moneyOfChangePay=" + moneyOfChangePay + ", carryGoodsFee=" + carryGoodsFee
				+ ", carriage=" + carriage + ", insurance=" + insurance + ", employeeCode=" + employeeCode + ", remark="
				+ remark + ", acceptStation=" + acceptStation + "]";
	}

	
	
}
