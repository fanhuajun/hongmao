package com.wudianyi.wb.hongmao.action.admin;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.UserService;

@ParentPackage("admin")
public class UserAction extends BaseAction {
	@Resource
	private UserService userService;

	private int id;

	public String list() {
		Date date = new Date();
		Long now = date.getTime();
		System.out.println("the time:" + now);
		return LIST;
	}

	public String execute() {
		User user = userService.get(id);
		setAttribute("user", user);
		return "user";
	}

	public String consume() {
		return "consume";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}