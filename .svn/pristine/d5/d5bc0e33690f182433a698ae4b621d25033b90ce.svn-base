package com.wudianyi.wb.hongmao.action.json;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.PrepaylogService;

public class IncomeAction extends BaseAction {
	@Resource
	private PrepaylogService prepaylogService;
	private int pn;

	public String list() {

		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		list = prepaylogService.getList(new QueryParam(2).add("userid", userid).add("tt", 1),
				Const.FRONT_PAGE_SIZE * (pn - 1), Const.FRONT_PAGE_SIZE,
				"createdate", "desc", false);
		return LIST;
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

}
