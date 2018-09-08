package com.ansel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 4.33 用户表
 * 
 * @author lenovo
 *
 */
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(strategy = "assigned", name = "id")
	@Column(length = 50)
	private String loginId;// 登录ID
	
	@Column(length = 50)
	private String password;
	
	@Column(columnDefinition = "bit(1) default 0")
	private boolean ifOnline;// 是否在线

	public User() {
		super();
	}

	public User(String loginId, String password, boolean ifOnline) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.ifOnline = ifOnline;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIfOnline() {
		return ifOnline;
	}

	public void setIfOnline(boolean ifOnline) {
		this.ifOnline = ifOnline;
	}

	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", password=" + password + ", ifOnline=" + ifOnline + "]";
	}
	
}
