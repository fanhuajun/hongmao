package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Prepaylog;
import com.wudianyi.wb.hongmao.service.PrepaylogService;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.service.UserService;
@ParentPackage("user")
public class UserAction extends BaseAction {
	@Resource
	private ShopService shopService;
	@Resource
	private UserService userService;
	@Resource
	private PrepaylogService prepaylogService;

	private double totalmoney;
	
	public String shops() {
		return "shops";
	}

	public String seller() {
		return "seller";
	}

	public String member() {

		Object userobj = getSession(Const.SESSION_USER_ID);
		Integer userid = (Integer) userobj;
		/*if (userobj == null) {
			userid = (Integer) userobj;
		}*/

		int levelone = userService.getTotalCount(
				new QueryParam(1).add("one", userid), false);
		int leveltwo = userService.getTotalCount(
				new QueryParam(2).add("two", userid), false);
		int levelthree = userService.getTotalCount(
				new QueryParam(2).add("three", userid), false);
		setAttribute("levelone", levelone);
		setAttribute("leveltwo", leveltwo);
		setAttribute("levelthree", levelthree);

		return "member";
	}

	public String wallet() {
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		totalmoney = userService.get(userid).getMoney();
		QueryParam params = new QueryParam().add("userid", userid).add("tt!",
				-2);
		list = prepaylogService.getList(params, 0, 0, "createdate", "desc",
				false);

		return "wallet";
	}

	public double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}

}
