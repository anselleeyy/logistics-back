package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.UserGroup;

public interface IGroupDao extends JpaRepository<UserGroup, Long> {
	
	public UserGroup findByGroupName(String groupName);
	
	public UserGroup findById(int id);
	
}
