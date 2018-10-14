package com.cool.dao;

import com.cool.entity.House;
import com.cool.util.PageResult;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Auther: cjc 2018/8/25 0025
 */
public interface HouseDAO {
	public List<House> getHouseByPage( DetachedCriteria dc, PageResult page );
	public Integer getHouseCountByPage( DetachedCriteria dc, PageResult page );
	public House getHouseById( Integer houseId  );
	public void addHouse( House house );
	public void update( House house );

}
