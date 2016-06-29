package com.wudianyi.wb.hongmao.action.admin.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.unionpay.acp.sdk.SDKConstants;
import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Agent;
import com.wudianyi.wb.hongmao.entity.Rechargelog;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.AgentService;
import com.wudianyi.wb.hongmao.service.RechargelogService;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.util.WxPayUtil;

public class PayAction extends BaseAction {

	@Resource
	private RechargelogService rechargelogService;
	@Resource
	private ShopService shopService;
	@Resource
	private AgentService agentService;

	public String wxscannotify() throws Exception {
		String reqXml = "";
		Map<String, String> reqParam = new HashMap<String, String>();
		String encoding = getRequest()
				.getParameter(SDKConstants.param_encoding);
		try {
			InputStream inputStream = getRequest().getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			// 获取请求参数中所有的信息
			String tempStr = "";
			while ((tempStr = reader.readLine()) != null) {
				reqXml += tempStr;
			}
			reader.close();
			inputStream.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Map valideData = WxPayUtil.doXMLParse(reqXml);
		System.err.println("out_trade_no=" + valideData.get("out_trade_no"));
		String orderid = (String) valideData.get("out_trade_no");
		System.err.println("orderid===" + orderid);

		Rechargelog rechargelog = rechargelogService.get(
				new QueryParam(1).add("ordersn", orderid), false);
		System.err.println("rechargelog==" + rechargelog);
		System.err.println("rechargelog.getStat()==" + rechargelog.getStat());
		if (rechargelog != null && rechargelog.getStat() == 0) {
			rechargelog.setStat(1);
			rechargelog.setPaydate(new Date().getTime());
			rechargelogService.update(rechargelog);
			if (rechargelog.getTt() == 0) {
				Shop shop = shopService.get(rechargelog.getShopid());

				shop.setMoney(shop.getMoney() + rechargelog.getMoney());
				shopService.update(shop);
			} else {
				Agent agent = agentService.get(rechargelog.getShopid());
				agent.setMoney(agent.getMoney() + rechargelog.getMoney());
				agentService.update(agent);
			}

			getResponse()
					.getWriter()
					.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
			return null;
		}
		System.err.println("BackRcvResponse接收后台通知结束");

		return null;
	}
}
