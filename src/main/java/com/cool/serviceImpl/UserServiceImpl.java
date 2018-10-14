package com.cool.serviceImpl;

import com.cool.dao.UserDAO;
import com.cool.entity.HouseUser;
import com.cool.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: cjc 2018/8/24 0024
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDAO;

	@Override
	public HouseUser login(HouseUser user) {
		return userDAO.getUserByNameAndPwd(user);
	}

	@Override
	public void addUser(HouseUser user) {
		userDAO.addUser(user);
	}
}
