package com.ansel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 4.28 地区城市表
 * 
 * @author Ansel
 *
 */
@Entity(name = "routeinfo")
public class RouteInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int startStation;
	
	@Column(length = 100)
	private String passStation;

	@Column
	private int endStation;

	private double distance;

	private double fetchTime;

	public RouteInfo(){
		
	}
	
	public RouteInfo(int id, int startStation, String passStation, int endStation, double distance,
			double fetchTime) {
		super();
		this.id = id;
		this.startStation = startStation;
		this.passStation = passStation;
		this.endStation = endStation;
		this.distance = distance;
		this.fetchTime = fetchTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStartStation() {
		return startStation;
	}

	public void setStartStation(int startStation) {
		this.startStation = startStation;
	}

	public String getPassStation() {
		return passStation;
	}

	public void setPassStation(String passStation) {
		this.passStation = passStation;
	}

	public int getEndStation() {
		return endStation;
	}

	public void setEndStation(int endStation) {
		this.endStation = endStation;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getFetchTime() {
		return fetchTime;
	}

	public void setFetchTime(double fetchTime) {
		this.fetchTime = fetchTime;
	}

	@Override
	public String toString() {
		return "RouteInfo [id=" + id + ", startStation=" + startStation + ", passStation=" + passStation
				+ ", endStation=" + endStation + ", distance=" + distance + ", fetchTime=" + fetchTime + "]";
	}

}
