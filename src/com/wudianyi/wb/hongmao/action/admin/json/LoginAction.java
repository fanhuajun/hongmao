package com.wudianyi.wb.hongmao.action.admin.json;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.ShopService;

public class LoginAction extends BaseAction {

	public static void main(String[] args) {
		System.err.println(new Date().getTime());
	}

	@Resource
	private ShopService shopService;

	private String phone;
	private String password;

	public String in() {
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		System.err.println("md5PasswordEncoder.encodePassword(password, null)=="+md5PasswordEncoder.encodePassword(password, null));
		QueryParam param = new QueryParam().add("phone", phone).add("password",
				md5PasswordEncoder.encodePassword(password, null));
		Shop shop = shopService.get(param, false);
		if (shop == null) {
			return ajaxJson("{\"success\":false}");
		}
		setSession(Const.SESSION_ADMIN_SHOPID, shop.getId());
		setSession(Const.SESSION_ADMIN_ADMIN, shop.getIsadmin());
		return ajaxJson("{\"success\":true}");
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
