package com.ansel.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ansel.bean.User;
import com.ansel.dao.IUserDao;
import com.ansel.service.IUserService;
import com.ansel.util.Enctype;

@Transactional(propagation = Propagation.REQUIRED)
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public Map<?, ?> userLogin(String loginId, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		try {
			User user = userDao.findByLoginId(loginId);
			if (user.getPassword().equals(Enctype.MD5(password))) {
				// 上线
				userDao.updateOnline(true, loginId);
				result.put("STATUS", "SUCCESS");
				result.put("USER", user);
			} else {
				result.put("STATUS", "ERROR");
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("用户密码验证失败");
			result.put("STATUS", "ERROR");
			return result;
		}
	}

	@Override
	public boolean ifExist(String loginId) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = userDao.findByLoginId(loginId) == null ? false : true;
		return flag;
	}

	@Override
	public boolean changePassword(String loginId, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		User user = userDao.findByLoginId(loginId);
		if (Enctype.MD5(oldPassword).equals(user.getPassword())) {
			user.setPassword(Enctype.MD5(newPassword));
			userDao.save(user);
			return true;
		}
		return false;
	}

	
}
