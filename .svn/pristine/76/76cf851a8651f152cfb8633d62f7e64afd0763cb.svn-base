package com.wudianyi.wb.hongmao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.ShopDao;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.ShopService;

@Service
public class ShopServiceImpl extends BaseServiceImpl<Shop, Integer> implements
		ShopService {
	@Resource
	private ShopDao shopDao;

	@Resource
	public void setBaseDao(ShopDao shopDao) {
		super.setBaseDao(shopDao);
	}

	@Override
	public List<Shop> getNearestShopByUserLoaction(double lat, double lng,
			int cityid, Integer areaid, Integer circleid, Integer oneid,
			Integer twoid, int start, int limit) {
		// TODO Auto-generated method stub
		return shopDao.getNearestShopByUserLoaction(lat, lng, cityid, areaid,
				circleid, oneid, twoid, start, limit);

	}

	/**
	 * 找出我所代言的商店
	 * 
	 * @param userid
	 *            用户id
	 * @param start
	 *            分页开始
	 * @param limit
	 *            分页数量
	 * @return
	 */
	public List<Shop> getMyShops(int userid, int tt, int start, int limit) {
		return shopDao.getMyShops(userid, tt, start, limit);
	}
}
