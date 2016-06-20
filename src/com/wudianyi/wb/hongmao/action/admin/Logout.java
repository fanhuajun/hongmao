package com.wudianyi.wb.hongmao.action.admin;

import java.io.IOException;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.Const;

public class Logout extends BaseAction {
	
	public String execute () throws IOException{
		removeSession(Const.SESSION_ADMIN_SHOPID);
		getResponse().sendRedirect("login.action");
	   return null;
	}
	
    
}
