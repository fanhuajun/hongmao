package com.wudianyi.wb.hongmao.action.admin;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.Order;
import com.wudianyi.wb.hongmao.service.OrderService;

public class OrderAction extends BaseAction{
	@Resource
	private OrderService orderService;

	
	public static void main(String[] args) {
		
		
		
	}
	
	private String id;
	
	public String list(){
		return LIST;
	}
	
	@Override
	public String execute() throws Exception {
		Order order = orderService.get(id);
		setAttribute("order", order);
		return super.execute();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
