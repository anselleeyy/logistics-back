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

import com.ansel.bean.DriverInfo;
import com.ansel.service.IDriverInfoService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/driverInfo")
@RestController
@CrossOrigin
@Api(value = "司机信息 controller")
@ControllerAdvice
public class DriverInfoController extends ReturnType {
	
	@Autowired
	private IDriverInfoService driverInfoService;
	
	@ApiOperation(value = "新增司机信息", notes = "前台信息封装后进行添加司机信息操作")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNewDriver(DriverInfo driverInfo) {
		
		System.out.println(driverInfo);
		boolean flag = false;
		flag = driverInfoService.addNewDriver(driverInfo);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "删除一个司机信息", notes = "通过 id 删除司机信息")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") String id) {
		boolean flag = false;
		flag = driverInfoService.deleteById(id);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "修改一个司机信息", notes = "通过 id 修改司机信息")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") String id, DriverInfo driverInfo) {
		
		boolean flag = false;
		flag = driverInfoService.updateById(id, driverInfo);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "分页查询司机", notes = "通过页码和limit查询司机信息")
	@RequestMapping(value = "/selectAllByPage", method = RequestMethod.GET)
	public Result selectAllByPage(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<DriverInfo> page = driverInfoService.findAllByPage(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	@ApiOperation(value = "查询一个司机信息", notes = "通过 id 查询司机信息")
	@RequestMapping(value = "/selectById/{id}", method = RequestMethod.GET)
	public DriverInfo selectById(@PathVariable("id") String id) {
		DriverInfo driverInfo = driverInfoService.findById(id);
		return driverInfo;
	}
	
	@ApiOperation(value = "查询所有司机 id", notes = "查询所有司机 id")
	@RequestMapping(value = "/selectAllId", method = RequestMethod.GET)
	public List<String> selectAllId() {
		List<String> list = driverInfoService.findAllId();
		return list;
	}

}
