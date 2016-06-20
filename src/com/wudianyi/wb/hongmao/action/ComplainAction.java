package com.wudianyi.wb.hongmao.action;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.service.UserService;


/**
 * 建议
 */
public class ComplainAction extends BaseAction{

	private int shopid;
	private String shopname;
	private Integer userid;
	private String username;
	@Resource
	private UserService userService;
	@Resource
	private ShopService shopService;
	
	public String a(){
		
	userid = (Integer)getSession(Const.SESSION_USER_ID);
	setAttribute("userid", userid);
	setAttribute("shopid", shopid);
	
	User user = userService.get(userid);
	username = user.getName();
	Shop shop = shopService.get(shopid);
	shopname = shop.getName();
	
	setAttribute("username", username);
	setAttribute("shopname", shopname);
	
	return "complain";
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
