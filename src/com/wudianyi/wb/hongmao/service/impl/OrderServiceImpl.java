package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.OrderDao;
import com.wudianyi.wb.hongmao.entity.Order;
import com.wudianyi.wb.hongmao.service.OrderService;




@Service
public class OrderServiceImpl extends BaseServiceImpl<Order,String>
				implements OrderService{

		@Resource
		public void setBaseDao(OrderDao orderDao){
			super.setBaseDao(orderDao);
		}
}
