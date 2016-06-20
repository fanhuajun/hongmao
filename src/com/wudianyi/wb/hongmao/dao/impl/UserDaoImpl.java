package com.wudianyi.wb.hongmao.dao.impl;

import java.util.List;

import javax.management.Query;

import org.springframework.stereotype.Repository;

import com.wudianyi.wb.hongmao.dao.UserDao;
import com.wudianyi.wb.hongmao.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

	@Override
	public List getUserWithMoney(Integer shopid, int pn, int ps) {
		String hql = "select u.rank,u.name,u.phone,s.prepayjson,u.createdate from User u,Shopvip s where";
		if (shopid != null) {
			hql += " u.shopid=" + shopid + " and s.shopid="+shopid+" and";

		}
		hql += " u.id=s.userid order by u.createdate desc";
		return this.getSession().createQuery(hql).setFirstResult(ps * (pn - 1))
				.setMaxResults(ps).list();
	}
}
