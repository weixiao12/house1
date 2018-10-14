package com.cool.daoImpl;

import com.cool.dao.DistrictDAO;
import com.cool.entity.District;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: cjc 2018/8/28 0028
 */
@Repository
public class DistrictDAOImpl extends BaseDAO implements DistrictDAO {
	@Override
	public List<District> getAll() {

		List<District> districts = this.getHibernateTemplate().execute(new HibernateCallback<List<District>>() {
			@Override
			public List<District> doInHibernate(Session session) throws HibernateException {
					String hql = "from District";
				//	String hql = "from District d left join fetch d.streets";
					List<District> disList = session.createQuery(hql).list() ;
					return disList;
			}
		});

//		String hql = "from District";
//		List<District> districts =  (List<District>)this.getHibernateTemplate().find(hql);

		return districts;
	}
}
