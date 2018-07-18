package com.ansel.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 4.45 损益月报临时�?
 * 
 * @author lenovo
 *
 */
@Entity(name = "incomemonthlytemp")
public class IncomeMonthlyTemp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// 收入
	private double income;
	
	// 支出
	private double payout;
	
	// 营业收入
	private double bizIncome;
	
	// 运费金额
	private double carriageMoney;
	
	// 保险金额
	private double insuranceMoney;
	
	
	private double unbizIncome;// 非营业收入
	
	
	private double bizFee;// 经营费用
	
	
	private double carCarriage;// 车运�?
	
	
	private double conveyWage;// 搬运工资
	
	
	private double manageFee;// 管理费用
	
	
	private double officeFee;// 办公�?
	
	
	private double houseRent;// 房租�?
	
	
	private double waterElecFee;// 水电�?
	
	
	private double phoneFee;// 电话�?
	
	
	private double other;// 其他
	
	
	private double financeFee;// 财务费用
	
	
	private double profit;// 利润
	
	private double wage;//工资
	
	private String month;//月份
	

	public IncomeMonthlyTemp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IncomeMonthlyTemp(int id, double income, double payout, double bizIncome, double carriageMoney,
			double insuranceMoney, double unbizIncome, double bizFee, double carCarriage, double conveyWage,
			double manageFee, double officeFee, double houseRent, double waterElecFee, double phoneFee, double other,
			double financeFee, double profit, double wage, String month) {
		super();
		this.id = id;
		this.income = income;
		this.payout = payout;
		this.bizIncome = bizIncome;
		this.carriageMoney = carriageMoney;
		this.insuranceMoney = insuranceMoney;
		this.unbizIncome = unbizIncome;
		this.bizFee = bizFee;
		this.carCarriage = carCarriage;
		this.conveyWage = conveyWage;
		this.manageFee = manageFee;
		this.officeFee = officeFee;
		this.houseRent = houseRent;
		this.waterElecFee = waterElecFee;
		this.phoneFee = phoneFee;
		this.other = other;
		this.financeFee = financeFee;
		this.profit = profit;
		this.wage = wage;
		this.month = month;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getIncome() {
		return income;
	}


	public void setIncome(double income) {
		this.income = income;
	}


	public double getPayout() {
		return payout;
	}


	public void setPayout(double payout) {
		this.payout = payout;
	}


	public double getBizIncome() {
		return bizIncome;
	}


	public void setBizIncome(double bizIncome) {
		this.bizIncome = bizIncome;
	}


	public double getCarriageMoney() {
		return carriageMoney;
	}


	public void setCarriageMoney(double carriageMoney) {
		this.carriageMoney = carriageMoney;
	}


	public double getInsuranceMoney() {
		return insuranceMoney;
	}


	public void setInsuranceMoney(double insuranceMoney) {
		this.insuranceMoney = insuranceMoney;
	}


	public double getUnbizIncome() {
		return unbizIncome;
	}


	public void setUnbizIncome(double unbizIncome) {
		this.unbizIncome = unbizIncome;
	}


	public double getBizFee() {
		return bizFee;
	}


	public void setBizFee(double bizFee) {
		this.bizFee = bizFee;
	}


	public double getCarCarriage() {
		return carCarriage;
	}


	public void setCarCarriage(double carCarriage) {
		this.carCarriage = carCarriage;
	}


	public double getConveyWage() {
		return conveyWage;
	}


	public void setConveyWage(double conveyWage) {
		this.conveyWage = conveyWage;
	}


	public double getManageFee() {
		return manageFee;
	}


	public void setManageFee(double manageFee) {
		this.manageFee = manageFee;
	}


	public double getOfficeFee() {
		return officeFee;
	}


	public void setOfficeFee(double officeFee) {
		this.officeFee = officeFee;
	}


	public double getHouseRent() {
		return houseRent;
	}


	public void setHouseRent(double houseRent) {
		this.houseRent = houseRent;
	}


	public double getWaterElecFee() {
		return waterElecFee;
	}


	public void setWaterElecFee(double waterElecFee) {
		this.waterElecFee = waterElecFee;
	}


	public double getPhoneFee() {
		return phoneFee;
	}


	public void setPhoneFee(double phoneFee) {
		this.phoneFee = phoneFee;
	}


	public double getOther() {
		return other;
	}


	public void setOther(double other) {
		this.other = other;
	}


	public double getFinanceFee() {
		return financeFee;
	}


	public void setFinanceFee(double financeFee) {
		this.financeFee = financeFee;
	}


	public double getProfit() {
		return profit;
	}


	public void setProfit(double profit) {
		this.profit = profit;
	}


	public double getWage() {
		return wage;
	}


	public void setWage(double wage) {
		this.wage = wage;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	@Override
	public String toString() {
		return "IncomeMonthlyTemp [id=" + id + ", income=" + income + ", payout=" + payout + ", bizIncome=" + bizIncome
				+ ", carriageMoney=" + carriageMoney + ", insuranceMoney=" + insuranceMoney + ", unbizIncome="
				+ unbizIncome + ", bizFee=" + bizFee + ", carCarriage=" + carCarriage + ", conveyWage=" + conveyWage
				+ ", manageFee=" + manageFee + ", officeFee=" + officeFee + ", houseRent=" + houseRent
				+ ", waterElecFee=" + waterElecFee + ", phoneFee=" + phoneFee + ", other=" + other + ", financeFee="
				+ financeFee + ", profit=" + profit + ", wage=" + wage + ", month=" + month + "]";
	}

}