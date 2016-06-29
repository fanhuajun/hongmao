package com.wudianyi.wb.hongmao.action.json;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.util.StringUtils;

public class ShopsAction extends BaseAction {

	private Integer areaid;
	private Integer circleid;
	private Integer oneid;
	private Integer twoid;
	private String keyword;
	private String sort;
	private int pn;
	@Resource
	private ShopService shopService;

	@Override
	public String execute() throws Exception {
		String orderbyparam = "createdate";
		String orderby = "desc";
		if (!StringUtils.isEmpty(sort)) {
			if (sort.equals("point")) {
				orderbyparam = "point";
			} else if (sort.equals("moneylow")) {
				orderbyparam = "consumption";
				orderby = "asc";
			} else if (sort.equals("moneyhigh")) {
				orderbyparam = "consumption";
				orderby = "desc";
			}

		}

		Integer cityid = (Integer) getSession(Const.SESSION_CITY_ID);
		// 如果是根据距离的大小来排序的，则需要一个新方法
		if ((!StringUtils.isEmpty(sort)) && sort.equals("near")) {
			String lng_lat = (String) getSession(Const.SESSION_LONG_LAT);
			String[] lng_lat_array = lng_lat.split(",");
			// 根据距离远近排序
			list = shopService.getNearestShopByUserLoaction(
					Double.parseDouble(lng_lat_array[1]),
					Double.parseDouble(lng_lat_array[0]), cityid, areaid,
					circleid, oneid, twoid, Const.FRONT_PAGE_SIZE * (pn - 1),
					Const.FRONT_PAGE_SIZE);
		} else {
			System.err.println("---------");
			QueryParam params = new QueryParam(6).add("cityid", cityid)
					.add("areaid", areaid).add("cityid", cityid)
					.add("shoptypeone", oneid).add("shoptypetwo", twoid).add("id!", 0);
			list = shopService.getLikeList("name", keyword, null, params,
					Const.FRONT_PAGE_SIZE * (pn - 1), Const.FRONT_PAGE_SIZE,
					orderbyparam, orderby, false);
		}
		return LIST;
	}

	public String mine() {
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		list = shopService.getMyShops(userid, 1, Const.FRONT_PAGE_SIZE
				* (pn - 1), Const.FRONT_PAGE_SIZE);
		return LIST;
	}

	public String consume() {
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		list = shopService.getMyShops(userid, 0, Const.FRONT_PAGE_SIZE
				* (pn - 1), Const.FRONT_PAGE_SIZE);
		setAttribute("consume", 1);
		return LIST;
	}

	public Integer getCircleid() {
		return circleid;
	}

	public void setCircleid(Integer circleid) {
		this.circleid = circleid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public Integer getOneid() {
		return oneid;
	}

	public void setOneid(Integer oneid) {
		this.oneid = oneid;
	}

	public Integer getTwoid() {
		return twoid;
	}

	public void setTwoid(Integer twoid) {
		this.twoid = twoid;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
