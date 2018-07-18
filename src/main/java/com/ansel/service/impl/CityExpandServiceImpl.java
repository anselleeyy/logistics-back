package com.ansel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ansel.bean.CityExpand;
import com.ansel.bean.Region;
import com.ansel.dao.ICityExpandDao;
import com.ansel.dao.IRegionDao;
import com.ansel.dao.IRouteInfoDao;
import com.ansel.service.ICityExpandService;

@Transactional
@Service(value = "cityExpandService")
public class CityExpandServiceImpl implements ICityExpandService {
	
	@Autowired
	private ICityExpandDao cityExpandDao;
	
	@Autowired
	private IRegionDao regionDao;
	
	@Autowired
	private IRouteInfoDao routeInfoDao;

	@Override
	public List<Region> findAllRegions() {
		// TODO Auto-generated method stub
		List<Region> regions = regionDao.findAll();
		return regions;
	}

	@Override
	public List<Region> findLeftRegions() {
		// TODO Auto-generated method stub
		return regionDao.findLeftRegions();
	}

	@Override
	public Page<CityExpand> findAllExpands(Pageable pageable) {
		// TODO Auto-generated method stub
		return cityExpandDao.findAll(pageable);
	}

	@Override
	public boolean addExpand(CityExpand cityExpand) {
		// TODO Auto-generated method stub
		try {
			cityExpandDao.save(cityExpand);
			routeInfoDao.truncateTable();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("城市扩充表添加失败 | 路线信息表清空失败");
			return false;
		}
	}

	@Override
	public boolean deleteExpand(int id) {
		// TODO Auto-generated method stub
		try {
			CityExpand cityExpand = cityExpandDao.findById(id);
			cityExpandDao.delete(cityExpand);
			routeInfoDao.truncateTable();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("城市扩充信息表 - " + id + " 删除失败 | 路线信息表清空失败");
			return false;
		}
	}

	@Override
	public CityExpand findById(int id) {
		// TODO Auto-generated method stub
		return cityExpandDao.findById(id);
	}

	@Override
	public boolean updateExpand(CityExpand cityExpand) {
		// TODO Auto-generated method stub
		try {
			cityExpandDao.save(cityExpand);
			routeInfoDao.truncateTable();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("城市扩充信息表更新失败 | 路线信息表清空失败");
			return false;
		}
	}

}
