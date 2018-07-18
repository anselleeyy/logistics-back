package com.ansel.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ansel.bean.CityExpand;
import com.ansel.bean.Region;
import com.ansel.bean.RouteInfo;
import com.ansel.dao.ICityExpandDao;
import com.ansel.dao.IRegionDao;
import com.ansel.dao.IRouteInfoDao;
import com.ansel.service.IRouteService;

@Transactional
@Service(value = "routeService")
public class RouteServiceImpl implements IRouteService {

	@Autowired
	private IRegionDao regionDao;
	
	@Autowired
	private ICityExpandDao cityExpandDao;
	
	@Autowired
	private IRouteInfoDao routeInfoDao;
	
	private List<List<Integer>> routeList;
	
	@Override
	public void generateRoute() {
		// TODO Auto-generated method stub
		routeList = new LinkedList<>();
		List<Region> list = regionDao.findAll();
		for (Region region : list) {
			List<Integer> temp = new LinkedList<>();
			int cityId = region.getId();
			temp.add(cityId);
			dfs(cityId, temp);	
		}
		for (List<Integer> route : routeList) {
			RouteInfo routeInfo = new RouteInfo();
			routeInfo.setStartStation(route.get(0));
			routeInfo.setEndStation(route.get(route.size()-1));
			String passStation = "";
			for (int i = 1; i < route.size()-1; i++) {
				passStation += (i == 1 ? "" : ",");
				passStation += route.get(i);
			}
			routeInfo.setPassStation(passStation);
			routeInfo.setDistance((route.size()-1) * 100);
			routeInfo.setFetchTime(route.size()-1);
			routeInfoDao.save(routeInfo);
		}

	}
	
	public void dfs(int id, List<Integer> temp) {
		
		CityExpand cityExpand = cityExpandDao.findByCityId(id);
		if (cityExpand == null) {
			return ;
		}
		String[] rangeCity = cityExpand.getRangeCity().split(",");
		for (String string : rangeCity) {
			Integer rangeCityId = Integer.valueOf(string);
			if (temp.contains(rangeCityId)) {
				continue;
			}
			temp.add(rangeCityId);
			dfs(rangeCityId, temp);
			routeList.add(new LinkedList<>(temp));
			temp.remove(rangeCityId);
		}
		return ;
	}

	@Override
	public List<RouteInfo> findAllRouteInfos() {
		// TODO Auto-generated method stub
		return routeInfoDao.findAll();
	}

}
