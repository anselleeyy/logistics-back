package com.ansel.service;

import java.util.List;

import com.ansel.bean.CarCost;
import com.ansel.bean.ContactsService;
import com.ansel.bean.CustomerAmount;
import com.ansel.bean.DriverAmount;
import com.ansel.bean.GoodsBill;
import com.ansel.bean.LineOverall;

public interface IMoniterService {

	List<GoodsBill> selectAllUnArrive();

	List<GoodsBill> selectAllUnTake();

	List<CustomerAmount> selectAllCusAcount();

	List<DriverAmount> selectAllDriAcount();

	List<ContactsService> printAllContactsService();

	List<LineOverall> printAllLineOverall();

	List<CarCost> printAllCarCost();

	CarCost selectByCode(String driverCode);

	ContactsService selectByGoodsBillCode(String goodsBillCode);


}
