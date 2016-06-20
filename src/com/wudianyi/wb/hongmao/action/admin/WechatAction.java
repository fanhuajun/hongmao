package com.wudianyi.wb.hongmao.action.admin;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.ShopService;

public class WechatAction extends BaseAction {

	@Resource
	private ShopService shopService;

	public String edit() {
		Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
		Shop shop = shopService.get(shopid);
		setAttribute("shop", shop);
		return "edit";
	}
}
