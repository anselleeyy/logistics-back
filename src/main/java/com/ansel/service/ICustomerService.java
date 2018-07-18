package com.ansel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ansel.bean.CustomerInfo;

public interface ICustomerService {
	
    public boolean save(CustomerInfo customer);
	
	public boolean delete(String customerCode);
	
	public boolean update(String customerCode, CustomerInfo customer);
	
	public Page<CustomerInfo> selectAllCusByPage(Pageable pageable);
	
	public CustomerInfo selectByCustomerCode(String customerCode);
	
	public List<String> selectAllCusCode();

}
