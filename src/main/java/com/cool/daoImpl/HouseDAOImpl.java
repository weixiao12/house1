package com.cool.daoImpl;

import com.cool.dao.HouseDAO;
import com.cool.entity.House;
import com.cool.util.PageResult;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: cjc 2018/8/26 0026
 */
@Repository
public class HouseDAOImpl extends BaseDAO implements HouseDAO {
	@Override
	public Integer getHouseCountByPage(DetachedCriteria dc, PageResult page) {
		return this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Criteria criteria = dc.getExecutableCriteria(session);
				criteria.setProjection(Projections.rowCount());
				Integer rowCount = ((Long)criteria.uniqueResult()).intValue();
				return rowCount;
			}
		});
	}


	@Override
	public List<House> getHouseByPage(DetachedCriteria dc, PageResult page) {
		return this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<House>>() {
			@Override
			public List<House> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = dc.getExecutableCriteria(session);
				criteria.setProjection(null);
				criteria.addOrder(Order.desc("adddate"));
				criteria.setFirstResult(page.getFirstResult());
				criteria.setMaxResults(page.getPageSize());
				List<House> list = criteria.list();
				return list;
			}
		});
	}

	@Override
	public House getHouseById(Integer houseId) {
		return this.getHibernateTemplate().get(House.class,houseId);
	}

	/**
	 * 发布房子信息
	 * @param house
	 */
	@Override
	public void addHouse(House house) {
		this.getHibernateTemplate().save(house);
	}

	@Override
	public void update(House house) {
		this.getHibernateTemplate().update(house);
	}
}
