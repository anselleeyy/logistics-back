package com.ansel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ansel.bean.CustomerBillClear;
import com.ansel.bean.DriverClear;
import com.ansel.bean.ExtraClear;
import com.ansel.bean.ProxyFeeClear;

public interface IClearService {
	
	public List<DriverClear> selectDrclear(String eventName);

	public DriverClear selectByCargoReceiptCode(String goodsBillCode);

	public boolean driClear(DriverClear driverClear);

	public List<CustomerBillClear> selectCusclear(String eventName);

	public CustomerBillClear selectByBillCode(String goodsBillCode);

	public boolean cusClear(CustomerBillClear customerBillClear);

	public List<ProxyFeeClear> selectHelpclear(String eventName);

	public ProxyFeeClear selectByGoodsBillCode(String goodsBillCode);

	public boolean helpClear(ProxyFeeClear proxyFeeClear);

	public boolean saveExtraClear(ExtraClear extraClear);

	public Page<ExtraClear> selectAllExtraClearByPage(Pageable pageable);

}
