package com.ansel.controller;

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

import com.ansel.bean.EmployeeWage;
import com.ansel.bean.ExtraIncome;
import com.ansel.bean.FinanceFee;
import com.ansel.bean.IncomeMonthlyTemp;
import com.ansel.bean.ManageFee;
import com.ansel.service.ICheckService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@Api(value = "营业外收入 Controller")
@ControllerAdvice
@RequestMapping(value = "/check")
public class CheckController extends ReturnType {

	@Autowired
	private ICheckService checkService;
	
	/**
	 * 录入营业外收入
	 */
	@RequestMapping(value = "/addExtraIncome", method = RequestMethod.POST, produces = "application/json")
	public String add(ExtraIncome extraIncome) {
		boolean flag = false;
		flag = checkService.save(extraIncome);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询所有营业外收入
	 */
    @RequestMapping(value = "/selectExtraIncome", method = RequestMethod.GET)
	public Result selectAllExtra(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<ExtraIncome> page = checkService.selectAllExtra(pageable);
		Result result  = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;	
	}
    
	/**
	 * 录入财务费用
	 */
	@RequestMapping(value = "/addFinanceFee", method = RequestMethod.POST, produces = "application/json")
	public String add(FinanceFee financeFee) {
		boolean flag = false;
		flag = checkService.save(financeFee);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;	
	}
	
	/**
	 * 查询所有财务费用
	 */
    @RequestMapping(value = "/selectFinanceFee", method = RequestMethod.GET)
	public Result selectAllFinance(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<FinanceFee> page = checkService.selectAllFinance(pageable);
		Result result  = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;	
	}
    
    /**
	 * 录入管理费用
	 */
	@RequestMapping(value = "/addManageFee", method = RequestMethod.POST, produces = "application/json")
	public String add(ManageFee manageFee) {
		boolean flag = false;
		flag = checkService.save(manageFee);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询所有管理费用
	 */
    @RequestMapping(value = "/selectManageFee", method = RequestMethod.GET)
	public Result selectAllManageFee(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<ManageFee> page = checkService.selectAllManage(pageable);
		Result result  = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;	
	}
    
    /**
   	 * 根据id查询管理费用
   	 */
    @RequestMapping(value = "/findManageFee/{id}", method = RequestMethod.GET)
   	public ManageFee selectByMId(@PathVariable("id")int id) {
    	ManageFee manageFee = checkService.selectByMId(id);
   		return manageFee;		
   	}
    
	/**
	 * 录入员工工资
	 */
	@RequestMapping(value = "/addWage", method = RequestMethod.POST, produces = "application/json")
	public String add(EmployeeWage wage) {
		boolean flag = false;
		flag = checkService.save(wage);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
    /**
	 * 查询所有员工工资
	 */
    @RequestMapping(value = "/selectWage", method = RequestMethod.GET)
	public Result selectAllWage(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<EmployeeWage> page = checkService.selectAllWage(pageable);
		Result result  = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;	
	}
    
    /**
	 * 根据员工编号查询员工工资
	 */
    @RequestMapping(value = "/findWage/{employeeCode}", method = RequestMethod.GET)
	public EmployeeWage selectByEmployeeCode(@PathVariable("employeeCode") String employeeCode) {
    	EmployeeWage wage= checkService.selectByEmployeeCode(employeeCode);
		return wage;		
	}
    
    /**
	 * 查询当前月报
	 */
    @RequestMapping(value = "/selectIncomeMonthly", method = RequestMethod.GET)
	public IncomeMonthlyTemp selectAll() {
		IncomeMonthlyTemp incomeMonthlyTemp = checkService.selectAll();
		return incomeMonthlyTemp;	
	}
}
