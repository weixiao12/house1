package com.cool.daoImpl;

import com.cool.dao.HouseTypeDAO;
import com.cool.entity.HouseType;
import com.cool.entity.Street;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: cjc 2018/8/27 0027
 */
@Repository
public class HouseTypeDAOImpl extends BaseDAO implements HouseTypeDAO {
	@Override
	public List<HouseType> getAll() {
		String hql = "from HouseType";
		return (List<HouseType>) this.getHibernateTemplate().find(hql);
	}
}
