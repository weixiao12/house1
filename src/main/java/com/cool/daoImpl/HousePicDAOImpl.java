package com.cool.daoImpl;

import com.cool.dao.HousePicDAO;
import com.cool.entity.HousePicture;
import com.cool.service.HousePicService;
import org.springframework.stereotype.Repository;

/**
 * @Auther: cjc 2018/8/31 0031
 */
@Repository
public class HousePicDAOImpl extends BaseDAO implements HousePicDAO {

	@Override
	public void addPic(HousePicture hp) {
		this.getHibernateTemplate().save(hp);
	}
}
