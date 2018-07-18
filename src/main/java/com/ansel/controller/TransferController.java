package com.ansel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ansel.bean.CustomerReceiptInfo;
import com.ansel.bean.GoodsBill;
import com.ansel.bean.TransferComInfo;
import com.ansel.bean.TransferInfo;
import com.ansel.service.ITransferService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RequestMapping(value = "/transfer")
@ControllerAdvice
@RestController
@Api(value = "transfer Controller")
public class TransferController extends ReturnType {
	
	@Autowired
	private ITransferService transferService;
	
	@ApiOperation(value = "添加中转公司信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTransferCompany(TransferComInfo transferComInfo) {
		
		boolean flag = false;
		flag = transferService.addCompany(transferComInfo);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "添加中转信息")
	@RequestMapping(value = "/addInfo/{goodsBillCode}", method = RequestMethod.POST)
	public String addTransfer(@PathVariable("goodsBillCode") String goodsBillCode, TransferInfo transferInfo) {
		boolean flag = false;
		flag = transferService.addTransferInfo(transferInfo);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "添加顾客回执")
	@RequestMapping(value = "/addCusRec", method = RequestMethod.POST)
	public String addCusRec(CustomerReceiptInfo customerReceiptInfo) {
		boolean flag = false;
		flag = transferService.addCustomerReceiptInfo(customerReceiptInfo);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "查询中转公司信息-分页")
	@RequestMapping(value = "/findByPage", method = RequestMethod.GET)
	public Result findByPage(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<TransferComInfo> page = transferService.findAllByPage(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	@ApiOperation(value = "查询一个司机的所有运单( 中转 | 到货)")
	@RequestMapping(value = "/transferGoods/{driverId}", method = RequestMethod.GET)
	public Result transferGoods(@PathVariable("driverId") String driverId) {
		
		List<GoodsBill> list = transferService.transferGoods("未到车辆", driverId);
		Result result = new Result(200, "SUCCESS", list.size(), list);
		return result;
		
	}
	
	@ApiOperation(value = "查询一个司机的所有到货运单")
	@RequestMapping(value = "/arriveGoods/{driverId}", method = RequestMethod.GET)
	public Result arriveGoods(@PathVariable("driverId") String driverId) {
		
		List<GoodsBill> list = transferService.arriveGoods("未到车辆", driverId);
		Result result = new Result(200, "SUCCESS", list.size(), list);
		return result;
		
	}
	
	@ApiOperation(value = "查询运单的中转详情")
	@RequestMapping(value = "/detail/{goodsBillCode}", method = RequestMethod.GET)
	public TransferComInfo detail(@PathVariable("goodsBillCode") String goodsBillCode) {
		
		TransferComInfo transferComInfo = transferService.findByGoodsBillCode(goodsBillCode);
		return transferComInfo;
		
	}
	
	@ApiOperation(value = "中转回告所需数据")
	@RequestMapping(value = "/findOnWayBills", method = RequestMethod.GET)
	public Result findOnWayBills() {
		List<GoodsBill> list = transferService.findOnWayBills();
		Result result = new Result(200, "SUCCESS", list.size(), list);
		return result;
		
	}
	
	@ApiOperation(value = "查询所有的中转信息")
	@RequestMapping(value = "/findInfoByPage", method = RequestMethod.GET)
	public Result findInfoByPage(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<TransferInfo> page = transferService.findInfoByPage(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
		
	}
	
	@ApiOperation(value = "查询所有用户的到货回执")
	@RequestMapping(value = "/findCusRes/{receiveGoodsPerson}", method = RequestMethod.GET)
	public Result findCusRes(@PathVariable("receiveGoodsPerson") String receiveGoodsPerson, @RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<CustomerReceiptInfo> page = transferService.findCusRecPage(receiveGoodsPerson, pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	

}
