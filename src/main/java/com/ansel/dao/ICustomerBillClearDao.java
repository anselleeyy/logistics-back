package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ansel.bean.CustomerBillClear;

public interface ICustomerBillClearDao extends JpaRepository<CustomerBillClear, Long> {
	
	
	public CustomerBillClear findByGoodsBillCode(String billCode);



}