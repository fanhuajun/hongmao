package com.wudianyi.wb.hongmao.action.json;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.Appointment;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.AppointmentService;
import com.wudianyi.wb.hongmao.util.SmsUtil;

public class AppointmentAction extends BaseAction {
	   private long createdate;
	   private String appointdate;
	   private String num;
	   private String phone;
	   private int tt;
	   private String identify;
	   
	   @Resource
	   private AppointmentService appointmentService;
	   
	
       public String execute(){
    	   String user_phoneCode = (String)getSession(phone + "user_phoneCode");
    	   Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
    	   if(identify.equals(user_phoneCode)){
    		   Appointment appointment = new Appointment();
    		   createdate = new Date().getTime();
    		   appointment.setCreatedate(createdate);
    		   appointment.setAppointdate(appointdate);
    		   appointment.setNum(num);
    		   appointment.setPhone(phone);
    		   appointment.setShopid(shopid);
    		   appointmentService.save(appointment);
    		    return ajaxJson("{\"success\":true}");
    	   }
    	   
    	   return ajaxJson("{\"success\":false}");
       }
       
       public String send() throws Exception {
   		// 生成6位随机数
   		Random random = new Random();
   		String codeT = random.nextInt(9) + "" + random.nextInt(9)
   				+ random.nextInt(9) + random.nextInt(9) ;
   		String content = "红猫预约，动态验证码：" + codeT + "（十分钟内有效）";
   		System.out.println(content);
   		System.out.println(phone);
   		// 发送验证码
   		String res = SmsUtil.sendSms(content, phone);
   		setSession(phone + "user_phoneCode", codeT);
   		return ajaxJson("{\"success\":true,\"code\":\"" + codeT + "\"}");
   	}

	public long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getAppointdate() {
		return appointdate;
	}

	public void setAppointdate(String appointdate) {
		this.appointdate = appointdate;
	}
}
