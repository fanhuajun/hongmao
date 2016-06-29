package com.wudianyi.wb.hongmao.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Deposit;
import com.wudianyi.wb.hongmao.entity.Prepaylog;
import com.wudianyi.wb.hongmao.entity.Shopvip;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.DepositService;
import com.wudianyi.wb.hongmao.service.PrepaylogService;
import com.wudianyi.wb.hongmao.service.ShopvipService;
import com.wudianyi.wb.hongmao.service.UserService;

public class DepositAction extends BaseAction {

	private String deposittype;// 提现方式：weixin:微信提现，card：银行卡提现
	private String name;// 用户名字
	private String wxname;
	private String card;// 银行卡账号
	private String phone;// 用户电话
	private String bankName;
	@Resource
	private ShopvipService shopvipService;
	@Resource
	private UserService userService;
	@Resource
	private DepositService depositService;
	@Resource
	private PrepaylogService prepaylogService;

	public String execute() {

		double limit = 0.0;
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		Shopvip shopvip = shopvipService.saveOrget(userid, shopid);
		User user = userService.get(userid);
		String encryptPhone = user.getPhone().replace(
				user.getPhone().subSequence(3, 7), "****");

		limit = shopvip.getBackmoney();
		setAttribute("limit", limit);
		setAttribute("phone", user.getPhone());
		setAttribute("encryptPhone", encryptPhone);
		return "deposit";
	}

	public String apply() throws Exception {

		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		User user = userService.get(userid);
		long now = new Date().getTime();
		if (user.getBackmoney() > 0) {
			long begin = user.getCreatedate();
			long end=now;
			if(user.getLastdeposittime()!=null){
				begin = user.getLastdeposittime();
			}
			double money = user.getBackmoney();
			user.setBackmoney(0.00);
			user.setLastdeposittime(now);
			userService.update(user);
			Deposit deposit = new Deposit();
			deposit.setBegintime(begin);
			deposit.setEndtime(end);
			deposit.setBankName(bankName);
			deposit.setCard(card);
			deposit.setMoney(money);
			deposit.setCreatedate(new Date().getTime());
			deposit.setDeposittype(deposittype);
			deposit.setName(name);
			deposit.setPhone(phone);
			deposit.setShopid(shopid);
			deposit.setWxname(wxname);
			deposit.setTt(0);
			deposit.setUserid(userid);
			depositService.save(deposit);
		}

		// Prepaylog prepay = new Prepaylog();
		// if (deposit.getShopid() == 0) {
		// User user = userService.get(deposit.getUserid());
		// user.setMoney(user.getMoney() - deposit.getMoney());
		// userService.update(user);
		//
		// prepay.setCreatedate(new Date().getTime());
		// prepay.setIsin(0);
		// prepay.setMoney(deposit.getMoney());
		// prepay.setTt(2);
		// prepay.setUserid(user.getId());
		// prepay.setDepositid(depositid);
		// prepaylogService.save(prepay);
		// } else {
		// double total = deposit.getMoney();
		// // 如果是商家提现，按折扣从低到高查询出所有余额记录
		// QueryParam params = new QueryParam(4).add("restmoney>", 0.0)
		// .add("userid", deposit.getUserid())
		// .add("shopid", deposit.getShopid()).add("tt", 0);
		// List<Prepaylog> list = prepaylogService.getList(params, 0, 0,
		// "discount", "desc", false);
		// QueryParam otherParams;
		// // 循环用户在商家中的充值余额，优先提现低折扣
		// for (Prepaylog prepaylog : list) {
		// prepay = new Prepaylog();
		//
		// otherParams = new QueryParam().add("linkid", prepaylog.getId());
		// List<Prepaylog> indexList = prepaylogService.getList(
		// otherParams, 0, 1, "displayOrder", "desc", false);
		// if (indexList.size() == 0) {
		// prepay.setDisplayOrder(prepaylog.getDisplayOrder() - 1);
		// } else {
		// prepay.setDisplayOrder(indexList.get(0).getDisplayOrder() - 1);
		//
		// }
		// prepay.setCreatedate(new Date().getTime());
		// prepay.setIsin(0);
		// prepay.setTt(2);
		// prepay.setUserid(deposit.getUserid());
		// prepay.setShopid(deposit.getShopid());
		// prepay.setLinkid(prepaylog.getId());
		// prepay.setDiscount(prepaylog.getDiscount());
		// prepay.setDepositid(depositid);
		// if (total - prepaylog.getRestmoney() > 0) {
		// prepay.setMoney(prepaylog.getRestmoney());
		//
		// } else {
		// prepay.setMoney(total);
		// }
		// total = total - prepaylog.getRestmoney();
		// prepaylogService.save(prepay);
		// prepaylog.setRestmoney(prepaylog.getRestmoney()
		// - prepay.getMoney());
		// prepaylogService.update(prepaylog);
		//
		// if (total <= 0) {
		// break;
		// }
		// }
		//
		// list = prepaylogService.getList(params, 0, 0, "discount", "asc",
		// false);
		//
		// // 同时更新shopvip
		// if (list.size() > 0) {
		//
		// JSONArray jsonAry = new JSONArray();
		// double totalMoney = 0;
		// for (Prepaylog prepaylog : list) {
		// JSONObject jsonObj = new JSONObject();
		// jsonObj.put("id", prepaylog.getId());
		// jsonObj.put("createdate", prepaylog.getCreatedate());
		// jsonObj.put("money", prepaylog.getRestmoney());
		// jsonObj.put("discount", prepaylog.getDiscount());
		// jsonAry.add(jsonObj);
		// totalMoney += prepaylog.getRestmoney();
		// }
		// Shopvip shopvip = shopvipService.get(deposit.getUserid() + "z"
		// + deposit.getShopid());
		// shopvip.setPrepayjson(jsonAry.toString());
		// shopvip.setMoney(totalMoney);
		// shopvipService.update(shopvip);
		// }
		//
		// }

		getResponse().sendRedirect("deposit!details.action?shopid=" + shopid);
		return null;
	}

	public String details() {
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		QueryParam params = new QueryParam(2).add("userid", userid).add(
				"shopid", shopid);
		list = depositService
				.getList(params, 0, 0, "createdate", "desc", false);

		return "details";
	}

	public String getDeposittype() {
		return deposittype;
	}

	public void setDeposittype(String deposittype) {
		this.deposittype = deposittype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWxname() {
		return wxname;
	}

	public void setWxname(String wxname) {
		this.wxname = wxname;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}