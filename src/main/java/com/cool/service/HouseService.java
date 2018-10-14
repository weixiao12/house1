package com.cool.service;

import com.cool.entity.House;
import com.cool.util.PageResult;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Auther: cjc 2018/8/26 0026
 */
public interface HouseService {
	public void getHouseByPage(PageResult page, House house  );
	public House getHouseById( Integer houseId  );
	public void  addHouse( House house );
	public void update( House house );

}
