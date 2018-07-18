package com.ansel.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ansel.bean.DriverInfo;
import com.ansel.bean.User;
import com.ansel.bean.UserWithGroup;
import com.ansel.dao.IDriverInfoDao;
import com.ansel.dao.IGroupDao;
import com.ansel.dao.IUserDao;
import com.ansel.dao.IUserWithGroupDao;
import com.ansel.service.IDriverInfoService;

@Transactional
@Service(value = "driverInfoService")
public class DriverInfoServiceImpl implements IDriverInfoService {
	
	@Autowired
	private IDriverInfoDao driverInfoDao;
	
	@Autowired
	private IUserWithGroupDao userWithGroupDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IGroupDao groupDao;

	@Override
	public Page<DriverInfo> findAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return driverInfoDao.findAll(pageable);
	}

	@Override
	public boolean addNewDriver(DriverInfo driverInfo) {
		// TODO Auto-generated method stub
		
		driverInfo.setState("空闲");
		String driverCode = "SJ";
		
		while (true) {
			driverCode += randomCode();
			if (driverInfoDao.findById(driverCode) == null) {
				break;
			}
		}
		driverInfo.setId(driverCode);
		try {
			
			// 添加用户信息表
			User user = new User(driverCode, "E10ADC3949BA59ABBE56E057F20F883E", false);
			userDao.save(user);

			// 添加用户与组情况
			String department = "司机组";
			int groupId = groupDao.findByGroupName(department).getId();
			UserWithGroup userWithGroup = new UserWithGroup();
			userWithGroup.setGroupId(groupId);
			userWithGroup.setUserId(driverCode);
			userWithGroupDao.save(userWithGroup);

			driverInfoDao.save(driverInfo);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("司机信息表 | 用户信息表 | 用户与组表 插入失败");
			return false;			
		}
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		DriverInfo driverInfo = driverInfoDao.findById(id);
		User user = userDao.findByLoginId(id);
		UserWithGroup userWithGroup = userWithGroupDao.findByUserId(id);
		try {
			driverInfoDao.delete(driverInfo);
			userDao.delete(user);
			userWithGroupDao.delete(userWithGroup);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("司机信息 | 用户表 | 用户与组表 删除失败");
			return false;
		}
	}

	@Override
	public boolean updateById(String id, DriverInfo driverInfo) {
		// TODO Auto-generated method stub
		
		DriverInfo oldDriverInfo = driverInfoDao.findById(id);
		driverInfo.setState(oldDriverInfo.getState());
		
		try {
			driverInfoDao.save(driverInfo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("司机信息更新失败");
			return false;
		}
	}

	@Override
	public DriverInfo findById(String id) {
		// TODO Auto-generated method stub
		return driverInfoDao.findById(id);
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
	public List<String> findAllId() {
		// TODO Auto-generated method stub
		return driverInfoDao.findAllId();
	}

}
