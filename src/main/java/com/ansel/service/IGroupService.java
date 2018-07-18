package com.ansel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ansel.bean.Function;
import com.ansel.bean.FunctionWithGroup;
import com.ansel.bean.UserGroup;

public interface IGroupService {
	
	public boolean save(UserGroup userGroup);
	
	public boolean delete(int id);
	
	public Page<UserGroup> selectAllGroup(Pageable pageable);
	
	public UserGroup findById(int id);
	
	public boolean update(int id, String description);
	
	public List<UserGroup> findAll();
	
	public List<Function> findAllFunction();
	
	public List<FunctionWithGroup> findAllFunctionWithGroups(int groupId);
	
	public boolean addFuncGro(int groupId, int[] functionId);
	
	public List<FunctionWithGroup> findByLoginId(String loginId);

}
