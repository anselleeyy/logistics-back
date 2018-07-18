package com.ansel.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.ExtraClear;


public interface IExtraClearDao extends JpaRepository<ExtraClear, Long>{
	
	@Query(value = "from extraclear where balanceDate between  ?1 and  ?2 and subjectName = '搬运费'")
	public List<ExtraClear> findByBalanceDate(Date beginTime,Date endTime);
}
