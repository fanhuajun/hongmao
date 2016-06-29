package com.wudianyi.wb.hongmao.action.json;

import java.util.Date;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.Complain;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.ComplainService;

public class ComplainAction extends BaseAction{

	private int shopid;//店铺id
	private String shopname;//店铺名称
	private Integer userid;//用户id
	private String username;//用户名
	private String content;//内容 
	@Resource
	private ComplainService complainService;
	
	/*
	 * 保存建议
	 */
	public String complainsave(){
		Integer shopid = (Integer)getSession(Const.SESSION_FRONT_SHOPID);
		Complain complain = new Complain();
		complain.setShopid(shopid);
		complain.setShopname(shopname);
		complain.setUserid(userid);
		complain.setUsername(username);
		complain.setContent(content);
		complain.setCreatedate(new Date().getTime()); 
		complainService.save(complain);
		
		return ajaxJsonSuccessMessage("");
	}

	
	
	
	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
