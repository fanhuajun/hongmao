package com.wudianyi.wb.hongmao.action.admin.json;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.ShopService;

public class WechatAction extends BaseAction {
	@Resource
	private ShopService shopService;
	private String appid;
	private String wxPayno;
	private String wxPaySecrect;
	private String appKey;

	public String edit() {
		Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
		Shop shop = shopService.get(shopid);
		shop.setAppid(appid);
		shop.setAppKey(appKey);
		shop.setWxPayno(wxPayno);
		shop.setWxPaySecrect(wxPaySecrect);
		shopService.update(shop);
		return ajaxJson("{\"success\":true}");
	}

}
