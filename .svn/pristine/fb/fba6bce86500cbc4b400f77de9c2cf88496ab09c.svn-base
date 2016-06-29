package com.wudianyi.wb.hongmao.action.json;

import java.util.Random;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.service.CacheService;
import com.wudianyi.wb.hongmao.util.SmsUtil;
import com.wudianyi.wb.hongmao.util.StringUtils;

public class DepositAction extends BaseAction{
	
	private String phone;
	private String code;
	
	@Resource
	private CacheService cacheService;
	
	public String sendValidateCode() throws Exception{
		
		//生成6位随机数
		Random random = new Random();
		String codeT = random.nextInt(9) + "" + random.nextInt(9)
				+ random.nextInt(9) + random.nextInt(9) + random.nextInt(9)
				+ random.nextInt(9);
		String content = "【红猫】红猫提现验证码：" + codeT + "（十分钟内有效）";
		System.err.println(content);
		//发送验证码
		SmsUtil.sendSms(content, phone);
		cacheService.set(CacheService.CACHE_SESSION + getStatusid() + "_"
				+ phone + "drawCash", codeT, 600);
		
		
		return ajaxJsonSuccessMessage("");
	}
	
	public String checkValidateCode() {
		if(StringUtils.isEmpty(code)) {
			return ajaxJsonErrorMessage("验证码不能为空!");
		}	
		Object sessioncode = getSession(phone + "drawCash");
		if(sessioncode==null || !sessioncode.toString().equals(code)){//如果验证码和输入的不对
			return ajaxJsonErrorMessage("验证码错误!");//返回错误
		}
		
		return ajaxJsonSuccessMessage("");
		
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
