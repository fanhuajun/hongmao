package com.wudianyi.wb.hongmao.action.admin.json;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.OrderService;

public class OrderAction extends BaseAction {

	@Resource
	private OrderService orderService;

	private int pn;

	public String jsonlist() {
		Integer isadmin = getSession_is_admin();
		QueryParam param = null;
		if (isadmin == 0) {
			Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
			param = new QueryParam(2).add("shopid", shopid).add("stat>", 0);
		} else {
			param = new QueryParam(1).add("stat>", 0);
		}

		Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);

		list = orderService.getList(param, Const.BACK_PAGE_SIZE * (pn - 1),
				Const.BACK_PAGE_SIZE, "paydate", "desc", false);
		return "jsonlist";
	}

	public String totalNum() {
		Integer isadmin = getSession_is_admin();
		QueryParam param = null;
		if (isadmin == 0) {
			Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
			param = new QueryParam(2).add("shopid", shopid).add("stat>", 0);
		} else {
			param = new QueryParam(1).add("stat>", 0);
		}
		int tn = orderService.getTotalCount(param, false);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

}
