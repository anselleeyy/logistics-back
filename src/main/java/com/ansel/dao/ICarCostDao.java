package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.CarCost;

public interface ICarCostDao extends JpaRepository<CarCost, Long>{

	public CarCost findByDriverCode(String driverCode);


}
