package com.ansel.controller;

import java.util.List;
import java.util.Map;

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

import com.ansel.bean.CargoReceiptDetail;
import com.ansel.bean.GoodsBill;
import com.ansel.bean.GoodsBillEvent;
import com.ansel.service.IGoodsBillService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "接货 Controller")
@ControllerAdvice
@RequestMapping(value = "/goodsBill")
public class GoodsBillController extends ReturnType {
	
	@Autowired
	private IGoodsBillService goodsBillService;
	
	/**
	 * 填写一份货运单合同
	 */
	@ApiOperation(value = "添加货运单", notes = "添加一个新货运单")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Map<?, ?> addGoodsBill(GoodsBill goodsBill) {  
		
		return goodsBillService.save(goodsBill);
	}
	
	/**
	 * 添加货物
	 */
	@RequestMapping(value = "/addGoods/{goodsBillDetailId}", method = RequestMethod.POST, produces = "application/json")
	public String addGoods(@PathVariable("goodsBillDetailId") String goodsBillDetailId, CargoReceiptDetail cargoReceiptDetail) {
		
		boolean flag = false;
		flag = goodsBillService.saveGoods(goodsBillDetailId, cargoReceiptDetail);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询所有运单
	 */
	@RequestMapping(value = "/selectByEvent", method = RequestMethod.GET)
	public Result selectAllGoodsBills(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<GoodsBillEvent> page =  goodsBillService.selectAllGoogsBillByPage(pageable);
		Result result  = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	/**
	 * 查询运单状态
	 */
	@RequestMapping(value = "/selectByEvent/{eventName}", method = RequestMethod.GET)
	public Result selectGoodsBillByEvent(@PathVariable("eventName") String eventName, @RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<GoodsBillEvent> page = goodsBillService.selectGoodsBillByEvent(eventName, pageable);
		Result result  = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	/**
	 * 通过id查询单个货运单
	 */
	@RequestMapping(value = "/selectByCode/{goodsBillCode}", method = RequestMethod.GET)
	public GoodsBill selectGoodsBillByCode(@PathVariable("goodsBillCode") String goodsBillCode) {
		GoodsBill goodsBill = goodsBillService.selectByGoodsBillCode(goodsBillCode);
		return goodsBill;
	}
	
	/**
	 * 修改货运单
	 */
	@RequestMapping(value = "/updateByCode/{goodsBillCode}", method = RequestMethod.PUT)
	public String updateGoodsBill(GoodsBill goodsBill, @PathVariable("goodsBillCode") String goodsBillCode) {
		
		boolean flag = false;
		flag = goodsBillService.update(goodsBill);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 删除货运单
	 */
	@RequestMapping(value = "/deleteByCode/{goodsBillCode}", method = RequestMethod.PUT)
	public String deleteGoodsBill(@PathVariable("goodsBillCode") String goodsBillCode) {
		
		boolean flag = false;
		flag = goodsBillService.delete(goodsBillCode);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "获取一个用户的待收货物")
	@RequestMapping(value = "/findWait/{customerCode}", method = RequestMethod.GET)
	public Result findWaitReceived(@PathVariable("customerCode") String customerCode) {
		List<GoodsBill> list = goodsBillService.findWaitReceive(customerCode);
		Result result = new Result(200, "SUCCESS", list.size(), list);
		return result;
	}
	
	@ApiOperation(value = "获取所有未发过 {提货 | 到货 | 中转 | 已提 | 代收} 回告的运单")
	@RequestMapping(value = "/findInform/{billType}", method = RequestMethod.GET)
	public Result findInform(@PathVariable("billType") String billType, @RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<GoodsBill> page = goodsBillService.findInformGet(billType, pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	@ApiOperation(value = "获取所有已发过 {提货 | 到货 | 中转 | 已提 | 代收} 回告的运单")
	@RequestMapping(value = "/findOldInform/{type}", method = RequestMethod.GET)
	public Result findOldInform(@PathVariable("type") String type, @RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<GoodsBill> page = goodsBillService.findOldInform(type, pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	@ApiOperation(value = "获取已提货的运单")
	@RequestMapping(value = "/findAllGot", method = RequestMethod.GET)
	public Result findAllGot(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<GoodsBill> page = goodsBillService.findAllGot(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
}
