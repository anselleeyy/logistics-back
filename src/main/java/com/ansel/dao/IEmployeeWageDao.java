package com.ansel.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.EmployeeWage;

public interface IEmployeeWageDao extends JpaRepository<EmployeeWage, Long>{
	
	@Query(value = "from employeewage  where date between  ?1 and  ?2")
	public List<EmployeeWage>  findByDate(Date beginTime,Date endTime);
	
	public EmployeeWage findByEmployeeCode(String employeeCode);

}
