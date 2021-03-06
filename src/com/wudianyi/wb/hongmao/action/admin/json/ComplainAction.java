package com.wudianyi.wb.hongmao.action.admin.json;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.ComplainService;

public class ComplainAction extends BaseAction {
	@Resource
	private ComplainService complainService ;
	private String stat;
	
	public String jsonlist() {
		
		    QueryParam param = null;
		    Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
			param = new QueryParam(2).add("shopid", shopid);
		

		list = complainService.getList(param, Const.BACK_PAGE_SIZE * (pn - 1),
				Const.BACK_PAGE_SIZE, null, "desc", false);
		return "jsonlist";
	}
	
	public String totalNum() {
		
		QueryParam param = null;
		
			Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
			param = new QueryParam(2).add("shopid", shopid);
		
		int tn = complainService.getTotalCount(param, false);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

}
