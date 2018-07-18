package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.Function;

public interface IFunctionDao extends JpaRepository<Function, Long> {

	
	
}
