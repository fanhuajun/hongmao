package com.wudianyi.wb.hongmao.action.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Order;
import com.wudianyi.wb.hongmao.entity.Prepaylog;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.entity.Shopvip;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.OrderService;
import com.wudianyi.wb.hongmao.service.PrepaylogService;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.service.ShopvipService;
import com.wudianyi.wb.hongmao.service.UserService;
import com.wudianyi.wb.hongmao.util.StringUtils;
import com.wudianyi.wb.hongmao.util.WxPayUtil;
import com.wudianyi.wb.hongmao.vo.PrepayVo;

public class PaynotifyAction extends BaseAction {

	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;
	@Resource
	private PrepaylogService prepaylogService;
	@Resource
	private ShopvipService shopvipService;
	@Resource
	private ShopService shopService;

	public String wxPay() throws Exception {
		System.out.println("微信订单支付回调。。。。");
		String reqXml = "";
		Map<String, String> reqParam = new HashMap<String, String>();
		String encoding = getRequest().getParameter("utf-8");
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

		String orderid = (String) valideData.get("out_trade_no");
		Order order = orderService.get(
				new QueryParam(1).add("ordersn", orderid), false);
		order.setPaydate(new Date().getTime());
		order.setStat(1);
		orderService.update(order);
		if (order.getOneuserid() != null) {
			User oneUser = userService.get(order.getOneuserid());
			oneUser.setBackmoney(oneUser.getBackmoney()
					+ order.getOnebackmoney());
			oneUser.setWdmoney(oneUser.getWdmoney() + order.getOnebackmoney());
			userService.update(oneUser);

			Prepaylog prepaylog = new Prepaylog();
			prepaylog.setUserid(oneUser.getId());
			prepaylog.setIsin(1);
			prepaylog.setMoney(order.getOnebackmoney());
			prepaylog.setTt(1);
			prepaylog.setAttach("1");
			prepaylog.setRestmoney(order.getAllpaymoney());
			prepaylog.setCreatedate(new Date().getTime());
			prepaylog.setShopid(order.getShopid());
			prepaylog.setLinkid(order.getId());
			prepaylogService.save(prepaylog);

		}

		if (order.getTwouserid() != null) {
			User twoUser = userService.get(order.getTwouserid());
			twoUser.setBackmoney(twoUser.getBackmoney()
					+ order.getTwobackmoney());
			twoUser.setWdmoney(twoUser.getWdmoney() + order.getTwobackmoney());
			userService.update(twoUser);
			Prepaylog prepaylog = new Prepaylog();
			prepaylog.setUserid(twoUser.getId());
			prepaylog.setIsin(1);
			prepaylog.setMoney(order.getTwobackmoney());
			prepaylog.setTt(1);
			prepaylog.setRestmoney(order.getAllpaymoney());
			prepaylog.setAttach("2");
			prepaylog.setCreatedate(new Date().getTime());
			prepaylog.setShopid(order.getShopid());
			prepaylog.setLinkid(order.getId());
			prepaylogService.save(prepaylog);
		}

		if (order.getThreeuserid() != null) {
			User threeUser = userService.get(order.getThreeuserid());
			threeUser.setBackmoney(threeUser.getBackmoney()
					+ order.getThreebackmoney());
			threeUser.setWdmoney(threeUser.getWdmoney()
					+ order.getThreebackmoney());
			userService.update(threeUser);
			Prepaylog prepaylog = new Prepaylog();
			prepaylog.setUserid(threeUser.getId());
			prepaylog.setIsin(1);
			prepaylog.setMoney(order.getThreebackmoney());
			prepaylog.setTt(1);
			prepaylog.setRestmoney(order.getAllpaymoney());
			prepaylog.setAttach("3");
			prepaylog.setCreatedate(new Date().getTime());
			prepaylog.setShopid(order.getShopid());
			prepaylog.setLinkid(order.getId());
			prepaylogService.save(prepaylog);
		}

		// String consumeJson = order.getConsumeJson();

		getResponse()
				.getWriter()
				.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
		return null;
	}

	public String wxRecharge() throws Exception {
		System.out.println("微信充值回调啦。。。。。。");
		String reqXml = "";
		Map<String, String> reqParam = new HashMap<String, String>();
		String encoding = getRequest().getParameter("utf-8");
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

		String prepayid = (String) valideData.get("out_trade_no");
		Prepaylog prepay = prepaylogService.get(prepayid);
		prepay.setTt(0);
		prepaylogService.update(prepay);
		// 如果是平台充值，则更新用户的平台总余额
		if (prepay.getShopid() == null || prepay.getShopid() == 0) {
			User user = userService.get(prepay.getUserid());
			user.setMoney(user.getMoney() + prepay.getMoney());
			userService.update(user);
			// 否则更新可用的商家余额信息
		} else {

//			QueryParam params = new QueryParam(4)
//					.add("userid", prepay.getUserid())
//					.add("shopid", prepay.getShopid()).add("restmoney>", 0.0)
//					.add("tt", 0);
//			List<Prepaylog> prepayList = prepaylogService.getList(params, 0, 0,
//					"discount", "asc", false);
			// params = new QueryParam(4).add("userid", prepay.getUserid())
			// .add("shopid", prepay.getShopid()).add("restmoney>",
			// 0.0).add("discount", 0.0);
			// List<Prepaylog> noDiscountList = prepaylogService.getList(params,
			// 0, 0, "createdate", "asc", false);
			// prepayList.addAll(noDiscountList);
			
			QueryParam param = new QueryParam()
						.add("userid", prepay.getUserid())
						.add("shopid", prepay.getShopid());
			String prepayjson = shopvipService.get(param, false).getPrepayjson();
			List<PrepayVo> prepayList = JSONArray.toList(JSONArray
					.fromObject(prepayjson),PrepayVo.class);
			PrepayVo prepayVot = new PrepayVo();
			prepayVot.setMoney(prepay.getRestmoney());
			prepayVot.setId(prepay.getId());
			prepayVot.setCreatedate(prepay.getCreatedate());
			prepayVot.setDiscount(prepay.getDiscount());
			prepayList.add(prepayVot);
			
			
            //将更新后的prepayList保存到shopvip.Prepayjson中
			if (prepayList.size() > 0) {

				JSONArray jsonAry = new JSONArray();
				double total = 0;
				double shopMoney = 0;
				for (PrepayVo prepayVo : prepayList) {
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("id", prepayVo.getId());
					jsonObj.put("createdate", prepayVo.getCreatedate());
					jsonObj.put("money", prepayVo.getMoney());
					jsonObj.put("discount", prepayVo.getDiscount());
					jsonAry.add(jsonObj);
					total += prepayVo.getMoney();
					shopMoney += prepayVo.getMoney()/prepayVo.getDiscount();
				}
				Shopvip shopvip = shopvipService.get(prepay.getUserid() + "z"
						+ prepay.getShopid());
				if (shopvip == null) {
					Shop shop = shopService.get(prepay.getShopid());
					shopvip = new Shopvip();
					shopvip.setId(prepay.getUserid() + "z" + prepay.getShopid());
					shopvip.setUserid(prepay.getUserid());
					shopvip.setPrepayjson(jsonAry.toString());
					shopvip.setMoney(total); 
					shopvip.setShopMoney(shopMoney);
					shopvip.setCreatedate(new Date().getTime());
					shopvip.setShopid(prepay.getShopid());
					shopvipService.save(shopvip);
				} else {
					shopvip.setPrepayjson(jsonAry.toString());
					shopvip.setMoney(total);
					shopvip.setShopMoney(shopMoney);
					shopvipService.update(shopvip);
				}
			}
		}
		
		 //重新计算用户的排名
		Shopvip shopvip = shopvipService.saveOrget(prepay.getUserid(), prepay.getShopid());
		List<Order> orderList = orderService.getList(new QueryParam().
				     add("userid", prepay.getUserid()).add("shopid", prepay.getShopid()), 0, 0, null, null, false);  
		double conMoney = 0.00;
		for(Order ordern : orderList){
			conMoney += ordern.getSourcemoney();
		}
		shopvip.setConMoney(conMoney); 
		shopvipService.update(shopvip);
		List<Shopvip> shopvipList = shopvipService.getList(new QueryParam().
				     add("shopid", prepay.getShopid()), 0, 0, "conMoney", "desc", false);
		int i = 0,rank = 0,j = 0;
		j = shopvip.getRank(); boolean bool = false;
		for(Shopvip shopvip2 : shopvipList){
			System.out.println("userid:........."+shopvip2.getUserid()+"--"+shopvip.getConMoney()); 
			i++;
			if(shopvip2.getUserid().equals(prepay.getUserid())){
				rank = i; bool = true;
			}
			if(i>=j){break;}
			if(bool && (i < j || i<shopvipList.size())){
				if(shopvip2.getRank()>99999998){
					continue;
				}	
				shopvip2.setRank(shopvip2.getRank()+1);
				shopvipService.update(shopvip2); 
			}
		}
		shopvip.setRank(rank); 
		shopvipService.update(shopvip);
		getResponse()
				.getWriter()
				.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");

		return null;
	}

	/**
	 * 获取请求参数中所有的信息
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getAllRequestParam(
			final HttpServletRequest request) {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				// 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				// System.out.println("ServletUtil类247行  temp数据的键=="+en+"     值==="+value);
				if (null == res.get(en) || "".equals(res.get(en))) {
					res.remove(en);
				}
			}
		}
		return res;
	}
}
