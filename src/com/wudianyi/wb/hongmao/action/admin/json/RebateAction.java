package com.wudianyi.wb.hongmao.action.admin.json;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.DepositService;
import com.wudianyi.wb.hongmao.service.OrderService;
import com.wudianyi.wb.hongmao.service.PrepaylogService;

public class RebateAction extends BaseAction {
	private String stat;
	@Resource
	private OrderService orderService;
	
	public String list(){
     	Integer shopid = (Integer)getSession(Const.SESSION_ADMIN_SHOPID);
    	System.out.println("shopid===" + shopid);
    	System.out.println("stat===" + stat);

		QueryParam params = new QueryParam().add("shopid", shopid);
		
		list = orderService.getList(params, (pn-1)*Const.BACK_PAGE_SIZE, Const.BACK_PAGE_SIZE, "paydate", "desc", false);
		return LIST;
	}
    
    public String totalNum() {
    	Integer shopid = (Integer)getSession(Const.SESSION_ADMIN_SHOPID);
    	QueryParam params = new QueryParam().add("shopid", shopid);
		
    	tn = orderService.getTotalCount(params, false);
		
					System.out.println("tn========" + tn);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\"" + Const.BACK_PAGE_SIZE + "\"}");
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	
}
