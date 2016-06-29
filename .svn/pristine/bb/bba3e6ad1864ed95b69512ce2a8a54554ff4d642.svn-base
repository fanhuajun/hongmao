package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.NewsService;

public class NewsAction extends BaseAction {
	@Resource
	private NewsService newsService;

	@Override
	public String execute() throws Exception {
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);

		list = newsService.getList(new QueryParam(1).add("shopid", shopid), 0,
				0, "createdate", "desc", false);
		return "news";
	}
}
