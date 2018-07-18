package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.IncomeMonthlyTemp;

public interface IIncomeMonthlyTempDao extends JpaRepository<IncomeMonthlyTemp, Long>{
	
	public IncomeMonthlyTemp findByMonth(String month);
}
