package com.ansel.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.GoodsBill;

public interface IGoodsBillDao extends JpaRepository<GoodsBill, Long> {
	
	public GoodsBill findByGoodsBillCode(String goodsBillCode);
	
	@Query(value = "select g.* from goodsbill g inner join (" + 
				"select d.* from cargoreceiptdetail d inner join cargoreceipt c on d.goods_revert_bill_id = c.goods_revert_bill_code and c.driver_id is null" + 
				") t on g.goods_bill_code = t.goods_bill_detail_id", nativeQuery = true)
	public List<GoodsBill> findDriverIdIsNull();
	
	@Modifying
	@Query(value = "update goodsbill set factDealDate = ?1 where goodsBillCode = ?2")
	public void updateFactDealDate(Date factDealDate, String goodsBillCode);
	
	@Query(value = "select b.* from goodsbill b inner join goodsbillevent e on b.goods_bill_code = e.goods_bill_id where b.receive_goods_customer_code = ?1 and e.event_name = '未结' and b.goods_bill_code not in (select goods_bill_code from customerreceiptinfo)", nativeQuery = true)
	public List<GoodsBill> findWaitReceived(String customerCode);
	
	@Query(value = "select * from goodsbill where goods_bill_code in (select goods_bill_id from goodsbillevent where event_name = '未结' and goods_bill_id not in (select goods_bill_id from callbackinfo where type = ?1))", nativeQuery = true)
	public Page<GoodsBill> informGet(String type, Pageable pageable);
	
	@Query(value = "select * from goodsbill where goods_bill_code in (select goods_bill_id from goodsbillevent where event_name = '未结' and goods_bill_id in (select goods_bill_id from callbackinfo where type = ?1))", nativeQuery = true)
	public Page<GoodsBill> oldInform(String type, Pageable pageable);
	
	@Query(value = "select * from goodsbill where goods_bill_code in (select goods_bill_detail_id from cargoreceiptdetail d inner join cargoreceipt c where d.goods_revert_bill_id = c.goods_revert_bill_code and c.back_bill_state = ?1 and c.driver_id = ?2)", nativeQuery = true)
	public List<GoodsBill> transferState(String type, String driverId);
	
	// 查询有中转情况的未到货物
	@Query(value = "select * from logistics.goodsbill where goods_bill_code in (select goods_bill_id from goodsbillevent where event_name = '未到') and transfer_station is not null", nativeQuery = true)
	public List<GoodsBill> findOnWayBills();
	
	// 查询某种状态下的货物回告
	@Query(value = "select * from goodsbill where goods_bill_code in (select goods_bill_id from callbackinfo where type = ?1)", nativeQuery = true)
	public Page<GoodsBill> findOldCall(String type, Pageable pageable);
	
	// 查询已有顾客回执的货物
	@Query(value = "select * from goodsbill where goods_bill_code not in (select goods_bill_id from callbackinfo where type = '已提回告') and goods_bill_code in (select goods_bill_code from customerreceiptinfo)", nativeQuery = true)
	public Page<GoodsBill> findAllGot(Pageable pageable);
	
	@Query(value = "select sendGoodsCustomer,"
			+ "sum(carriage) as carriageTotal ,"
			+ "sum(insurance) as insuranceTotal ,"
			+ "count(*) as pieceAmountTotal"
			+ " from goodsbill "
			+ "group by sendGoodsCustomer "
			+ "order by pieceAmountTotal DESC")
	public List<Object[]> find();
	
}
