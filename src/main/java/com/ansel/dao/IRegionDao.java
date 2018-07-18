package com.ansel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.Region;

public interface IRegionDao extends JpaRepository<Region, Long> {
	
	public Region findById(int id);
	
	public Region findByCity(String city);
	
	@Query(value = "select * from region where id not in (select city_id from cityexpand)", nativeQuery = true)
	public List<Region> findLeftRegions();

}
