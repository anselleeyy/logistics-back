package com.ansel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ansel.bean.CargoReceiptDetail;

public interface ICargoReceiptDetailDao extends JpaRepository<CargoReceiptDetail, Long> {
	
	public CargoReceiptDetail findByGoodsRevertBillId(String goodsRevertBillId);
	
	@Query(value = "select goodsRevertBillId from cargoreceiptdetail")
	public List<String> findAllCargoReceiptCode();
	
	public CargoReceiptDetail findByGoodsBillDetailId(String goodsBillDetailId);
	
	@Query(value = "select goodsRevertBillId from cargoreceiptdetail where goodsRevertBillId not in (select goodsRevertBillCode from cargoreceipt)")
	public List<?> findLeftCodes();
	
}