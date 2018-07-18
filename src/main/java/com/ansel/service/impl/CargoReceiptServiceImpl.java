package com.ansel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ansel.bean.BillInfo;
import com.ansel.bean.CargoReceipt;
import com.ansel.bean.CargoReceiptDetail;
import com.ansel.bean.GoodsBill;
import com.ansel.bean.GoodsBillEvent;
import com.ansel.bean.RouteInfo;
import com.ansel.dao.IBillInfoDao;
import com.ansel.dao.ICargoReceiptDao;
import com.ansel.dao.ICargoReceiptDetailDao;
import com.ansel.dao.IGoodsBillDao;
import com.ansel.dao.IGoodsBillEventDao;
import com.ansel.dao.IRegionDao;
import com.ansel.dao.IRouteInfoDao;
import com.ansel.service.ICargoReceiptService;

@Transactional(propagation = Propagation.REQUIRED)
@Service(value = "cargoReceiptService")
public class CargoReceiptServiceImpl implements ICargoReceiptService {

	@Autowired
	private ICargoReceiptDao cargoReceiptDao;
	
	@Autowired
	private ICargoReceiptDetailDao cargoReceiptDetailDao;
	
	@Autowired
	private IBillInfoDao billInfoDao;
	
	@Autowired
	private IGoodsBillDao goodsBillDao;
	
	@Autowired
	private IGoodsBillEventDao goodsBillEventDao;
	
	@Autowired
	private IRegionDao regionDao;
	
	@Autowired
	private IRouteInfoDao routeInfoDao;
	
	@Override
	public boolean save(CargoReceipt cargoReceipt) {
		// TODO Auto-generated method stub
		try {
			// 保存货运回执单
			cargoReceiptDao.save(cargoReceipt);
			
			// 更新货运单中的中转地和中转费信息
			String loadStation = cargoReceipt.getLoadStation();
			String dealGoodsStation = cargoReceipt.getDealGoodsStation();
			int startStation = regionDao.findByCity(loadStation).getId();
			int endStation = regionDao.findByCity(dealGoodsStation).getId();
			List<RouteInfo> routeList = routeInfoDao.findByStartStationAndEndStation(startStation, endStation);
			String passStation = routeList.get(0).getPassStation();
			for (int i = 1; i < routeList.size(); i++) {
				String temp = routeList.get(i).getPassStation();
				passStation = (temp.length() < passStation.length() ? temp : passStation);
			}
			String[] pass_station = passStation.split(",");
			
			
			String goodsBillCode = cargoReceiptDetailDao.findByGoodsRevertBillId(cargoReceipt.getGoodsRevertBillCode()).getGoodsBillDetailId();
			GoodsBill goodsBill = goodsBillDao.findByGoodsBillCode(goodsBillCode);
			double transfer_fee = 1.3 * pass_station.length;
			goodsBill.setTransferFee(transfer_fee);
			String result = "";
			for (int i = 0; i < pass_station.length; i++) {
				String station_name = regionDao.findById(Integer.valueOf(pass_station[i])).getCity();
				result += (i == 0 ? "" : ",");
				result += station_name;
			}
			goodsBill.setTransferStation(result);
			goodsBillDao.save(goodsBill);
			// 保存单据明细表
			BillInfo billInfo = new BillInfo();
			billInfo.setBillType("货运回执单");
			billInfo.setAcceptStation(cargoReceipt.getAcceptStation());
			billInfo.setBillCode(cargoReceipt.getGoodsRevertBillCode());
			billInfo.setBillState("已填");
			billInfo.setWriteDate(new Date());
			System.out.println(billInfo);
			billInfoDao.save(billInfo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("货运回执单添加失败");
			return false;
		}
	}

	@Override
	public List<String> selectAllCodes() {
		// TODO Auto-generated method stub
		return cargoReceiptDetailDao.findAllCargoReceiptCode();
	}

	@Override
	public GoodsBill selectGoodsBill(String goodsRevertBillCode) {
		// TODO Auto-generated method stub
		String goodsBillCode = cargoReceiptDetailDao.findByGoodsRevertBillId(goodsRevertBillCode).getGoodsBillDetailId();
		return goodsBillDao.findByGoodsBillCode(goodsBillCode);
	}

	@Override
	public List<CargoReceipt> findByDriverId(String driverId) {
		// TODO Auto-generated method stub
		return cargoReceiptDao.findByDriverId(driverId);
	}
	
	@Override
	public Page<CargoReceipt> selectAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return cargoReceiptDao.findAll(pageable);
	}

	@Override
	public Page<CargoReceipt> selectByEvent(String backBillState, Pageable pageable) {
		// TODO Auto-generated method stub
		return cargoReceiptDao.findByBackBillState(pageable, backBillState);
	}

	@Override
	public CargoReceipt selectByCode(String goodsRevertBillCode) {
		// TODO Auto-generated method stub
		return cargoReceiptDao.findByGoodsRevertBillCode(goodsRevertBillCode);
	}

	@Override
	public boolean update(CargoReceipt cargoReceipt) {
		// TODO Auto-generated method stub
		try {
			cargoReceiptDao.save(cargoReceipt);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("货运回执单更新失败");
			return false;
		}
	}
	
	@Override
	public boolean submit(CargoReceipt cargoReceipt) {
		// TODO Auto-generated method stub
		try {
			cargoReceipt.setBackBillState("未到车辆");
			cargoReceiptDao.save(cargoReceipt);
			String goodsBillCode = cargoReceiptDetailDao.findByGoodsRevertBillId(cargoReceipt.getGoodsRevertBillCode()).getGoodsBillDetailId();
			GoodsBillEvent goodsBillEvent = goodsBillEventDao.findByGoodsBillId(goodsBillCode);
			goodsBillEvent.setEventName("未到");
			goodsBillEvent.setOccurTime(new Date());
			goodsBillEventDao.save(goodsBillEvent);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("货运回执单提交失败");
			return false;
		}
	}

	@Override
	public boolean delete(String goodsRevertBillCode) {
		// TODO Auto-generated method stub
		BillInfo billInfo = billInfoDao.findByBillCode(goodsRevertBillCode);
		billInfo.setBillState("作废");
		billInfo.setWriteDate(new Date());
		try {
			CargoReceipt cargoReceipt = new CargoReceipt();
			cargoReceipt.setGoodsRevertBillCode(goodsRevertBillCode);
			cargoReceiptDao.delete(cargoReceipt);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("货运回执单删除失败");
			return false;
		}
	}

	@Override
	public Page<CargoReceipt> findByDriverIdAndState(String driverId, String backBillState, Pageable pageable) {
		// TODO Auto-generated method stub
		return cargoReceiptDao.findByDriverIdAndBackBillState(driverId, backBillState, pageable);
	}

	@Override
	public List<?> selectLeftCodes() {
		// TODO Auto-generated method stub
		return cargoReceiptDetailDao.findLeftCodes();
	}

	@Override
	public CargoReceiptDetail findByGoodsBillCode(String goodsBillCode) {
		// TODO Auto-generated method stub
		return cargoReceiptDetailDao.findByGoodsBillDetailId(goodsBillCode);
	}

}
