package com.wudianyi.wb.hongmao.action.json;

import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.UserService;
import com.wudianyi.wb.hongmao.util.SmsUtil;

public class LoginAction extends BaseAction {

	@Resource
	private UserService userService;

	private String phone;// 用户 的手机号，也是注册的手机号
	private String pwd;// 登陆密码
	private String name;// 用户真实姓名
	private String phoneCode;//手机验证码

	public static void main(String[] args) {
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		String password = md5PasswordEncoder.encodePassword("123456", null);
		System.err.println(password);
	}

	public String in() throws IOException {
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		String password = md5PasswordEncoder.encodePassword(pwd, null);
		// Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);

		System.err.println("password==" + password);
		QueryParam param = new QueryParam(2).add("phone", phone).add(
				"password", password);
		User user = userService.get(param, false);
		// 判断有没这个用户
		if (user == null) {
			return ajaxJson("error");
		}
		// setSession(Const.SESSION_CITY_ID, user.getCityId());
		setSession(Const.SESSION_USER_ID, user.getId());
		return ajaxJson("success");
	}
	
	/*
	 * 查看手机号是否存在,有就发送验证码
	 */
	public String checkPhone() throws Exception {

		QueryParam param = new QueryParam(1).add("phone", phone);
		User user = userService.get(param, false);
		// 判断用户是否存在
		if (user == null) {
			return ajaxJsonErrorMessage("该用户不存在");// 不存false
		}
		// 生成6位随机数
		Random random = new Random();
		String codeT = random.nextInt(9) + "" + random.nextInt(9)
				+ random.nextInt(9) + random.nextInt(9) + random.nextInt(9)
				+ random.nextInt(9);
		String content = "【红猫】红猫会员找回密码，动态验证码：" + codeT + "（十分钟内有效）";
		System.err.println(content);
		// 发送验证码
		String res = SmsUtil.sendSms(content, phone);
		setSession(phone + "user_phoneCode", codeT);
		return ajaxJsonSuccessMessage("");
	}
	
	/*
	 * 修改密码
	 * */
	public String changePass(){
		String phoneCode1 = (String)getSession(phone + "user_phoneCode");
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		String password = md5PasswordEncoder.encodePassword(pwd, null);
		QueryParam params = new QueryParam().add("phone", phone);
			User user = userService.get(params, false);
		if(null == user){
			return ajaxJsonErrorMessage("用户不存在");
		}
		
		if(phoneCode.equals(phoneCode1)){
			user.setPassword(password);
			userService.update(user);
			return ajaxJsonSuccessMessage("");
		}
		return ajaxJsonErrorMessage("验证码错误");
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

}
