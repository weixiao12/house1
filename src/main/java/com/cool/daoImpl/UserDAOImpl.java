package com.cool.daoImpl;

import com.cool.dao.UserDAO;
import com.cool.entity.HouseUser;
import com.cool.util.SpringTool;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

/**
 * @Auther: cjc 2018/8/24 0024
 */
@Repository
	public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public HouseUser getUserByNameAndPwd(HouseUser user) {
		return this.getHibernateTemplate().execute(new HibernateCallback<HouseUser>() {
			@Override
			public HouseUser doInHibernate(Session session) throws HibernateException {
				String hql  = "from HouseUser u where u.userName = ? and u.password = ?";
				Query query = session.createQuery(hql);
				query.setString(0, user.getUserName());
				query.setString(1,user.getPassword());
				HouseUser u = (HouseUser) query.uniqueResult();
				return u;
			}
		});
	}

	@Override
	public void addUser(HouseUser user) {
		this.getHibernateTemplate().save(user);
	}
}
