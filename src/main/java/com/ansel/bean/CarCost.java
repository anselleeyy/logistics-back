package com.ansel.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 4.42 打印车辆成本
 * 
 * @author lenovo
 *
 */
@Entity(name = "carcost")
public class CarCost {

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(length = 50)
	private String driverCode;// 司机名称
	
	@Column(length = 50)
	private String carNo;// 车号
	
	@Column(length = 50)
	private String carType;// 车型
	
	@Column
	private double allowCarryWeight;// 准载重量
	
	@Column
	private String carWidth;// 车厢宽度
	
	@Column(length = 50)
	private String goodsHeight;// 载物高度
	
	private double carryFeeTotal;// 承运费�?�计
	
	private double addCarriageTotal;// 加运费�?�计
	
	private double factCarriageTotal;// 实际总运�?
	
	@Column(length = 50)
	private String loadStation;// 装货地点
	
	@Column(length = 50)
	private String dealGoodsStation;// 交货地点
	
	private String backBillCode;// 回执单编�?
	
	private Date balanceTime;// 结算时间

	
	public CarCost() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CarCost(String driverCode, String carNo, String carType, double allowCarryWeight, String carWidth,
			String goodsHeight, double carryFeeTotal, double addCarriageTotal, double factCarriageTotal,
			String loadStation, String dealGoodsStation, String backBillCode, Date balanceTime) {
		super();
		this.driverCode = driverCode;
		this.carNo = carNo;
		this.carType = carType;
		this.allowCarryWeight = allowCarryWeight;
		this.carWidth = carWidth;
		this.goodsHeight = goodsHeight;
		this.carryFeeTotal = carryFeeTotal;
		this.addCarriageTotal = addCarriageTotal;
		this.factCarriageTotal = factCarriageTotal;
		this.loadStation = loadStation;
		this.dealGoodsStation = dealGoodsStation;
		this.backBillCode = backBillCode;
		this.balanceTime = balanceTime;
	}

	public String getDriverCode() {
		return driverCode;
	}


	public void setDriverCode(String driverCode) {
		this.driverCode = driverCode;
	}


	public String getCarNo() {
		return carNo;
	}


	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}


	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}


	public double getAllowCarryWeight() {
		return allowCarryWeight;
	}


	public void setAllowCarryWeight(double allowCarryWeight) {
		this.allowCarryWeight = allowCarryWeight;
	}


	public String getCarWidth() {
		return carWidth;
	}


	public void setCarWidth(String carWidth) {
		this.carWidth = carWidth;
	}


	public String getGoodsHeight() {
		return goodsHeight;
	}


	public void setGoodsHeight(String goodsHeight) {
		this.goodsHeight = goodsHeight;
	}


	public double getCarryFeeTotal() {
		return carryFeeTotal;
	}


	public void setCarryFeeTotal(double carryFeeTotal) {
		this.carryFeeTotal = carryFeeTotal;
	}


	public double getAddCarriageTotal() {
		return addCarriageTotal;
	}


	public void setAddCarriageTotal(double addCarriageTotal) {
		this.addCarriageTotal = addCarriageTotal;
	}


	public double getFactCarriageTotal() {
		return factCarriageTotal;
	}


	public void setFactCarriageTotal(double factCarriageTotal) {
		this.factCarriageTotal = factCarriageTotal;
	}


	public String getLoadStation() {
		return loadStation;
	}


	public void setLoadStation(String loadStation) {
		this.loadStation = loadStation;
	}


	public String getDealGoodsStation() {
		return dealGoodsStation;
	}


	public void setDealGoodsStation(String dealGoodsStation) {
		this.dealGoodsStation = dealGoodsStation;
	}


	public String getBackBillCode() {
		return backBillCode;
	}


	public void setBackBillCode(String backBillCode) {
		this.backBillCode = backBillCode;
	}


	public Date getBalanceTime() {
		return balanceTime;
	}


	public void setBalanceTime(Date balanceTime) {
		this.balanceTime = balanceTime;
	}


	@Override
	public String toString() {
		return "CarCost [ driverCode=" + driverCode + ", carNo=" + carNo + ", carType=" + carType
				+ ", allowCarryWeight=" + allowCarryWeight + ", carWidth=" + carWidth + ", goodsHeight=" + goodsHeight
				+ ", carryFeeTotal=" + carryFeeTotal + ", addCarriageTotal=" + addCarriageTotal + ", factCarriageTotal="
				+ factCarriageTotal + ", loadStation=" + loadStation + ", dealGoodsStation=" + dealGoodsStation
				+ ", backBillCode=" + backBillCode + ", balanceTime=" + balanceTime + "]";
	}

	

}
