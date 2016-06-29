package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Rechargelog;
import com.wudianyi.wb.hongmao.service.RechargelogService;
import com.wudianyi.wb.hongmao.service.ShopService;

public class TestAction extends BaseAction {

	@Resource
	private ShopService shopService;
	
	@Resource
	private RechargelogService rechargelogService;

	@Override
	public String execute() throws Exception {
		String orderid = "146260530181";
		Rechargelog rechargelog = rechargelogService.get(new QueryParam(1).add("ordersn", orderid), false);
		System.err.println(rechargelog.getStat());
		return null;
	}

}
