package com.wudianyi.wb.hongmao.action.agent.json;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.AgentlogService;

public class LogAction extends BaseAction {

	@Resource
	private AgentlogService agentlogService;

	public String list() {

		Integer agentid = (Integer) getSession(Const.SESSION_ADMIN_AGENTID);
		list = agentlogService.getList(
				new QueryParam(1).add("agentid", agentid), pn - 1
						* (Const.BACK_PAGE_SIZE), Const.BACK_PAGE_SIZE,
				"createdate", "desc", false);
		return LIST;
	}

	public String totalNum() {
		Integer agentid = (Integer) getSession(Const.SESSION_ADMIN_AGENTID);
		tn = agentlogService.getTotalCount(
				new QueryParam(1).add("agentid", agentid), false);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

}
