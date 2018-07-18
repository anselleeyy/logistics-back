package com.ansel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 4.37 打印客户运量
 * 
 * @author lenovo
 *
 */
@Entity
@Table(name = "customeramount")
public class CustomerAmount {

	
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(length = 50)
	private String sendGoodsCustomer;// 发货客户
	
	private double carriageTotal;// 运费总计
	
	private double insuranceTotal;// 保险费�?�计
	
	private int pieceAmountTotal;// 件数总计

	public CustomerAmount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerAmount( String sendGoodsCustomer, double carriageTotal, double insuranceTotal,
			int pieceAmountTotal) {
		super();
		this.sendGoodsCustomer = sendGoodsCustomer;
		this.carriageTotal = carriageTotal;
		this.insuranceTotal = insuranceTotal;
		this.pieceAmountTotal = pieceAmountTotal;
	}

	

	public String getSendGoodsCustomer() {
		return sendGoodsCustomer;
	}

	public void setSendGoodsCustomer(String sendGoodsCustomer) {
		this.sendGoodsCustomer = sendGoodsCustomer;
	}

	public double getCarriageTotal() {
		return carriageTotal;
	}

	public void setCarriageTotal(double carriageTotal) {
		this.carriageTotal = carriageTotal;
	}

	public double getInsuranceTotal() {
		return insuranceTotal;
	}

	public void setInsuranceTotal(double insuranceTotal) {
		this.insuranceTotal = insuranceTotal;
	}

	public int getPieceAmountTotal() {
		return pieceAmountTotal;
	}

	public void setPieceAmountTotal(int pieceAmountTotal) {
		this.pieceAmountTotal = pieceAmountTotal;
	}

	@Override
	public String toString() {
		return "CustomerAmount [sendGoodsCustomer=" + sendGoodsCustomer + ", carriageTotal="
				+ carriageTotal + ", insuranceTotal=" + insuranceTotal + ", pieceAmountTotal=" + pieceAmountTotal + "]";
	}

}
