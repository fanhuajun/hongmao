package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shopvip;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.ShopvipService;
import com.wudianyi.wb.hongmao.service.UserService;

public class IncomeAction extends BaseAction {
	@Resource
	private UserService userService;
	@Resource
	private ShopvipService shopvipService;

	@Override
	public String execute() throws Exception {
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		Integer shopid = (Integer)getSession(Const.SESSION_FRONT_SHOPID);
		System.out.println("userid:...."+userid); 
		User user = userService.get(userid);
		Shopvip shopvip = shopvipService.saveOrget(userid, shopid); 
		setAttribute("user", user);
		setAttribute("shopvip", shopvip); 

		return "income";
	}

}
