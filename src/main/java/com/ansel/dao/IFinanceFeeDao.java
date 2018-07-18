package com.ansel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.FinanceFee;

public interface IFinanceFeeDao extends JpaRepository<FinanceFee, Long>{

	public List<FinanceFee> findByPayoutMonth(String PayoutMonth);
}
