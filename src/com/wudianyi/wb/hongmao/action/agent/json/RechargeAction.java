package com.wudianyi.wb.hongmao.action.agent.json;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.WxScanPayReqData;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Rechargelog;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.RechargelogService;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.util.NumberUtil;
import com.wudianyi.wb.hongmao.util.WxPayUtil;

public class RechargeAction extends BaseAction {

	@Resource
	private ShopService shopService;
	@Resource
	private RechargelogService rechargelogService;
	private String id;
	private Double money;
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public String checkpay() {
		int ret = 0;
		Rechargelog rechargelog = rechargelogService.get(id);
		if (rechargelog != null) {
			if (rechargelog.getStat() == 1) {
				ret = 1;
			}

		} else {
			ret = -1;
		}
		return ajaxHtml(ret + "");
	}

	public String prepay() throws Exception {
		Integer agentid = (Integer) getSession(Const.SESSION_ADMIN_AGENTID);
		String ordersn = NumberUtil.creatSn(agentid + "");
		Rechargelog rechargelog = new Rechargelog();
		rechargelog.setCreatedate(new Date().getTime());
		rechargelog.setMoney(money);
		rechargelog.setTt(1);
		rechargelog.setOrdersn(ordersn);
		rechargelog.setShopid(agentid);
		rechargelog.setStat(0);
		rechargelogService.save(rechargelog);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 30);
		String ret = WxPayUtil.sendPost(
				"https://api.mch.weixin.qq.com/pay/unifiedorder",
				new WxScanPayReqData(Const.APPID, null, "homao pay",
						Const.WX_PAY_NO, "http://www." + Const.BASE_URL
								+ "/agent/json/pay!wxscannotify.action",
						ordersn, rechargelog.getId(), "192.189.2.3",
						1, Const.WX_PAY_SECRECT));
		Map m = WxPayUtil.doXMLParse(ret);
		if (m.get("code_url") != null) {
			return ajaxJson("{\"success\":true,\"url\":\"" + m.get("code_url")
					+ "\",\"rid\":\"" + rechargelog.getId() + "\"}");
		}

		return ajaxJson("{\"success\":false}");
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
