package com.cool.serviceImpl;

import com.cool.dao.HouseTypeDAO;
import com.cool.dao.StreetDAO;
import com.cool.entity.HouseType;
import com.cool.entity.Street;
import com.cool.service.HouseService;
import com.cool.service.HouseTypeService;
import com.cool.service.StreetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: cjc 2018/8/27 0027
 */
@Service
public class HouseTypeServiceImpl implements HouseTypeService {

	@Resource
	private HouseTypeDAO houseTypeDAO;

	@Override
	public List<HouseType> getAll() {
		return houseTypeDAO.getAll();
	}
}
