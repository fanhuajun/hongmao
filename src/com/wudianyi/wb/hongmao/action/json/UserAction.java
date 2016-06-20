package com.wudianyi.wb.hongmao.action.json;

import java.util.Random;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.UserService;
import com.wudianyi.wb.hongmao.util.SmsUtil;

public class UserAction extends BaseAction {
	@Resource
	private UserService userService;
	
	private String pic;
	private String username;
	private String phoneOld;
	private String phoneNew;
	private String code;
	
	public String updataimg(){
		int userid = (Integer)getSession(Const.SESSION_USER_ID);
		
		User user = userService.get(userid);
		user.setPic(pic);
		userService.update(user);
		
		return null;
	}
	
	public String altername(){
        int userid = (Integer)getSession(Const.SESSION_USER_ID);
		
		User user = userService.get(userid);
		user.setName(username);
		userService.update(user);
		
		return ajaxJson("{\"success\": true}"); 
		
	}
	
	public String checkPhone() throws Exception{
		
		User user = userService.get(new QueryParam(1).add("phone", phoneNew), false);
		//判断用户是否存在
		if (user != null) {
			return ajaxJsonErrorMessage("该手机号码已存在");
		}
        //生成4位随机数
		Random random = new Random();
		String codeT = random.nextInt(9) +""+ random.nextInt(9)+ random.nextInt(9) + random.nextInt(9);
		String content = codeT + "（服务验证码，十分钟内有效）";
		System.out.println(content);
		//发送验证码
		String res = SmsUtil.sendSms(content, phoneNew);
		setSession("user_phoneCode", codeT);
		
		return ajaxJson("{\"success\":true}");
	}
	
	public String changephone() {
		System.out.println("phoneNew:"+phoneNew);
		QueryParam params = new QueryParam(1).add("phone", phoneNew);
		User user = userService.get(params,false);
		if(user != null) {
			return ajaxJsonErrorMessage("手机号已存在!");
		}
				
		// 先判断验证码是否正确
	    if (getSession("user_phoneCode") == null) {
	    	return ajaxJsonErrorMessage("验证码不能为空!");
			}
		String sessioncode = getSession("user_phoneCode")
					.toString();
		if (!sessioncode.equals(code)) {
			return ajaxJsonErrorMessage("验证码错误!");
		}
		int userid = (Integer)getSession(Const.SESSION_USER_ID);
		params = new QueryParam(1).add("id", userid);
		user = userService.get(params,false); 
		user.setPhone(phoneNew);
		userService.update(user);
		
		return ajaxJsonSuccessMessage("修改成功");
	}

	
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhoneNew() {
		return phoneNew;
	}

	public void setPhoneNew(String phoneNew) {
		this.phoneNew = phoneNew;
	}

	

}


