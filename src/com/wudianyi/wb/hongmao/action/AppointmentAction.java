package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.UserService;

public class AppointmentAction extends BaseAction {
	@Resource
	private UserService userService;
	private String username;
	
	public String execute() {
		Integer userid = (Integer)getSession(Const.SESSION_USER_ID);
		username = userService.get(userid).getName();
		return "appointment";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
