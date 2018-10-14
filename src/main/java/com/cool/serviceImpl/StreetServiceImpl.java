package com.cool.serviceImpl;

import com.cool.dao.StreetDAO;
import com.cool.entity.Street;
import com.cool.service.StreetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: cjc 2018/8/27 0027
 */
@Service
public class StreetServiceImpl implements StreetService {

	@Resource
	private StreetDAO streetDAO;

	@Override
	public List<Street> getAll() {
		return streetDAO.getAll();
	}
}
