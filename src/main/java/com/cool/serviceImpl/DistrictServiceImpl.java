package com.cool.serviceImpl;

import com.cool.dao.DistrictDAO;
import com.cool.entity.District;
import com.cool.service.DistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: cjc 2018/8/28 0028
 */
@Service
public class DistrictServiceImpl implements DistrictService {

	@Resource
	private DistrictDAO districtDAO;

	@Override
	public List<District> getAll() {
		return districtDAO.getAll();
	}
}
