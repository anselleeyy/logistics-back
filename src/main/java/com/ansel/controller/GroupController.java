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

import com.ansel.bean.Function;
import com.ansel.bean.FunctionWithGroup;
import com.ansel.bean.UserGroup;
import com.ansel.service.IGroupService;
import com.ansel.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "用户组 Controller")
@ControllerAdvice
public class GroupController extends ReturnType {
	
	@Autowired
	private IGroupService groupService;
	
	@RequestMapping(value = "/addGroup", method = RequestMethod.POST, produces = "application/json")
	public String addNewGroup(UserGroup userGroup) {
		
		boolean flag = false;
		flag = groupService.save(userGroup);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequestMapping(value = "/addNewFunc", method = RequestMethod.POST)
	public String addNewFunc(@RequestParam("groupId") int groupId, @RequestParam("array[]") int[] array) {
		boolean flag = false;
		flag = groupService.addFuncGro(groupId, array);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequestMapping(value = "/deleteGroup/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteGroup(@PathVariable("id") int id) {
		boolean flag = false;
		flag = groupService.delete(id);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequestMapping(value = "/selectAllGroup", method = RequestMethod.GET)
	public Result selectAllGroup(@RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1, limit);
		Page<UserGroup> page = groupService.selectAllGroup(pageable);
		Result result = new Result(200, "SUCCESS", (int) page.getTotalElements(), page.getContent());
		return result;
	}
	
	@RequestMapping(value = "/selectGroup/{id}", method = RequestMethod.GET)
	public UserGroup selectGroupById(@PathVariable("id") int id) {
		UserGroup userGroup = groupService.findById(id);
		return userGroup;
	}
	
	@ApiOperation(value = "用户组更新", notes = "根据用户组 id 更新用户组的描述")
	@RequestMapping(value = "/updateDescription/{id}", method = RequestMethod.PUT)
	public String updateDescription(@PathVariable("id") int id, @RequestParam("description") String description) {
		
		boolean flag = false;
		flag = groupService.update(id, description);
		if (!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@ApiOperation(value = "查询所有用户组供添加职工使用", notes = "查询所有用户组")
	@RequestMapping(value = "/selectAllUserFroup", method = RequestMethod.GET)
	public List<UserGroup> selectAll() {
		
		List<UserGroup> groups = groupService.findAll();
		
		return groups;
	}
	
	@ApiOperation(value = "查询所有功能")
	@RequestMapping(value = "/selectAllFunction", method = RequestMethod.GET)
	public List<Function> selectAllFunction() {
		
		List<Function> functions = groupService.findAllFunction();
		
		return functions;
	}
	
	@ApiOperation(value = "查询所有组功能")
	@RequestMapping(value = "/selectFunctionByGroup/{groupId}", method = RequestMethod.GET)
	public List<FunctionWithGroup> selectFunctionByGroup(@PathVariable("groupId") int groupId) {
		
		List<FunctionWithGroup> functions = groupService.findAllFunctionWithGroups(groupId);
		
		return functions;
	}
	
	@ApiOperation(value = "查询权限")
	@RequestMapping(value = "/selectFunc/{loginId}", method = RequestMethod.GET)
	public List<FunctionWithGroup> selectFunc(@PathVariable("loginId") String loginId) {
		
		List<FunctionWithGroup> functions = groupService.findByLoginId(loginId);
		
		return functions;
	}

}
