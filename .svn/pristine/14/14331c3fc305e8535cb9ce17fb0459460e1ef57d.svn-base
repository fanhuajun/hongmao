package com.wudianyi.wb.hongmao.action;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.entity.Const;



@ParentPackage("front")
public class LogoutAction extends BaseAction {

	public String execute() throws Exception {
		removeSession(Const.SESSION_USER_ID);
		
		return ajaxJson("{'success':true}");
	}
	
	
	
}
