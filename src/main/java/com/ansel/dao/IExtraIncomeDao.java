package com.ansel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.ExtraIncome;

public interface IExtraIncomeDao extends JpaRepository<ExtraIncome, Long>{

    public List<ExtraIncome> findByIncomeMonth(String incomeMonth);
	

}
