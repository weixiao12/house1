package com.cool.dao;

import com.cool.entity.HouseUser;

/**
 * @Auther: cjc 2018/8/24 0024
 */
public interface UserDAO {
	/**
	 * 用户登录接口
	 * @param user
	 * @return
	 */
	public HouseUser getUserByNameAndPwd(HouseUser user);

	public void addUser( HouseUser user );
}
