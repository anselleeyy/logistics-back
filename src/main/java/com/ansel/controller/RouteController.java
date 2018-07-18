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

import com.ansel.bean.CityExpand;
import com.ansel.bean.Region;
import com.ansel.bean.RouteInfo;
import com.ansel.service.ICityExpandService;
import com.ansel.service.IRouteService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/route")
@Api(value = "城市 Controller")
@CrossOrigin
@ControllerAdvice
public class RouteController extends ReturnType {
	
	@Autowired
	private ICityExpandService cityExpandService;
	
	@Autowired
	private IRouteService routeService;
	
	@ApiOperation(value = "新增城市扩充信息", notes = "新增城市扩充信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addExpand(CityExpand cityExpand) {
		boolean flag = false;
		flag = cityExpandService.addExpand(cityExpand);
		if (!flag) {
			return ERROR;
		}
		routeService.generateRoute();
		return SUCCESS;
	}
	
	@ApiOperation(value = "删除一条城市扩充信息", notes = "通过 id 删除一条城市扩充信息")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteExpand(@PathVariable("id") int id) {
		boolean flag = false;
		flag = cityExpandService.deleteExpand(id);
		if (!flag) {
			return ERROR;
		}
		routeService.generateRoute();
		return SUCCESS;
	}
	
	@ApiOperation(value = "更新一条城市信息", notes = "通过 id 更新一条城市扩充信息")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String updateExpand(@PathVariable("id") int id, CityExpand cityExpand) {
		boolean flag = false;
		flag = cityExpandService.updateExpand(cityExpand);
		if (!flag) {
			return ERROR;
		}
		routeService.generateRoute();
		return SUCCESS;
	}
	
	@ApiOperation(value = "得到所有城市", notes = "返回所有的城市信息")
	@RequestMapping(value = "/findAllRegions", method = RequestMethod.GET)
	public List<Region> findAllRegion() {
		List<Region> regions = cityExpandService.findAllRegions();
		return regions;
	}
	
	@ApiOperation(value = "得到无范围的城市", notes = "返回无范围的城市信息")
	@RequestMapping(value = "/findLeftRegions", method = RequestMethod.GET)
	public List<Region> findLeftRegions() {
		List<Region> regions = cityExpandService.findLeftRegions();
		return regions;
	}
	
	@ApiOperation(value = "得到所有的城市范围信息", notes = "得到所有的城市范围信息")
	@RequestMapping(value = "/findAllExpands", method = RequestMethod.GET)
	public Result findAllExpands(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<CityExpand> page = cityExpandService.findAllExpands(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	@ApiOperation(value = "得到一条的城市范围信息", notes = "通过 id 得到一条城市范围信息")
	@RequestMapping(value = "/findExpand/{id}", method = RequestMethod.GET)
	public CityExpand findExpandById(@PathVariable("id") int id) {
		CityExpand cityExpand = cityExpandService.findById(id);
		return cityExpand;
	}
	
	@ApiOperation(value = "得到所有线路信息", notes = "得到所有的线路信息")
	@RequestMapping(value = "/findAllRoutes", method = RequestMethod.GET)
	public List<RouteInfo> findAllRouteInfos() {
		List<RouteInfo> routeInfos = routeService.findAllRouteInfos();
		return routeInfos;
	}

}
