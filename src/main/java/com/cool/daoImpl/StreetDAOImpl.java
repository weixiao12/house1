package com.cool.daoImpl;

import com.cool.dao.StreetDAO;
import com.cool.entity.Street;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: cjc 2018/8/27 0027
 */
@Repository
public class StreetDAOImpl extends BaseDAO implements StreetDAO {
	@Override
	public List<Street> getAll() {
		String hql = "from Street";
		return (List<Street>) this.getHibernateTemplate().find(hql);
	}
}
