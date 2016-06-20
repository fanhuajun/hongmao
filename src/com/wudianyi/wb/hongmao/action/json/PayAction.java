package com.wudianyi.wb.hongmao.action.json;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.common.WxPayReqData;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Order;
import com.wudianyi.wb.hongmao.entity.Prepaylog;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.OrderService;
import com.wudianyi.wb.hongmao.service.PrepaylogService;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.util.WxPayUtil;
import com.wudianyi.wb.hongmao.util.WxSignature;

public class PayAction extends BaseAction {

	private String orderid;

	private Integer rechargeid;// 0或空为平台充值 否则为对应shopid的商家充值
	private Double money;

	@Resource
	private OrderService orderService;
	@Resource
	private ShopService shopService;
	@Resource
	private PrepaylogService prepaylogService;

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public String execute() throws Exception {
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		Object weixinidObj = getSession(Const.SESSION_WEIXINID);
		if (weixinidObj == null) {
			return ajaxJsonErrorMessage("缺少weixinid");
		}
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 30);
		JSONObject retjson = new JSONObject();
		Order order = orderService.get(orderid);
		Shop shop = shopService.get(order.getShopid());
		// 微信预订单
		String preid = WxPayUtil.unifiedorder(new WxPayReqData(shop.getAppid(),
				shop.getWxPayno(), "shop", "attach", order.getOrdersn(),
				(int) (order.getMoney() * 100), "112.74.23.48", sdf
						.format(new Date()), sdf.format(calendar.getTime()),
				"http://" + shopid + ".homao.me/json/paynotify!wxPay.action",
				weixinidObj == null ? null : weixinidObj.toString(), shop
						.getWxPaySecrect(), "JSAPI"));// JSAPI
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appId", shop.getAppid());
		map.put("nonceStr", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
		map.put("package", "prepay_id=" + preid);
		map.put("signType", "MD5");
		map.put("timeStamp", "1");
		String paySign = WxSignature.getSign(map, shop.getWxPaySecrect());
		retjson.put("ok", 0);
		retjson.put("success", true);
		retjson.put("preid", preid);
		retjson.put("paySign", paySign);
		retjson.put("oid", order.getId());
		retjson.put("sn", order.getOrdersn());
		return ajaxJson(retjson.toString());
	}

	public String recharge() throws Exception {
		Object weixinidObj = getSession(Const.SESSION_WEIXINID);
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		if (weixinidObj == null) {
			return ajaxJsonErrorMessage("缺少weixinid");
		}
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 30);
		JSONObject retjson = new JSONObject();
		String appid = "";
		String wxPayNo = "";
		String wxPaySecrect = "";
		String sn = "";
		String callBackUrl = "http://" + shopid
				+ ".homao.me/json/paynotify!wxRecharge.action";
		Prepaylog prepay = new Prepaylog();
		// QueryParam params = new QueryParam().add("shopid", rechargeid).add(
		// "tt", 0);
		// List<Prepaylog> indexList = prepaylogService.getList(params, 0, 1,
		// "displayOrder", "desc", false);
		// if (indexList.size() > 0) {
		// prepay.setDisplayOrder(indexList.get(0).getDisplayOrder() + 1000);
		// } else {
		// prepay.setDisplayOrder(1000);
		// }
		Shop shop = shopService.get(shopid);
		appid = shop.getAppid();
		wxPayNo = shop.getWxPayno();
		wxPaySecrect = shop.getWxPaySecrect();
		prepay.setShopid(shopid);
		prepay.setDiscount(shop.getDiscount() == null ? 1 : shop.getDiscount());
		prepay.setRestmoney(money);
		prepay.setCreatedate(new Date().getTime());
		prepay.setIsin(1);
		prepay.setMoney(money);
		prepay.setTt(-2);
		prepay.setUserid(userid);
		String prepayid = prepaylogService.save(prepay);
		// 微信预订单
		// (int) (money * 100)
		String preid = WxPayUtil.unifiedorder(new WxPayReqData(appid, wxPayNo,
				"shop", "attach", prepayid,(int) (prepay.getMoney() * 100), "116.25.93.127", sdf
						.format(new Date()), sdf.format(calendar.getTime()),
				callBackUrl, weixinidObj == null ? null : weixinidObj
						.toString(), wxPaySecrect, "JSAPI"));// JSAPI
		System.out.println("preid=============>" + preid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appId", appid);
		map.put("nonceStr", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
		map.put("package", "prepay_id=" + preid);
		map.put("signType", "MD5");
		map.put("timeStamp", "1");
		String paySign = WxSignature.getSign(map, wxPaySecrect);
		retjson.put("ok", 0);
		retjson.put("success", true);
		retjson.put("preid", preid);
		retjson.put("paySign", paySign);
		retjson.put("sn", prepayid);
		return ajaxJson(retjson.toString());
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Integer getRechargeid() {
		return rechargeid;
	}

	public void setRechargeid(Integer rechargeid) {
		this.rechargeid = rechargeid;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
