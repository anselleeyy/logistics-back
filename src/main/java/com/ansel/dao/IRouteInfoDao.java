package com.ansel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.RouteInfo;

public interface IRouteInfoDao extends JpaRepository<RouteInfo, Long> {
	
	@Modifying
	@Query(value = "truncate table routeinfo", nativeQuery = true)
	public void truncateTable();

	public List<RouteInfo> findByStartStationAndEndStation(int startStation, int endStation);
	
}
