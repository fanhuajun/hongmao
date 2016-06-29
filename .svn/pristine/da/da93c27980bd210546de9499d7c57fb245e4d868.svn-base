package com.wudianyi.wb.hongmao.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wudianyi.wb.hongmao.dao.ShopDao;
import com.wudianyi.wb.hongmao.entity.Shop;

@Repository
public class ShopDaoImpl extends BaseDaoImpl<Shop, Integer> implements ShopDao {

	@Override
	public List<Shop> getNearestShopByUserLoaction(double lat, double lng,
			int cityid, Integer areaid, Integer circleid, Integer oneid,
			Integer twoid, int start, int limit) {
		String hql = "from Shop s where s.cityid=" + cityid;
		if (areaid != null) {
			hql += " and s.areaid=" + areaid;
		}
		if (circleid != null) {
			hql += " and s.circleid=" + circleid;
		}
		if (circleid != null) {
			hql += " and s.shoptypeone=" + oneid;
		}
		if (circleid != null) {
			hql += " and s.shoptypetwo=" + twoid;
		}
		hql += (" order by ((s.latitude-" + lat + ")*(s.latitude-" + lat
				+ ")+(s.longitude-" + lng + ")*(s.longitude-" + lng + ")) asc");
		return this.getSession().createQuery(hql).setFirstResult(start)
				.setMaxResults(limit).list();
	}

	@Override
	public List<Shop> getMyShops(int userid, int tt, int start, int limit) {
		String hql = "select s from Shop s,Shopvip sv where sv.userid=:userid and sv.tt=:tt and s.id=sv.shopid order by sv.createdate desc";
		return this.getSession().createQuery(hql)
				.setParameter("userid", userid).setParameter("tt", tt)
				.setFirstResult(start).setMaxResults(limit).list();
	}
}
