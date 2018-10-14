package com.cool.service;

import com.cool.entity.HouseUser;

/**
 * @Auther: cjc 2018/8/24 0024
 */
public interface UserService {
	public HouseUser login(HouseUser user);
	public void addUser( HouseUser user );
}
