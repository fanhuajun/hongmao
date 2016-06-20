package com.wudianyi.wb.hongmao.action.agent.json;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.AgentService;
import com.wudianyi.wb.hongmao.util.StringUtils;

public class AgentAction extends BaseAction {

	@Resource
	private AgentService agentService;
	private String level;

	public String list() {
		if (StringUtils.isEmpty(level)) {
			level = "one";
		}
		Integer agentid = (Integer) getSession(Const.SESSION_ADMIN_AGENTID);

		list = agentService.getList(new QueryParam(1).add(level, agentid), pn
				- 1 * (Const.BACK_PAGE_SIZE), Const.BACK_PAGE_SIZE,
				"createdate", "desc", false);
		return LIST;
	}

	public String totalNum() {
		if (StringUtils.isEmpty(level)) {
			level = "one";
		}
		Integer agentid = (Integer) getSession(Const.SESSION_ADMIN_AGENTID);
		tn = agentService.getTotalCount(
				new QueryParam(1).add(level, agentid), false);
		System.out.println("tn========" + tn);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
