package com.wudianyi.wb.hongmao.dao;

import java.util.List;

import com.wudianyi.wb.hongmao.entity.Shop;

public interface ShopDao extends BaseDao<Shop, Integer> {
	/**
	 * 根据用户的坐标找出用户最靠近的商店
	 * 
	 * @param lat
	 *            纬度
	 * @param lng
	 *            经度
	 * @param cityid
	 *            城市id（必填）
	 * @param areaid
	 *            区域id
	 * @param circleid
	 *            商圈id
	 * @param oneid
	 *            第一级分类
	 * @param twoid
	 *            第二级分类
	 * @param start
	 *            分页开始
	 * @param limit
	 *            分页大小
	 * @return 从近到远返回商店
	 */
	public List<Shop> getNearestShopByUserLoaction(double lat, double lng,
			int cityid, Integer areaid, Integer circleid, Integer oneid,
			Integer twoid, int start, int limit);

	/**
	 * 找出我的商店
	 * @param tt 0:我消费的商家，1：我代言的商家
	 * @param userid 用户id
	 * @param start 分页开始
	 * @param limit 分页数量
	 * @return
	 */
	public List<Shop> getMyShops(int userid,int tt, int start, int limit);
}