package com.wudianyi.wb.hongmao.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
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
import com.wudianyi.wb.hongmao.service.WeixinService;
import com.wudianyi.wb.hongmao.util.NumberUtil;
import com.wudianyi.wb.hongmao.util.StringUtils;
import com.wudianyi.wb.hongmao.vo.PrepayVo;

@ParentPackage("user")
public class OrderAction extends BaseAction {

	private String id;
	private String consumeJson;
	private Double sourcemoney;// 原价
	private Double money;// 实付
	private Double shopmoney;// 从商户预存中消耗的金额
	private Double webmoney;// 从平台预存中消耗的金额
	private Double discount;// 优惠
	private String shopName;
	private double dicountmoney;
	private double paymoney;
	private String note;

	@Resource
	private OrderService orderService;
	@Resource
	private ShopService shopService;
	@Resource
	private UserService userService;
	@Resource
	private ShopvipService shopvipService;
	@Resource
	private WeixinService weixinService;
	@Resource
	private PrepaylogService prepaylogService;

	public String prePay() {
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);

		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);

		System.err.println("userid---" + userid);
		User user = userService.get(userid);
		setAttribute("user", user);

		Shopvip shopvip = shopvipService.saveOrget(userid, shopid);
		if (shopvip != null) {
			setAttribute("shopvip", shopvip);
			String prepayjson = shopvip.getPrepayjson();
			if (!StringUtils.isEmpty(prepayjson)) {
				JSONArray ary = JSONArray.fromObject(prepayjson);
				list = JSONArray.toList(ary, PrepayVo.class);
			}

		}

		return "prePay";
	}

	public String create() throws Exception {
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		User user1 = userService.get(userid);
		double lastmoney = dicountmoney;
		double shoptotalmoney = 0.00;
		JSONArray paymoneyjson = new JSONArray();
		// 用来记录改变价格后的钱包内容
		JSONArray afterWallet = new JSONArray();
		// 先看看余额里面是否够钱
		Shopvip shopvip = shopvipService.saveOrget(userid, shopid);

		if (!StringUtils.isEmpty(shopvip.getPrepayjson())) {
			List<PrepayVo> array = JSONArray.toList(
					JSONArray.fromObject(shopvip.getPrepayjson()),
					PrepayVo.class);
			// 对list进行排序
			Collections.sort(array, new Comparator<PrepayVo>() {
				public int compare(PrepayVo arg0, PrepayVo arg1) {
					return arg0.getDiscount().compareTo(arg1.getDiscount());
				}
			});
			boolean isenough = false;
			for (PrepayVo prepayVo : array) {
				double indexpaymoney = 0.00;
				if (isenough) {
					afterWallet.add(prepayVo);
					continue;
				}

				// 如果够支付了，就不用往下跑了
				if (prepayVo.getMoney() / prepayVo.getDiscount() > lastmoney) {
					indexpaymoney = lastmoney * prepayVo.getDiscount();
					lastmoney = 0;

					// 保存之后的钱包内容
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("discount", prepayVo.getDiscount());
					jsonObject.put("createdate", prepayVo.getCreatedate());
					jsonObject.put("money", prepayVo.getMoney() - indexpaymoney);
					jsonObject.put("id", prepayVo.getId());
					afterWallet.add(jsonObject);

					isenough = true;
				} else {
					indexpaymoney = prepayVo.getMoney();
					lastmoney = lastmoney - prepayVo.getMoney()
							/ prepayVo.getDiscount();
				}

				shoptotalmoney += indexpaymoney;
				// 保存支付json
				PrepayVo vo = new PrepayVo();
				vo.setCreatedate(prepayVo.getCreatedate());
				vo.setDiscount(prepayVo.getDiscount());
				vo.setId(prepayVo.getId());
				vo.setMoney(indexpaymoney);
				paymoneyjson.add(JSONObject.fromObject(vo));

			}
		}
		shoptotalmoney = shoptotalmoney + (shopvip.getBackmoney() - lastmoney) < 0 ? shopvip.getBackmoney():lastmoney;
//		System.out.println("shoptotalmoney...........:"+shoptotalmoney); 
//		System.out.println("lastmoney...........:"+lastmoney); 
		
		double backmoney = (shopvip.getBackmoney() - lastmoney) < 0 ? 0:shopvip.getBackmoney() - lastmoney;
		lastmoney = lastmoney - shopvip.getBackmoney() < 0 ? 0:lastmoney - shopvip.getBackmoney();
		// 保存用户钱包
		shopvip.setBackmoney(backmoney);
		shopvip.setPrepayjson(afterWallet.toString());
		shopvip.setMoney(shopvip.getMoney() - shoptotalmoney);
		shopvip.setShopMoney((shopvip.getShopMoney()-(dicountmoney - lastmoney))<0?0:shopvip.getShopMoney()-(dicountmoney - lastmoney));
		shopvipService.update(shopvip);

		Shop shop = shopService.get(shopid);
		Order order = new Order();
		order.setConsumeJson(paymoneyjson.toString());
		order.setId(NumberUtil.creatUUID());
		order.setOrdersn(NumberUtil.creatSn(userid + ""));
		order.setMoney(lastmoney + paymoney);
		order.setShopmoney(shopmoney);
		order.setAllpaymoney(shoptotalmoney+dicountmoney + paymoney);
		order.setSourcemoney(dicountmoney + paymoney);
		order.setUserid(userid);
		order.setShopid(shopid);
		order.setShopname(shop.getName());
		order.setShopstar(shop.getPoint());
		order.setUsername(user1.getName());
		order.setPhone(user1.getPhone());
		order.setNote(note);
		// 分配佣金，总的消费金额为店预付款支付金额+微信支付的金额
		double allmoney = shoptotalmoney + lastmoney + paymoney;
		Shopvip oneShopvip=null,twoShopvip=null,threeShopvip=null;
		User user = userService.get(userid);
		if (user.getOne() != null) {
			oneShopvip = shopvipService.saveOrget(user.getOne(), shopid);
			order.setOneuserid(user.getOne());
			order.setOnerank(oneShopvip.getRank() == null ? shop.getTotaluser()
					: oneShopvip.getRank());
			// 查看排名，如果是最后一名，则直接奖励最低的那个返佣，如果第一名，奖励最高的
			double backrate = 0.00;
			if (oneShopvip.getRank() == null) {
				backrate = shop.getLowestback1();
			} else {
				backrate = shop.getLowestback1()
						+ (shop.getHighestback1() - shop.getLowestback1())
						/ (shop.getTotaluser() - oneShopvip.getRank());
			}
			order.setOnebackmoney(backrate * allmoney);

		}

		if (user.getTwo() != null) {
			twoShopvip = shopvipService.saveOrget(user.getTwo(), shopid);
			order.setTwouserid(user.getTwo());
			order.setTworank(twoShopvip.getRank() == null ? shop.getTotaluser()
					: twoShopvip.getRank());
			// 查看排名，如果是最后一名，则直接奖励最低的那个返佣，如果第一名，奖励最高的
			double backrate = 0.00;
			if (twoShopvip.getRank() == null) {
				backrate = shop.getLowestback2();
			} else {
				backrate = shop.getLowestback2()
						+ (shop.getHighestback2() - shop.getLowestback2())
						/ (shop.getTotaluser() - twoShopvip.getRank());
			}
			order.setTwobackmoney(backrate * allmoney);
		}
		
		
		if (user.getThree() != null) {
			threeShopvip = shopvipService.saveOrget(user.getThree(), shopid);
			order.setThreeuserid(user.getThree());
			order.setThreerank(threeShopvip.getRank() == null ? shop.getTotaluser()
					: threeShopvip.getRank());
			// 查看排名，如果是最后一名，则直接奖励最低的那个返佣，如果第一名，奖励最高的
			double backrate = 0.00;
			if (threeShopvip.getRank() == null) {
				backrate = shop.getLowestback3();
			} else {
				backrate = shop.getLowestback3()
						+ (shop.getHighestback3() - shop.getLowestback3())
						/ (shop.getTotaluser() - threeShopvip.getRank());
			}
			order.setThreebackmoney(backrate * allmoney);
		}

		Prepaylog log = new Prepaylog();
		log.setCreatedate(new Date().getTime());
		log.setIsin(0);
		log.setUserid(userid);
		log.setShopid(shopid);
		log.setMoney(shoptotalmoney);
		log.setTt(-1);
		prepaylogService.save(log);
		
        //重新计算用户的排名
		List<Order> orderList = orderService.getList(new QueryParam().
				     add("userid", userid).add("shopid", shopid), 0, 0, null, null, false);  
		double conMoney = 0.00;
		for(Order ordern : orderList){
			conMoney += ordern.getSourcemoney();
		}
		shopvip.setConMoney(conMoney); 
		shopvipService.update(shopvip);
		List<Shopvip> shopvipList = shopvipService.getList(new QueryParam().
				     add("shopid", shopid), 0, 0, "conMoney", "desc", false);
		int i = 0,rank = 0,j = 0; boolean bool = false;
		j = shopvip.getRank();
		for(Shopvip shopvip2 : shopvipList){
			System.out.println("userid:........."+shopvip2.getUserid()+"--"+shopvip.getConMoney()); 
			i++;
			if(shopvip2.getUserid().equals(userid)){
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
		
		// 如果待付款大于0，则跳转支付页面，否则完成支付逻辑跳转支付成功页面
		if (lastmoney + paymoney > 0) {
			order.setStat(0);
			
			String orderid = orderService.save(order);
			setAttribute("orderid", orderid);
			String ticket = weixinService.getTicket(shop.getAppid(),
					shop.getAppKey());
			setAttribute("ticket", ticket);
			setAttribute("appId", shop.getAppid());
			setAttribute("shopName", shop.getName());
			setAttribute("money", lastmoney + paymoney);
//			orderService.save(order);
			return "pay";
		}
		order.setPaydate(new Date().getTime());
		order.setStat(1);
		
		orderService.save(order);
		//进行返佣
		if(oneShopvip!=null){
			
			oneShopvip.setBackmoney(oneShopvip.getBackmoney()+order.getOnebackmoney());
			//oneShopvip.setWdmoney(oneShopvip.getWdmoney()+order.getOnebackmoney());
			shopvipService.update(oneShopvip);
			
			Prepaylog prepaylog = new Prepaylog();
			prepaylog.setUserid(oneShopvip.getUserid());
			prepaylog.setIsin(1);
			prepaylog.setMoney(order.getOnebackmoney());
			prepaylog.setTt(1);
			prepaylog.setRestmoney(order.getAllpaymoney());
			prepaylog.setAttach("1");
			prepaylog.setCreatedate(new Date().getTime());
			prepaylog.setShopid(shopid);
			prepaylog.setLinkid(order.getId());
			prepaylogService.save(prepaylog);
			
		}
		
		if(twoShopvip!=null){
			twoShopvip.setBackmoney(twoShopvip.getBackmoney()+order.getTwobackmoney());
			//twoShopvip.setWdmoney(twoShopvip.getWdmoney()+order.getTwobackmoney());
			shopvipService.update(twoShopvip);
			Prepaylog prepaylog = new Prepaylog();
			prepaylog.setUserid(twoShopvip.getUserid());
			prepaylog.setIsin(1);
			prepaylog.setMoney(order.getTwobackmoney());
			prepaylog.setTt(1);
			prepaylog.setRestmoney(order.getAllpaymoney());
			prepaylog.setAttach("2");
			prepaylog.setCreatedate(new Date().getTime());
			prepaylog.setShopid(shopid);
			prepaylog.setLinkid(order.getId());
			prepaylogService.save(prepaylog);
		}
		
		if(threeShopvip!=null){
			threeShopvip.setBackmoney(threeShopvip.getBackmoney()+order.getThreebackmoney());
			//threeShopvip.setWdmoney(threeShopvip.getWdmoney()+order.getThreebackmoney());
			shopvipService.update(threeShopvip);
			Prepaylog prepaylog = new Prepaylog();
			prepaylog.setUserid(threeShopvip.getUserid());
			prepaylog.setIsin(1);
			prepaylog.setMoney(order.getThreebackmoney());
			prepaylog.setTt(1);
			prepaylog.setRestmoney(order.getAllpaymoney());
			prepaylog.setAttach("3");
			prepaylog.setCreatedate(new Date().getTime());
			prepaylog.setShopid(shopid);
			prepaylog.setLinkid(order.getId());
			prepaylogService.save(prepaylog);
		}
		
		getResponse().sendRedirect("pay!ok.action?orderid=" + order.getId());
		return null;

	}

	public String list() {
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		QueryParam param = new QueryParam(2);
		param.add("userid", userid).add(">=stat", 1);// 该用户已支付的
		list = orderService.getList(param, Const.FRONT_PAGE_SIZE * (pn - 1),
				Const.FRONT_PAGE_SIZE, "paydate", "desc", false);
		return LIST;
	}

	/*
	 * 进入评价页面
	 */
	public String comment() {
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		Order order = orderService.get(id);
		if (order.getUserid() == userid.intValue() && order.getStat() == 1) {
			setAttribute("order", order);
		} else {
			return "nopage";
		}

		Shop shop = shopService.get(order.getShopid());
		setAttribute("shop", shop);

		return "comment";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConsumeJson() {
		return consumeJson;
	}

	public void setConsumeJson(String consumeJson) {
		this.consumeJson = consumeJson;
	}

	public Double getSourcemoney() {
		return sourcemoney;
	}

	public void setSourcemoney(Double sourcemoney) {
		this.sourcemoney = sourcemoney;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getShopmoney() {
		return shopmoney;
	}

	public void setShopmoney(Double shopmoney) {
		this.shopmoney = shopmoney;
	}

	public Double getWebmoney() {
		return webmoney;
	}

	public void setWebmoney(Double webmoney) {
		this.webmoney = webmoney;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public double getDicountmoney() {
		return dicountmoney;
	}

	public void setDicountmoney(double dicountmoney) {
		this.dicountmoney = dicountmoney;
	}

	public double getPaymoney() {
		return paymoney;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setPaymoney(double paymoney) {
		this.paymoney = paymoney;
	}

}
