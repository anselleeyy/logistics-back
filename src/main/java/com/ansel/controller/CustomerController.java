package com.ansel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ansel.bean.CustomerInfo;
import com.ansel.service.ICustomerService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "客户 Controller")
@ControllerAdvice
public class CustomerController  extends ReturnType {
	
	@Autowired
	private ICustomerService customerService;
	
	@ApiOperation(value = "添加顾客", notes = "添加一个新顾客")
	@RequestMapping(value = "/addCus", method = RequestMethod.POST, produces = "application/json")
	public String addNewCus(CustomerInfo customer) {
		
		boolean flag = false;
		flag = customerService.save(customer);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequestMapping(value = "/deleteCus/{customerCode}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteCus(@PathVariable("customerCode") String customerCode) {
		
		boolean flag = false;
		flag = customerService.delete(customerCode);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequestMapping(value = "/selectAllCus", method = RequestMethod.GET)
	public Result selectAllCus(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<CustomerInfo> page = customerService.selectAllCusByPage(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	@RequestMapping(value = "/selectCusByCode/{customerCode}", method = RequestMethod.GET)
	public CustomerInfo selectCusByCode(@PathVariable("customerCode") String customerCode) {
		
		CustomerInfo customerInfo = customerService.selectByCustomerCode(customerCode);
		return customerInfo;
	}
	
	@RequestMapping(value = "/selectAllCusCode", method = RequestMethod.GET)
	public List<?> selectAllCusCode() {
		
		List<String> cusCodes = customerService.selectAllCusCode();
		return cusCodes;
		
	}
	
	@ApiOperation(value = "顾客信息更新", notes = "根据顾客 id 更新顾客的信息")
	@RequestMapping(value = "/updateCustomerInfo/{customerCode}", method = RequestMethod.PUT)
	public String updateCustomerInfo(@PathVariable("customerCode") String customerCode, CustomerInfo customerInfo) {

		boolean flag = false;
		flag = customerService.update(customerCode, customerInfo);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}


}
