package com.ansel.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 4.27 司机信息表
 * 
 * @author Ansel
 *
 */
@Entity(name = "driverinfo")
public class DriverInfo {
	
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(length = 50)
	private String id;

	@Column(length = 50)
	private String driverName;

	@Column(length = 50)
	private String idCard;

	@Column(length = 50)
	private String phone;

	@Column(length = 50)
	private String gender;

	@Column(length = 50)
	private Date birthday;

	@Column(length = 50)
	private String state;

	@Column(length = 50)
	private String carNo;

	@Column(length = 50)
	private double allowCarryVolume;

	@Column(length = 50)
	private double allowCarryWeight;

	@Column(length = 50)
	private String address;

	@Column(length = 50)
	private String carType;

	@Column(length = 50)
	private String carLength;

	@Column(length = 50)
	private String carDept;

	@Column(length = 50)
	private String carDeptTel;

	@Column(length = 50)
	private String driveLicence;

	@Column(length = 50)
	private String runLicence;

	@Column(length = 50)
	private String bizLicence;

	@Column(length = 50)
	private String insuranceCard;

	@Column(length = 50)
	private String carWidth;

	@Column(length = 50)
	private String goodsHeight;

	@Column(length = 50)
	private String carFrameNo;
	
	@Column(length = 50)
	private String engineNo;

	@Column(length = 50)
	private String remark;

	private boolean companyCar;

	public DriverInfo() {

	}

	public DriverInfo(String id, String driverName, String idCard, String phone, String gender, Date birthday,
			String state, String carNo, double allowCarryVolume, double allowCarryWeight, String address,
			String carType, String carLength, String carDept, String carDeptTel, String driveLicence, String runLicence,
			String bizLicence, String insuranceCard, String carWidth, String goodsHeight, String carFrameNo,
			String engineNo, String remark, boolean companyCar) {
		super();
		this.id = id;
		this.driverName = driverName;
		this.idCard = idCard;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
		this.state = state;
		this.carNo = carNo;
		this.allowCarryVolume = allowCarryVolume;
		this.allowCarryWeight = allowCarryWeight;
		this.address = address;
		this.carType = carType;
		this.carLength = carLength;
		this.carDept = carDept;
		this.carDeptTel = carDeptTel;
		this.driveLicence = driveLicence;
		this.runLicence = runLicence;
		this.bizLicence = bizLicence;
		this.insuranceCard = insuranceCard;
		this.carWidth = carWidth;
		this.goodsHeight = goodsHeight;
		this.carFrameNo = carFrameNo;
		this.engineNo = engineNo;
		this.remark = remark;
		this.companyCar = companyCar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public double getAllowCarryVolume() {
		return allowCarryVolume;
	}

	public void setAllowCarryVolume(double allowCarryVolume) {
		this.allowCarryVolume = allowCarryVolume;
	}

	public double getAllowCarryWeight() {
		return allowCarryWeight;
	}

	public void setAllowCarryWeight(double allowCarryWeight) {
		this.allowCarryWeight = allowCarryWeight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarLength() {
		return carLength;
	}

	public void setCarLength(String carLength) {
		this.carLength = carLength;
	}

	public String getCarDept() {
		return carDept;
	}

	public void setCarDept(String carDept) {
		this.carDept = carDept;
	}

	public String getCarDeptTel() {
		return carDeptTel;
	}

	public void setCarDeptTel(String carDeptTel) {
		this.carDeptTel = carDeptTel;
	}

	public String getDriveLicence() {
		return driveLicence;
	}

	public void setDriveLicence(String driveLicence) {
		this.driveLicence = driveLicence;
	}

	public String getRunLicence() {
		return runLicence;
	}

	public void setRunLicence(String runLicence) {
		this.runLicence = runLicence;
	}

	public String getBizLicence() {
		return bizLicence;
	}

	public void setBizLicence(String bizLicence) {
		this.bizLicence = bizLicence;
	}

	public String getInsuranceCard() {
		return insuranceCard;
	}

	public void setInsuranceCard(String insuranceCard) {
		this.insuranceCard = insuranceCard;
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

	public String getCarFrameNo() {
		return carFrameNo;
	}

	public void setCarFrameNo(String carFrameNo) {
		this.carFrameNo = carFrameNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isCompanyCar() {
		return companyCar;
	}

	public void setCompanyCar(boolean companyCar) {
		this.companyCar = companyCar;
	}

	@Override
	public String toString() {
		return "DriverInfo [id=" + id + ", driverName=" + driverName + ", idCard=" + idCard + ", phone=" + phone
				+ ", gender=" + gender + ", birthday=" + birthday + ", state=" + state + ", carNo=" + carNo
				+ ", allowCarryVolume=" + allowCarryVolume + ", allowCarryWeight=" + allowCarryWeight + ", address="
				+ address + ", carType=" + carType + ", carLength=" + carLength + ", carDept=" + carDept
				+ ", carDeptTel=" + carDeptTel + ", driveLicence=" + driveLicence + ", runLicence=" + runLicence
				+ ", bizLicence=" + bizLicence + ", insuranceCard=" + insuranceCard + ", carWidth=" + carWidth
				+ ", goodsHeight=" + goodsHeight + ", carFrameNo=" + carFrameNo + ", engineNo=" + engineNo + ", remark="
				+ remark + ", companyCar=" + companyCar + "]";
	}

}