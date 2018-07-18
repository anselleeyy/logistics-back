package com.ansel.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.BillInfo;

public interface IBillInfoDao extends JpaRepository<BillInfo, Long> {
	
	public BillInfo findByBillCode(String billCode);
	
	@Query(value = "select * from billinfo where bill_state = '已填' and bill_type = '货运单' and bill_code not in (select b.bill_code from billrelease b)", nativeQuery = true)
	public Page<BillInfo> findNotRelease(Pageable pageable);

}
