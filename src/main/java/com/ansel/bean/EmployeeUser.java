package com.ansel.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 4.36 职员用户关系�?
 * 
 * @author lenovo
 *
 */
@Entity
@Table(name = "employeeuser")
public class EmployeeUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int employeeId;// 职员ID
	
	private int userId;// 用户ID
	
	public EmployeeUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeUser(int id, int employeeId, int userId) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "EmployeeCustomer [id=" + id + ", employeeId=" + employeeId + ", userId=" + userId + "]";
	}

}
