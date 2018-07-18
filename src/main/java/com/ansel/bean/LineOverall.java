package com.ansel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 4.38 打印专线整体
 * 
 * @author lenovo
 *
 */
@Entity
@Table(name = "lineoverall")
public class LineOverall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50)
	private String loadStation;// 装货地点

	@Column(length = 50)
	private String dealGoodsStation;// 交货地点

	private double allCarriageTotal;// 总运费�?�计

	private double insuranceTotal;// 保险费�?�计

	private int times;// 次数

	public LineOverall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineOverall(int id, String loadStation, String dealGoodsStation, double allCarriageTotal,
			double insuranceTotal, int times) {
		super();
		this.id = id;
		this.loadStation = loadStation;
		this.dealGoodsStation = dealGoodsStation;
		this.allCarriageTotal = allCarriageTotal;
		this.insuranceTotal = insuranceTotal;
		this.times = times;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getAllCarriageTotal() {
		return allCarriageTotal;
	}

	public void setAllCarriageTotal(double allCarriageTotal) {
		this.allCarriageTotal = allCarriageTotal;
	}

	public double getInsuranceTotal() {
		return insuranceTotal;
	}

	public void setInsuranceTotal(double insuranceTotal) {
		this.insuranceTotal = insuranceTotal;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "LineOverall [id=" + id + ", loadStation=" + loadStation + ", dealGoodsStation=" + dealGoodsStation
				+ ", allCarriageTotal=" + allCarriageTotal + ", insuranceTotal=" + insuranceTotal + ", times=" + times
				+ "]";
	}

}
