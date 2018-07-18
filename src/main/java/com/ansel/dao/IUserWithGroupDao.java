package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.UserWithGroup;

public interface IUserWithGroupDao extends JpaRepository<UserWithGroup, Long> {

	public UserWithGroup findByUserId(String userId);
	
}
