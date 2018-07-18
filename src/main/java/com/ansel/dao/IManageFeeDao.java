package com.ansel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.ManageFee;

public interface IManageFeeDao extends JpaRepository<ManageFee, Long>{

	public List<ManageFee> findByPayoutMonth(String PayoutMonth);
	
	public ManageFee findById(int id);
}
