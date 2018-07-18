package com.ansel.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.ProxyFeeClear;

public interface IProxyFeeClearDao extends JpaRepository<ProxyFeeClear, Long> {
	
	public ProxyFeeClear findByGoodsBillCode(String goodsBillCode);
	
	
	
}