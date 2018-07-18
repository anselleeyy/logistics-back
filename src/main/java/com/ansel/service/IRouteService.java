package com.ansel.service;

import java.util.List;

import com.ansel.bean.RouteInfo;

public interface IRouteService {
	
	public void generateRoute();
	
	public List<RouteInfo> findAllRouteInfos();

}
