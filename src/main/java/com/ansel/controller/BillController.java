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

import com.ansel.bean.BillInfo;
import com.ansel.bean.BillRelease;
import com.ansel.bean.GoodsReceiptInfo;
import com.ansel.service.IBillService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RequestMapping(value = "/bill")
@ControllerAdvice
@RestController
@Api(value = "单据 controller")
public class BillController extends ReturnType {
	
	@Autowired
	private IBillService billService;
	
	@ApiOperation(value = "分发", notes = "分发 - 添加一条单据分发信息")
	@RequestMapping(value = "/addRelease/{billCode}", method = RequestMethod.POST)
	public String addRelease(@PathVariable("billCode") String billCode, BillRelease billRelease) {
		
		boolean flag = false;
		flag = billService.addRelease(billRelease);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "到货", notes = "到货 - 添加一条货物到货回执信息")
	@RequestMapping(value = "/addArrived/{goodsRevertCode}", method = RequestMethod.POST)
	public String addArrived(@PathVariable("goodsRevertCode") String goodsRevertCode, GoodsReceiptInfo goodsReceiptInfo) {
		
		boolean flag = false;
		flag = billService.addGoodsReceipt(goodsReceiptInfo);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "分页查询单据信息", notes = "分页查询单据信息")
	@RequestMapping(value = "/findByPage", method = RequestMethod.GET)
	public Result findAllByPage(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<BillInfo> page = billService.findAllByPage(pageable);
		Result result = new Result(200, "SUCCESS", page.getNumberOfElements(), page.getContent());
		return result;
		
	}
	
	@ApiOperation(value = "查询未分发的运单信息", notes = "查询未分发的运单信息")
	@RequestMapping(value = "/findNotRelease", method = RequestMethod.GET)
	public Result findNotRelease(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<BillInfo> page = billService.findNotRelease(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
		
	}

}
