package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ansel.bean.Employee;

public interface IEmployeeDao extends JpaRepository<Employee, Long> {
	
	public Employee findByEmployeeCode(String employeeCode);
	
	@Transactional
	@Modifying
	@Query(value = "update employee set department =?1 where department =?2", nativeQuery = true)
	public void updateDepartment(String newDepartment, String oldDepartment);

}
