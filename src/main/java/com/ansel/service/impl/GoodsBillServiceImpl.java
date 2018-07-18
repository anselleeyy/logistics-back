package com.ansel.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ansel.bean.BillInfo;
import com.ansel.bean.CargoReceiptDetail;
import com.ansel.bean.GoodsBill;
import com.ansel.bean.GoodsBillEvent;
import com.ansel.dao.IBillInfoDao;
import com.ansel.dao.ICargoReceiptDetailDao;
import com.ansel.dao.IGoodsBillDao;
import com.ansel.dao.IGoodsBillEventDao;
import com.ansel.service.IGoodsBillService;

@Transactional
@Service(value = "goodsBillService")
public class GoodsBillServiceImpl implements IGoodsBillService {

	@Autowired
	private IGoodsBillDao goodsBillDao;
	
	@Autowired
	private IBillInfoDao billInfoDao;
	
	@Autowired
	private IGoodsBillEventDao goodsBillEventDao;
	
	@Autowired
	private ICargoReceiptDetailDao cargoReceiptDetailDao;
	
	@Override
	public Map<?, ?> save(GoodsBill goodsBill) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		try {
			String goodsBillCode = "HY";
			while (true) {
				goodsBillCode += randomCode();
				if (goodsBillDao.findByGoodsBillCode(goodsBillCode) == null) {
					break;
				}
			}
			goodsBill.setGoodsBillCode(goodsBillCode);
			goodsBill.setValidity(false);
			goodsBill.setIfAudit(false);
			goodsBillDao.save(goodsBill);
			
			BillInfo billInfo = new BillInfo();
			billInfo.setBillType("货运单");
			billInfo.setBillCode(goodsBillCode);
			billInfo.setBillState("已填");
			billInfo.setWriteDate(new Date());
			billInfoDao.save(billInfo);
			
			GoodsBillEvent goodsBillEvent = new GoodsBillEvent();
			goodsBillEvent.setGoodsBillId(goodsBillCode);
			goodsBillEvent.setEventName("待发");
			goodsBillEvent.setRemark("单据已填");
			goodsBillEvent.setOccurTime(new Date());
			goodsBillEventDao.save(goodsBillEvent);
			map.put("goodsBillCode", goodsBillCode);
			map.put("status", "SUCCESS");
			return map;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("货运单 | 单据 | 货运单事件表 插入失败！");
			map.put("status", "ERROR");
			return map;
		}
	}
	
	@Override
	public boolean saveGoods(String goodsBillDetailId, CargoReceiptDetail cargoReceiptDetail) {
		// TODO Auto-generated method stub
		try {
			String goodsRevertBillId = "HZ";
			while (true) {
				goodsRevertBillId += randomCode();
				if (cargoReceiptDetailDao.findByGoodsRevertBillId(goodsRevertBillId) == null) {
					break;
				}
			}
		cargoReceiptDetail.setGoodsRevertBillId(goodsRevertBillId);
		cargoReceiptDetailDao.save(cargoReceiptDetail);
		
		GoodsBill goodsBill = goodsBillDao.findByGoodsBillCode(goodsBillDetailId);
		goodsBill.setValidity(true);
		goodsBill.setIfAudit(true);
		goodsBillDao.save(goodsBill);
		return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("货物插入失败！");
			return false;
		}
	}
	
	private String randomCode() {
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			stringBuilder.append(random.nextInt(10));
		}
		return stringBuilder.toString();
	}

	@Override
	public Page<GoodsBillEvent> selectAllGoogsBillByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return goodsBillEventDao.findAll(pageable);
	}
	
	@Override
	public Page<GoodsBillEvent> selectGoodsBillByEvent(String eventName, Pageable pageable) {
		// TODO Auto-generated method stub
		return goodsBillEventDao.findByEventName(pageable, eventName);
	}
	
	@Override
	public GoodsBill selectByGoodsBillCode(String goodsBillCode) {
		// TODO Auto-generated method stub
		return goodsBillDao.findByGoodsBillCode(goodsBillCode);
	}

	@Override
	public boolean update(GoodsBill goodsBill) {
		// TODO Auto-generated method stub
		try {
			goodsBillDao.save(goodsBill);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("货运单更新失败");
			return false;
		}		
	}

	@Override
	public boolean delete(String goodsBillCode) {
		// TODO Auto-generated method stub
		GoodsBillEvent goodsBillEvent = new GoodsBillEvent();
		goodsBillEvent.setGoodsBillId(goodsBillCode);
		goodsBillEvent.setEventName("删除货运单");
		goodsBillEvent.setRemark("顾客不想发货");
		goodsBillEvent.setOccurTime(new Date());
		
		BillInfo billInfo = billInfoDao.findByBillCode(goodsBillCode);
		billInfo.setBillState("作废");
		billInfo.setWriteDate(new Date());
		
		CargoReceiptDetail cargoReceiptDetail = cargoReceiptDetailDao.findByGoodsBillDetailId(goodsBillCode);
		
		try {
			goodsBillEventDao.save(goodsBillEvent);
			billInfoDao.save(billInfo);
			cargoReceiptDetailDao.delete(cargoReceiptDetail);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("货运单删除失败");
			return false;
		}
	}

	@Override
	public List<GoodsBill> findDriverIdIsNull() {
		// TODO Auto-generated method stub
		return goodsBillDao.findDriverIdIsNull();
	}

	@Override
	public List<GoodsBill> findWaitReceive(String customerCode) {
		// TODO Auto-generated method stub
		return goodsBillDao.findWaitReceived(customerCode);
	}

	@Override
	public Page<GoodsBill> findInformGet(String type, Pageable pageable) {
		// TODO Auto-generated method stub
		return goodsBillDao.informGet(type, pageable);
	}

	@Override
	public Page<GoodsBill> findOldInform(String type, Pageable pageable) {
		// TODO Auto-generated method stub
		return goodsBillDao.findOldCall(type, pageable);
	}

	@Override
	public Page<GoodsBill> findAllGot(Pageable pageable) {
		// TODO Auto-generated method stub
		return goodsBillDao.findAllGot(pageable);
	}

}
