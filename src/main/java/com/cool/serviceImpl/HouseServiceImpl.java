package com.cool.serviceImpl;

import com.cool.dao.HouseDAO;
import com.cool.entity.House;
import com.cool.service.HouseService;
import com.cool.util.PageResult;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: cjc 2018/8/26 0026
 */
@Service
public class HouseServiceImpl implements HouseService {

	@Resource
	private HouseDAO houseDAO;

	@Override
	public void getHouseByPage( PageResult page,House house ) {
		DetachedCriteria dc = DetachedCriteria.forClass(House.class);
		dc.add(Restrictions.eq("isDelete",0));
		if( house.getTitle() != null && !"".equals(house.getTitle()) ){
			dc.add(Restrictions.like("title","%"+house.getTitle()+"%"));
		}
		if( house.getStreet() != null && house.getStreet().getStreetId() != null ){
			dc.add(Restrictions.eq("street.streetId",house.getStreet().getStreetId()));
		}
		if( house.getHouseType() != null && house.getHouseType().getHtypeId() != null ){
			dc.add(Restrictions.eq("houseType.typeId",house.getHouseType().getHtypeId()));
		}
		if( house.getPriceScore() != null && !"".equals(house.getPriceScore()) ){
			String[] strs = house.getPriceScore().split("-");
			dc.add(Restrictions.ge("price",Double.valueOf(strs[0])));
			dc.add(Restrictions.le("price",Double.valueOf(strs[1])));
		}
		if( house.getFloorageScore() != null && !"".equals(house.getFloorageScore()) ){
			String[] fss = house.getFloorageScore().split("-");
			dc.add(Restrictions.ge("floorage",Double.valueOf(fss[0])));
			dc.add(Restrictions.le("floorage",Double.valueOf(fss[1])));
		}
		int rowCount = houseDAO.getHouseCountByPage(dc,page);
		page.setRowCount(rowCount);
		List<House> listHouse =  houseDAO.getHouseByPage(dc,page);
		page.setData(listHouse);
	}

	@Override
	public House getHouseById(Integer houseId) {
		return houseDAO.getHouseById(houseId);
	}

	@Override
	public void addHouse(House house) {
		houseDAO.addHouse(house);
	}

	@Override
	public void update(House house) {
		houseDAO.update(house);
	}
}
