package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 4.21 员工工资表
 * 
 * @author Ansel
 *
 */
@Entity(name = "employeewage")
public class EmployeeWage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50, nullable = false)
	private String employeeCode;

	private double basicWage;

	private double stationWage;

	private double allowance;

	private Date date;

	@Column(length = 50)
	private String employee;

	public EmployeeWage() {

	}

	public EmployeeWage(int id, String employeeCode, double basicWage, double stationWage, double allowance, Date date,
			String employee) {
		super();
		this.id = id;
		this.employeeCode = employeeCode;
		this.basicWage = basicWage;
		this.stationWage = stationWage;
		this.allowance = allowance;
		this.date = date;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public double getBasicWage() {
		return basicWage;
	}

	public void setBasicWage(double basicWage) {
		this.basicWage = basicWage;
	}

	public double getStationWage() {
		return stationWage;
	}

	public void setStationWage(double stationWage) {
		this.stationWage = stationWage;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeWage [id=" + id + ", employeeCode=" + employeeCode + ", basicWage=" + basicWage
				+ ", stationWage=" + stationWage + ", allowance=" + allowance + ", date=" + date + ", employee="
				+ employee + "]";
	}

}
