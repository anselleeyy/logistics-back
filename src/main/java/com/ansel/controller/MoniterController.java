package com.ansel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ansel.bean.CarCost;
import com.ansel.bean.ContactsService;
import com.ansel.bean.CustomerAmount;
import com.ansel.bean.DriverAmount;
import com.ansel.bean.GoodsBill;
import com.ansel.bean.LineOverall;
import com.ansel.service.IMoniterService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@Api(value = "监管 Controller")
@ControllerAdvice
@RequestMapping(value = "/monitor")
public class MoniterController extends ReturnType {

	@Autowired
	private IMoniterService moniterService;

	/**
	 * 预期未到运单
	 */
	@RequestMapping(value = "/selectUnArrive", method = RequestMethod.GET)
	public Result selectUnArrive() {
		List<GoodsBill> goodsbills = moniterService.selectAllUnArrive();
		Result result = new Result(200, "SUCCESS", goodsbills.size(), goodsbills);
		return result;
	}

	/**
	 * 滞留未取运单
	 */
	@RequestMapping(value = "/selectUnTake", method = RequestMethod.GET)
	public Result selectUnTake() {

		List<GoodsBill> goodsbills = moniterService.selectAllUnTake();
		Result result = new Result(200, "SUCCESS", goodsbills.size(), goodsbills);
		return result;
	}

	/**
	 * 打印客户用量
	 */
	@RequestMapping(value = "/selectCusAcount", method = RequestMethod.GET)
	public Result selectCusAcount() {

		List<CustomerAmount> customerAmounts = moniterService.selectAllCusAcount();
		Result result = new Result(200, "SUCCESS", customerAmounts.size(), customerAmounts);
		return result;
	}

	/**
	 * 打印司机用量
	 */
	@RequestMapping(value = "/selectDriAcount", method = RequestMethod.GET)
	public Result selectDriAcount() {

		List<DriverAmount> driverAmounts = moniterService.selectAllDriAcount();
		Result result = new Result(200, "SUCCESS", driverAmounts.size(), driverAmounts);
		return result;
	}

	/**
	 * 打印往来业务用量
	 */
	@RequestMapping(value = "/printContactsService", method = RequestMethod.GET)
	public Result printContactsService() {

		List<ContactsService> contactsServices = moniterService.printAllContactsService();
		Result result = new Result(200, "SUCCESS", contactsServices.size(), contactsServices);
		
		return result;
	}
	
	/**
	 * 打印往来业务用量-查询
	 */
	@RequestMapping(value = "/selectContactsServiceByCode/{goodsBillCode}", method = RequestMethod.GET)
	public ContactsService selectContactsServiceByCode(@PathVariable("goodsBillCode") String goodsBillCode) {
		System.out.println("controller: " + goodsBillCode);
		ContactsService contactsService = moniterService.selectByGoodsBillCode(goodsBillCode);
		return contactsService;
	}

	/**
	 * 打印专线整体
	 */
	@RequestMapping(value = "/printLineOverall", method = RequestMethod.GET)
	public Result printLineOverall() {

		List<LineOverall> lineOveralls = moniterService.printAllLineOverall();
		Result result = new Result(200, "SUCCESS", lineOveralls.size(), lineOveralls);
		return result;
	}
	
	

	/**
	 * 打印车辆成本
	 */
	@RequestMapping(value = "/printCar", method = RequestMethod.GET)
	public Result printCar() {

		List<CarCost> carCosts = moniterService.printAllCarCost();
		Result result = new Result(200, "SUCCESS", carCosts.size(), carCosts);

		return result;
	}
	
	/**
	 * 打印车辆成本-查询
	 */
	@RequestMapping(value = "/selectCarCostByCode/{driverCode}", method = RequestMethod.GET)
	public CarCost selectCarCostByCode(@PathVariable("driverCode") String driverCode) {
		CarCost carCost = moniterService.selectByCode(driverCode);
		return carCost;
	}
}
