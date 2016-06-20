package com.wudianyi.wb.hongmao.action.json;

import java.util.Date;
import java.util.Random;
import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.UserService;
import com.wudianyi.wb.hongmao.util.SmsUtil;

/*
 * 注册
 */
public class RegisterAction extends BaseAction {

	private String phone;
	private String pwd;
	private String code;
	private String note;
	@Resource
	private UserService userService;

	@Override
	public String execute() throws Exception {
		System.err.println(getSession(Const.SESSION_FRONT_SHOPID));
		return null;
	}

	/*
	 * 查看手机号是否已被注册,没有就发送验证码
	 */
	public String checkPhone() throws Exception {
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		QueryParam param = new QueryParam(2).add("phone", phone).add("shopid",
				shopid);
		User user = userService.get(param, false);
		// 判断用户是否存在
		if (user != null) {
			return ajaxJson("-1");// 不存在就返回-1
		}
		// 生成6位随机数
		Random random = new Random();
		String codeT = random.nextInt(9) + "" + random.nextInt(9)
				+ random.nextInt(9) + random.nextInt(9) + random.nextInt(9)
				+ random.nextInt(9);
		String content = "【红猫】红猫会员注册，动态验证码：" + codeT + "（十分钟内有效）";
		System.err.println(content);
		// 发送验证码
		String res = SmsUtil.sendSms(content, phone);
		setSession(phone + "user_phoneCode", codeT);
		return ajaxJson("{\"success\":true}");
	}

	/*
	 * 注册
	 */
	public String in() throws Exception {
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		// 先判断验证码是否正确
		if (getSession(phone + "user_phoneCode") == null) {
			return ajaxJson("error");
		}
		String sessioncode = getSession(phone + "user_phoneCode").toString();
		if (!sessioncode.equals(code)) {// 如果验证码和输入的不对
			return ajaxJson("error");// 返回错误
		}
		// 判断用户是否已经存在
		QueryParam param1 = new QueryParam(2).add("phone", phone).add("shopid",
				shopid);
		User user = userService.get(param1, false);
		if (user != null) {
			return ajaxJson("-1");// 如果找到有，那就返回已有不能注册
		}
		Date date = new Date();
		Long creat = date.getTime();

		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		Object weixinObj = getSession(Const.SESSION_WEIXINID);
		boolean save = false;
		if (weixinObj != null) {
			user = userService.get(
					new QueryParam(1).add("weixinid", weixinObj.toString()),
					false);
			if(user==null){
				save = true;
				user = new User();
				user.setWeixinid(weixinObj.toString());
				
			}
		}else{
			user = new User();
			save = true;
		}

		user.setShopid(shopid);
		user.setPhone(phone);
		user.setPassword(md5PasswordEncoder.encodePassword(pwd, null));
		user.setCreatedate(creat);
		int cid  = 0;
		if(save){
			cid = userService.save(user);
		}else{
			userService.update(user);
			cid= user.getId();
		}
		setSession(Const.SESSION_USER_ID, cid);

		return ajaxJson("success");
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
