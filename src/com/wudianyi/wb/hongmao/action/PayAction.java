package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.entity.Order;
import com.wudianyi.wb.hongmao.entity.Prepaylog;
import com.wudianyi.wb.hongmao.service.OrderService;
import com.wudianyi.wb.hongmao.service.PrepaylogService;

public class PayAction extends BaseAction{
	
	private String orderid;
	private String prepayid;
	
	@Resource
	private OrderService orderService;
	@Resource
	private PrepaylogService prepaylogService;
	
	public String ok() {
		
		Order order = orderService.get(orderid);
		setAttribute("order", order);
		
		return "ok";
	}
	
	public String rechargeOk() {
		Prepaylog prepay = prepaylogService.get(prepayid);
		setAttribute("prepay", prepay);
		
		return "recharge_ok";
	}
	

	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String getPrepayid() {
		return prepayid;
	}


	public void setPrepayid(String prepayid) {
		this.prepayid = prepayid;
	}
	
	
	
}
