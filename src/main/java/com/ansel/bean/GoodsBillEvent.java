package com.ansel.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 4.4 货运单事件表
 * 
 * @author Ansel
 *
 */
@Entity(name = "goodsbillevent")
public class GoodsBillEvent {

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	@Column(length = 50)
	private String goodsBillId;

	@Column(length = 50, nullable = false)
	private String eventName;

	@Column(length = 50, nullable = false)
	private String remark;

	private Date occurTime;

	public GoodsBillEvent() {
		super();
	}

	public GoodsBillEvent(String goodsBillId, String eventName, String remark, Date occurTime) {
		super();
		this.goodsBillId = goodsBillId;
		this.eventName = eventName;
		this.remark = remark;
		this.occurTime = occurTime;
	}

	public String getGoodsBillId() {
		return goodsBillId;
	}

	public void setGoodsBillId(String goodsBillId) {
		this.goodsBillId = goodsBillId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	@Override
	public String toString() {
		return "BillEvent [goodsBillId=" + goodsBillId + ", eventName=" + eventName + ", remark=" + remark
				+ ", occurTime=" + occurTime + "]";
	}

}
