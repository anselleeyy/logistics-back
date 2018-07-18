package com.ansel.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.GoodsBillEvent;

public interface IGoodsBillEventDao extends JpaRepository<GoodsBillEvent, Long> {

	public Page<GoodsBillEvent> findByEventName(Pageable pageable, String eventName);
	
	public GoodsBillEvent findByGoodsBillId(String goodsBillId);
	
	@Modifying
	@Query(value = "update goodsbillevent set eventName = ?1, occurTime = ?2 where goodsBillId = ?3")
	public void updateEventName(String eventName, Date occurTime, String goodsBillId);
	
	public List<GoodsBillEvent> findByEventName(String eventName);
	
	@Modifying
	@Query(value = "update goodsbillevent set eventName =?1 where goodsBillId =?2")
	public void updateStateByCode(String backBillState, String goodsBillCode);

}
