package com.ansel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ansel.bean.CityExpand;
import com.ansel.bean.Region;

public interface ICityExpandService {
	
	public List<Region> findAllRegions();
	
	public List<Region> findLeftRegions();
	
	public Page<CityExpand> findAllExpands(Pageable pageable);
	
	public boolean addExpand(CityExpand cityExpand);
	
	public boolean deleteExpand(int id);
	
	public CityExpand findById(int id);
	
	public boolean updateExpand(CityExpand cityExpand);

}
