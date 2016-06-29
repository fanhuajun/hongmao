package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.UserService;

public class IncomeAction extends BaseAction {
	@Resource
	private UserService userService;

	@Override
	public String execute() throws Exception {
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		System.out.println("userid:...."+userid); 
		User user = userService.get(userid);
		setAttribute("user", user);
		return "income";
	}

}
