package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.CommentService;

public class CommentAction extends BaseAction {
	@Resource
	private CommentService commentService;

	public String list() {
		Integer shopid = (Integer) getSession(Const.SESSION_SHOPID);
		QueryParam param = new QueryParam();
		param.add("shopid", shopid);
		list = commentService.getList(param, 0, 0, "createdate", "asc", false);
		int total = commentService.getTotalCount(param, false);
		setAttribute("total", total);
		return "list";
	}
}