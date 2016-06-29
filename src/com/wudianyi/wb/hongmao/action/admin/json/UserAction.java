package com.wudianyi.wb.hongmao.action.admin.json;

import javax.annotation.Resource;
import javax.management.Query;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.OrderService;
import com.wudianyi.wb.hongmao.service.UserService;

public class UserAction extends BaseAction {

	@Resource
	private UserService userService;
	@Resource
	private OrderService orderService;

	private int id;

	public String list() {
		
		
		Integer isadmin = getSession_is_admin();
		QueryParam param = null;
		Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
		String hql = "select s.rank,u.name,u.phone,s.prepayjson,u.createdate from User u,Shopvip s where";
		
		if (isadmin == 0) {
			param = new QueryParam(1).add("shopid", shopid);
			hql += " s.shopid=" + shopid + "and u.id=s.userid order by u.createdate desc";
			list = userService.getUserWithMoney(hql,shopid, pn,
					Const.BACK_PAGE_SIZE);
		} else {
			hql += " u.id=s.userid order by u.createdate desc";
			list = userService.getUserWithMoney(hql,null, pn, Const.BACK_PAGE_SIZE);
		}

		// list = userService
		// .getLikeList("phone", keyword, null, param, (pn - 1)
		// * Const.BACK_PAGE_SIZE, Const.BACK_PAGE_SIZE, null,
		// null, false);

		return LIST;
	}

	public String totalNum() {
		Integer isadmin = getSession_is_admin();
		Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
		String hql = "select u.rank from User u ,Shopvip s where";
		
		if (isadmin == 0) {
			hql += " s.shopid=" + shopid + "and u.id=s.userid order by u.createdate desc";
			tn = userService
					.getTotalCount(hql,shopid);
		}else{
			hql += " u.id=s.userid order by u.createdate desc";
			tn = userService
					.getTotalCount(hql,null);
		}

		System.out.println("tn========" + tn);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

	public String consume() {
		QueryParam param = new QueryParam(2);
		param.add("userid", id).add("stat>=", 1);// 该用户已支付的
		list = orderService.getList(param, Const.BACK_PAGE_SIZE * (pn - 1),
				Const.BACK_PAGE_SIZE, "paydate", "desc", false);
		return "consume";
	}

	public String consumeTotal() {
		QueryParam param = new QueryParam(2);
		param.add("userid", id).add("stat>=", 1);// 该用户已支付的
		tn =  orderService.getTotalCount(param, false);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
