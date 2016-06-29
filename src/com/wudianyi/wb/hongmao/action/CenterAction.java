package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;





import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shopvip;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.ShopvipService;
import com.wudianyi.wb.hongmao.service.UserService;

/*
 * 个人中心
 */
@ParentPackage("user")
public class CenterAction extends BaseAction{

	@Resource
	private UserService userService;
	@Resource
	private ShopvipService shopvipService;
	
	private String username;
	private String phoneOld;
	
	@Override
	public String execute() throws Exception {
		Integer userid = (Integer)getSession(Const.SESSION_USER_ID);
		Integer shopid = (Integer)getSession(Const.SESSION_FRONT_SHOPID);
		System.out.println("execute userid...:"+userid); 
		User user = userService.get(userid);
		Shopvip shopvip = shopvipService.saveOrget(userid, shopid); 
		setAttribute("user", user);
		setAttribute("shopvip", shopvip); 
		
		return "center";
	}
	
	public String info(){
		Integer userid = (Integer)getSession(Const.SESSION_USER_ID);
		User user = userService.get(userid);
		setAttribute("user", user);
		
		return "info";
	}
	
	public String altername(){
		
		return "altername";
	}
	
	public String alterphone1(){
		
		setAttribute("phoneOld", phoneOld);
		return "alterphone1";
	}
	public String alterphone2(){
		
		return "alterphone2";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneOld() {
		return phoneOld;
	}

	public void setPhoneOld(String phoneOld) {
		this.phoneOld = phoneOld;
	}
	
	
}
