package com.ansel.controller;

import java.util.HashMap;
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

import com.ansel.bean.Employee;
import com.ansel.service.IEmployeeService;
import com.ansel.service.IUserService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "职员 Controller")
@ControllerAdvice
public class EmployeeController extends ReturnType {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IUserService userService;
	
	@ApiOperation(value = "添加职员", notes = "添加一个新职员工")
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST, produces = "application/json")
	public String addNewEmp(Employee employee, @RequestParam("condition") int condition) {
		System.out.println(condition);
		boolean flag = false;
		flag = employeeService.save(employee, condition);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequestMapping(value = "/deleteEmp/{employeeCode}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteEmp(@PathVariable("employeeCode") String employeeCode) {
		
		boolean flag = false;
		flag = employeeService.delete(employeeCode);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequestMapping(value = "/selectAllEmp", method = RequestMethod.GET)
	public Result selectAllEmp(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<Employee> page = employeeService.selectAllEmpByPage(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	@RequestMapping(value = "/selectEmpByCode/{employeeCode}", method = RequestMethod.GET)
	public Map<?, ?> selectEmpByCode(@PathVariable("employeeCode") String employeeCode) {
		
		Employee employee = employeeService.selectByEmployeeCode(employeeCode);
		Map<String, Object> map = new HashMap<>();
		map.put("employee", employee);
		boolean flag = userService.ifExist(employeeCode);
		map.put("condition", flag == true ? 1 : 0);
		return map;
	}
	
	@RequestMapping(value = "/updateEmp/{employeeCode}", method = RequestMethod.PUT)
	public String updateEmp(Employee employee, @PathVariable("employeeCode") String employeeCode, @RequestParam("condition") int condition) {
		
		boolean flag = false;
		flag = employeeService.update(employee, employeeCode, condition);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}


}
