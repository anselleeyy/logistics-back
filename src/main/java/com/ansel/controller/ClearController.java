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

import com.ansel.bean.CustomerBillClear;
import com.ansel.bean.DriverClear;
import com.ansel.bean.ExtraClear;
import com.ansel.bean.ProxyFeeClear;
import com.ansel.service.IClearService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@Api(value = "结算 Controller")
@ControllerAdvice
@RequestMapping(value = "/clear")
public class ClearController extends ReturnType {

	@Autowired
	private IClearService clearService;

	/**
	 * 司机结算-返回未结的所有实体(实体中能填的属性都填好)
	 */
	@RequestMapping(value = "/selectClearDri/{eventName}", method = RequestMethod.GET)
	public Result selectClearDri(@PathVariable("eventName") String eventName) {
		List<DriverClear> list = clearService.selectDrclear(eventName);
		Result result = new Result(200, "SUCCESS", list.size(), list);
		return result;
	}

	/**
	 * 司机结算-通过订单编号查询单个实体的已填所有信息
	 */
	@RequestMapping(value = "/selectDriverClearByCode/{goodsBillCode}", method = RequestMethod.GET)
	public DriverClear selectDriverClearByCode(@PathVariable("goodsBillCode") String goodsBillCode) {
		DriverClear driverClear = clearService.selectByCargoReceiptCode(goodsBillCode);
		return driverClear;
	}

	/**
	 * 司机结算（前台返回一个完整的实体）
	 */
	@RequestMapping(value = "/addDriClear", method = RequestMethod.PUT, produces = "application/json")
	public String addDriClear(DriverClear driverClear) {
		boolean flag = false;
		flag = clearService.driClear(driverClear);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 客户结算-返回未结的所有实体(实体中能填的属性都填好)
	 */
	@RequestMapping(value = "/selectclearCus/{eventName}", method = RequestMethod.GET)
	public Result selecClearCus(@PathVariable("eventName") String eventName) {
		System.out.println(eventName);
		List<CustomerBillClear> list = clearService.selectCusclear(eventName);
		System.out.println(list);
		Result result = new Result(200, "SUCCESS", list.size(), list);
		return result;
	}
	
	/**
	 * 客户结算-通过订单编号查询单个实体的已填所有信息
	 */
	@RequestMapping(value = "/selectCustomerBillClearByCode/{goodsBillCode}", method = RequestMethod.GET)
	public CustomerBillClear selectCustomerBillClearByCode(@PathVariable("goodsBillCode") String goodsBillCode) {
		CustomerBillClear customerBillClear = clearService.selectByBillCode(goodsBillCode);
		System.out.println(customerBillClear);
		return customerBillClear;
	}
	
	/**
	 * 客户结算（前台返回一个完整的实体）
	 */
	@RequestMapping(value = "/addCusClear", method = RequestMethod.PUT, produces = "application/json")
	public String addCusClear(CustomerBillClear customerBillClear) {
		boolean flag = false;
		flag = clearService.cusClear(customerBillClear);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 代收结算-返回未结的所有实体(实体中能填的属性都填好)
	 */
	@RequestMapping(value = "/selectClearHelp/{eventName}", method = RequestMethod.GET)
	public Result selectClearHelp(@PathVariable("eventName") String eventName) {
		List<ProxyFeeClear> list = clearService.selectHelpclear(eventName);
		Result result = new Result(200, "SUCCESS", list.size(), list);
		return result;
	}
	
	/**
	 * 代收结算-通过订单编号查询单个实体的已填所有信息
	 */
	@RequestMapping(value = "/selectHelpBillClearByCode/{goodsBillCode}", method = RequestMethod.GET)
	public ProxyFeeClear selectHelpBillClearByCode(@PathVariable("goodsBillCode") String goodsBillCode) {
		ProxyFeeClear proxyFeeClear = clearService.selectByGoodsBillCode(goodsBillCode);
		return proxyFeeClear;
	}
	
	/**
	 * 代收结算（前台返回一个完整的实体）
	 */
	@RequestMapping(value = "/addCHelpClear", method = RequestMethod.PUT, produces = "application/json")
	public String addCHelpClear(ProxyFeeClear proxyFeeClear) {
		boolean flag = false;
		flag = clearService.helpClear(proxyFeeClear);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 杂费结算  add
	 */
	@RequestMapping(value = "/addExtraClear", method = RequestMethod.POST)
	public String addExtraClear(ExtraClear extraClear) {
		
		boolean flag = false;
		flag = clearService.saveExtraClear(extraClear);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 杂费结算  select
	 */
	@RequestMapping(value = "/selectAllExtraClear", method = RequestMethod.GET)
	public Result selectAllExtraClear(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<ExtraClear> page = clearService.selectAllExtraClearByPage(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
}
