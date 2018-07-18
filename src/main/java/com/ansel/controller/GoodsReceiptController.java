package com.ansel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ansel.bean.GoodsReceiptInfo;
import com.ansel.service.IGoodsReceiptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "客户 Controller")
@ControllerAdvice
@RequestMapping(value = "/goodsReceipt")
public class GoodsReceiptController extends ReturnType {
	
	@Autowired
	private IGoodsReceiptService goodsReceiptService;
	
	@ApiOperation(value = "新增一条司机回执信息", notes = "新增一条司机回执信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(GoodsReceiptInfo goodsReceiptInfo) {
		boolean flag = false;
		
		flag = goodsReceiptService.add(goodsReceiptInfo);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}

}
