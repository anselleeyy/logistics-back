package com.ansel.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.CargoReceipt;

public interface ICargoReceiptDao extends JpaRepository<CargoReceipt, Long> {

	public List<CargoReceipt> findByDriverId(String driverId);
	
	public Page<CargoReceipt> findByBackBillState(Pageable pageable, String backBillState);
	
	public CargoReceipt findByGoodsRevertBillCode(String goodsRevertBillCode);
	
	public List<CargoReceipt> findByBackBillState(String backBillState);
	
	@Modifying
	@Query(value = "update cargoreceipt set backBillState =?1 where goodsRevertBillCode =?2")
	public void updateStateByCode(String backBillState, String goodsRevertBillCode);
	
	@Modifying
	@Query(value = "select loadStation ,dealGoodsStation ,sum(allCarriage) as allCarriageTotal ,"
			+ "sum(insurance) as insuranceTotal ,"
			+ "count(*) as times "
			+ "from cargoreceipt"
			+ " group by loadStation, dealGoodsStation "
			+ "order by times DESC")
	
	public List<Object[]> find();
	
	@Modifying
	@Query(value = "update cargoreceipt set startCarryTime = ?1, driverId = ?2, backBillState = ?3 where goodsRevertBillCode = ?4")
	public void updateRelease(Date startCarryTime, String driverId, String backBillState, String goodsRevertBillCode);
	
	public Page<CargoReceipt> findByDriverIdAndBackBillState(String driverId, String backBillState, Pageable pageable);
	
	@Modifying
	@Query(value = "update cargoreceipt set arriveTime = ?1, backBillState = ?2 where goodsRevertBillCode = ?3")
	public void updateArriveTime(Date arriveTime, String backBillState, String goodsRevertBillCode);
	
	@Query(value = "from cargoreceipt where signTime between ?1 and  ?2")
	public List<CargoReceipt> findBySignTime(java.util.Date beginTime,java.util.Date endTime);
	
	
	
}
