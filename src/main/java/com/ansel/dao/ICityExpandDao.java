package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.CityExpand;

public interface ICityExpandDao extends JpaRepository<CityExpand, Long> {
	
	public CityExpand findByCityId(int cityId);
	
	public CityExpand findById(int id);

}
