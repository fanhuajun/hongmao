package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.service.WeixinService;

public class RechargeAction extends BaseAction {

	private Double money;
	@Resource
	private ShopService shopService;
	@Resource
	private WeixinService weixinService;

	public String execute() {
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		if (shopid != null && shopid != 0) {
			Shop shop = shopService.get(shopid);
			setAttribute("shop", shop);
		}

		return "recharge";
	}

	public String pay() throws Exception {
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		Shop shop = shopService.get(shopid);
		String ticket = weixinService.getTicket(shop.getAppid(),
				shop.getAppKey());
		setAttribute("ticket", ticket);
		setAttribute("appId", shop.getAppid());
		setAttribute("shopid", shop.getId());
		setAttribute("shopName", shop.getName());

		return "pay";
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
