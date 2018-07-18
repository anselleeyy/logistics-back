package com.ansel;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ansel.bean.Employee;
import com.ansel.bean.GoodsBill;
import com.ansel.bean.Region;
import com.ansel.bean.User;
import com.ansel.dao.IEmployeeDao;
import com.ansel.dao.IGoodsBillDao;
import com.ansel.dao.IRegionDao;
import com.ansel.dao.IRouteInfoDao;
import com.ansel.dao.IUserDao;
import com.ansel.service.IRouteService;
import com.ansel.util.Enctype;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogisticsApplicationTests {
	
	@Autowired
	private IUserDao userDao;
	
	
	@Autowired
	private IEmployeeDao employeeDao;
	
	@Autowired
	private IRouteService routeService;
	
	@Autowired
	private IRegionDao regionDao;
	
	@Autowired
	private IRouteInfoDao routeInfoDao;
	
	@Autowired
	private IGoodsBillDao goodsBillDao;
	
	@Test
	public void contextLoads() {

	}
	
//	@Test
//	public void test1() {
//		User user = userDao.findByLoginId("test01");
//		System.out.println(user);
//	}
//	
//	@Test
//	public void test2() {
//		Employee employee = employeeDao.findByEmployeeCode("2015");
//		System.out.println(employee);
//	}
//	
//	@Test
//	public void test3() {
//		String password = Enctype.MD5("123456");
//		System.out.println(password);
//	}
//	
//	@Test
//	public void test4() {
//		User user = new User();
//		user.setLoginId("PJ70405");
//		userDao.delete(user);
//	}
//	
//	@Test
//	public void test5() {
//		employeeDao.updateDepartment("财务组", "财务xx");
//	}
//	
//	@Test
//	public void test6() {
//		routeService.generateRoute();
//	}
//	
//	@Test
//	public void test7() {
//		List<Region> regions = regionDao.findLeftRegions();
//		System.out.println(regions);
//	}
//	
//	@Test
//	public void test8() {
//		routeInfoDao.truncateTable();
//	}
//	
//	@Test
//	public void test9() {
////		Date date = new Date();
//		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
//		System.out.println(calendar.get(Calendar.MONTH)+1);
//	}
//	
//	@Test
//	public void test10() {
//		List<GoodsBill> list = goodsBillDao.transferState("未到车辆", "SJ311122");
//		System.out.println(list);
//	}
	
//	@Test
//	public void test11() {
//		FunctionWithGroup functionWithGroup = functionWithGroupDao.findByFunctionIdAndGroupId(1, 2);
//		System.out.println(functionWithGroup);
//	}
}
