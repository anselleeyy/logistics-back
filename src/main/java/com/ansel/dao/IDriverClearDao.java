package com.ansel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.DriverClear;

public interface IDriverClearDao extends JpaRepository<DriverClear, Long> {

	public DriverClear findByBackBillCode(String goodsRevertBillCode);
	
	@Modifying
	@Query(value = "select driverCode,sum(carryFee) as carryFeeTotal ,sum(addCarriage) as addCarriageTotal ,count(driverCode) as total from driverclear group by driverCode order by total DESC")
	List<Object[]> find();

	
}