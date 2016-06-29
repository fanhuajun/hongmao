package com.wudianyi.wb.hongmao.action.admin.json;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.CircleService;

public class CircleAction extends BaseAction {

	@Resource
	private CircleService circleService;

	public String list() {

		QueryParam params = new QueryParam();
		System.err.println("keyword:" + keyword);
		list = circleService.getLikeList("phone", keyword, null, params,
				(pn - 1) * Const.BACK_PAGE_SIZE, Const.BACK_PAGE_SIZE, null,
				null, false);
		System.err.println("list:" + list);
		return LIST;
	}

	public String totalNum() {
		System.out.println("keyword========" + keyword);
		tn = circleService.getLikeTotalCount("phone", keyword, null, null,
				false);
		System.out.println("tn========" + tn);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}
}
