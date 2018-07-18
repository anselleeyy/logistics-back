package com.ansel.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ansel.bean.CargoReceipt;
import com.ansel.bean.EmployeeWage;
import com.ansel.bean.ExtraClear;
import com.ansel.bean.ExtraIncome;
import com.ansel.bean.FinanceFee;
import com.ansel.bean.IncomeMonthlyTemp;
import com.ansel.bean.ManageFee;
import com.ansel.dao.ICargoReceiptDao;
import com.ansel.dao.IEmployeeWageDao;
import com.ansel.dao.IExtraClearDao;
import com.ansel.dao.IExtraIncomeDao;
import com.ansel.dao.IFinanceFeeDao;
import com.ansel.dao.IIncomeMonthlyTempDao;
import com.ansel.dao.IManageFeeDao;
import com.ansel.service.ICheckService;

@Transactional(propagation = Propagation.REQUIRED)
@Service(value = "iCheckService")
public class CheckServiceImpl implements ICheckService {

	@Autowired
	private IExtraIncomeDao extraIncomeDao;

	@Autowired
	private ICargoReceiptDao cargoReceiptDao;

	@Autowired
	private IFinanceFeeDao financeFeeDao;

	@Autowired
	private IManageFeeDao manageFeeDao;

	@Autowired
	private IEmployeeWageDao employeeWageDao;

	@Autowired
	private IExtraClearDao extraClearDao;

	@Autowired
	private IIncomeMonthlyTempDao iMonthlyTempDao;

	@Override
	public boolean save(ExtraIncome extraIncome) {
		// TODO Auto-generated method stub
		try {
			extraIncomeDao.save(extraIncome);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("营业外收入添加失败");
			return false;
		}
	}

	@Override
	public Page<ExtraIncome> selectAllExtra(Pageable pageable) {
		// TODO Auto-generated method stub
		return extraIncomeDao.findAll(pageable);
	}

	@Override
	public List<ExtraIncome> selectByIncomeMonth(String incomeMonth) {
		// TODO Auto-generated method stub
		return extraIncomeDao.findByIncomeMonth(incomeMonth);
	}

	@Override
	public List<CargoReceipt> selectBySignTime(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date date1 = null;
		try {
			date = df.parse(beginTime);
			date1 = df.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cargoReceiptDao.findBySignTime(date, date1);
	}

	@Override
	public boolean save(FinanceFee financeFee) {
		// TODO Auto-generated method stub
		try {
			financeFeeDao.save(financeFee);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("财务费用添加失败");
			return false;
		}
	}

	@Override
	public Page<FinanceFee> selectAllFinance(Pageable pageable) {
		// TODO Auto-generated method stub
		return financeFeeDao.findAll(pageable);
	}

	@Override
	public List<FinanceFee> selectByFPayoutMonth(String payoutMonth) {
		// TODO Auto-generated method stub
		return financeFeeDao.findByPayoutMonth(payoutMonth);
	}

	@Override
	public boolean save(ManageFee manageFee) {
		// TODO Auto-generated method stub
		try {
			manageFeeDao.save(manageFee);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("管理费用添加失败");
			return false;
		}
	}

	@Override
	public Page<ManageFee> selectAllManage(Pageable pageable) {
		// TODO Auto-generated method stub
		return manageFeeDao.findAll(pageable);
	}

	@Override
	public List<ManageFee> selectByMPayoutMonth(String payoutMonth) {
		// TODO Auto-generated method stub
		return manageFeeDao.findByPayoutMonth(payoutMonth);
	}

	@Override
	public ManageFee selectByMId(int id) {
		// TODO Auto-generated method stub
		return manageFeeDao.findById(id);
	}

	@Override
	public boolean save(EmployeeWage employeeWage) {
		// TODO Auto-generated method stub
		try {
			employeeWageDao.save(employeeWage);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("员工工资添加失败");
			return false;
		}
	}

	@Override
	public Page<EmployeeWage> selectAllWage(Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeWageDao.findAll(pageable);
	}

	@Override
	public List<EmployeeWage> selectByDate(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date date1 = null;
		try {
			date = df.parse(beginTime);
			date1 = df.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeWageDao.findByDate(date, date1);
	}

	@Override
	public EmployeeWage selectByEmployeeCode(String employeeCode) {
		// TODO Auto-generated method stub
		return employeeWageDao.findByEmployeeCode(employeeCode);
	}

	@Override
	public List<ExtraClear> selectByBalanceDate(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date date1 = null;
		try {
			date = df.parse(beginTime);
			date1 = df.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extraClearDao.findByBalanceDate(date, date1);
	}

	@Override
	public IncomeMonthlyTemp save() {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
		String cMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		String cYear = String.valueOf(calendar.get(Calendar.YEAR));
		if (cMonth.length() == 1) {
			cMonth = "0" + cMonth;
		}
		String cTime = cYear + "-" + cMonth;
		String bTime = cTime + "-01";
		String eTime = cTime + "-31";
		double carriageMoney = 0;
		double insuranceMoney = 0;
		double unbizIncome = 0;
		double fFee = 0;
		double officeFee = 0;
		double houseRent = 0;
		double waterElecFee = 0;
		double phoneFee = 0;
		double other = 0;
		double wage = 0;
		double balanceMoney = 0;
		double carCarriage = 0;
		double payOut = 0;
		double income = 0;
		// 运费、保险费（营业收入）
		List<CargoReceipt> cargoReceipts = selectBySignTime(bTime, eTime);
		System.out.println(1);
		for (int i = 0; i < cargoReceipts.size(); i++) {
			carriageMoney += cargoReceipts.get(i).getAllCarriage();
			insuranceMoney += cargoReceipts.get(i).getInsurance();
		}
		// 非营业收入
		List<ExtraIncome> extraIncomes = selectByIncomeMonth(cTime);
		System.out.println(1);
		for (int i = 0; i < extraIncomes.size(); i++) {
			unbizIncome += extraIncomes.get(i).getMoney();
		}
		// 收入
		income = carriageMoney + insuranceMoney + unbizIncome;
		// 财务费用
		List<FinanceFee> financeFees = selectByFPayoutMonth(cTime);
		System.out.println(1);
		for (int i = 0; i < financeFees.size(); i++) {
			fFee += financeFees.get(i).getFee();
		}
		// 管理费用
		List<ManageFee> manageFees = selectByMPayoutMonth(cTime);
		System.out.println(1);
		for (int i = 0; i < manageFees.size(); i++) {
			officeFee += manageFees.get(i).getOfficeFee();
			houseRent += manageFees.get(i).getHouseRent();
			waterElecFee += manageFees.get(i).getWaterElecFee();
			phoneFee += manageFees.get(i).getPhoneFee();
			other += manageFees.get(i).getOtherPayout();
		}
		// 工资
		List<EmployeeWage> employeeWages = selectByDate(bTime, eTime);
		System.out.println(1);
		for (int i = 0; i < employeeWages.size(); i++) {
			wage += (employeeWages.get(i).getBasicWage() + employeeWages.get(i).getAllowance()
					+ employeeWages.get(i).getStationWage());
		}
		// 经营费用（搬运费、车运费）
		List<ExtraClear> extraClears = selectByBalanceDate(bTime, eTime);
		System.out.println(1);
		for (int i = 0; i < extraClears.size(); i++) {
			balanceMoney += extraClears.get(i).getBalanceMoney();
		}
		carCarriage = 500;
		// 支出
		payOut = carCarriage + balanceMoney + wage + officeFee + houseRent + waterElecFee + phoneFee + officeFee + fFee;
		try {
				IncomeMonthlyTemp iMonthlyTemp = selectByMonth(cTime);
				if (iMonthlyTemp == null) {
					iMonthlyTemp = new IncomeMonthlyTemp();
				}
				iMonthlyTemp.setMonth(cTime);
				iMonthlyTemp.setCarriageMoney(carriageMoney);
				iMonthlyTemp.setInsuranceMoney(insuranceMoney);
				iMonthlyTemp.setBizIncome(insuranceMoney + carriageMoney);
				iMonthlyTemp.setUnbizIncome(unbizIncome);
				iMonthlyTemp.setIncome(income);
				iMonthlyTemp.setFinanceFee(fFee);
				iMonthlyTemp.setOfficeFee(officeFee);
				iMonthlyTemp.setHouseRent(houseRent);
				iMonthlyTemp.setWaterElecFee(waterElecFee);
				iMonthlyTemp.setPhoneFee(phoneFee);
				iMonthlyTemp.setOther(other);
				iMonthlyTemp.setManageFee(officeFee + houseRent + waterElecFee + phoneFee + other);
				iMonthlyTemp.setWage(wage);
				iMonthlyTemp.setConveyWage(balanceMoney);
				iMonthlyTemp.setCarCarriage(carCarriage);
				iMonthlyTemp.setBizFee(carCarriage + balanceMoney);
				iMonthlyTemp.setPayout(payOut);
				iMonthlyTemp.setProfit(income - payOut);
				iMonthlyTempDao.save(iMonthlyTemp);
				return iMonthlyTemp;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("月报信息添加失败");
			return null;
		}
	}

	@Override
	public IncomeMonthlyTemp selectByMonth(String month) {
		// TODO Auto-generated method stub
		return iMonthlyTempDao.findByMonth(month);
	}

	@Override
	public IncomeMonthlyTemp selectAll() {
		// TODO Auto-generated method stub
		return save();
	}

}
