package com.ansel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.LineOverall;

public interface ILineOverallDao extends JpaRepository<LineOverall, Long>  {


	LineOverall findById(String driverCode);

//	@Modifying
//	@Query(value = "select loadStation ,dealGoodsStation ,sum(allCarriage) as allCarriageTotal ,"
//			+ "sum(insurance) as insuranceTotal ,"
//			+ "count(*) as times "
//			+ "from cargoreceipt"
//			+ " group by loadStation, dealGoodsStation "
//			+ "order by times DESC")
//	
//	List<LineOverall> find();
	
	
	@Modifying
	@Query(value = "truncate table lineoverall", nativeQuery = true)
	public void truncateTable();

}
