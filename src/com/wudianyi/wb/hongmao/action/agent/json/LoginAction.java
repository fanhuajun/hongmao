package com.wudianyi.wb.hongmao.action.agent.json;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Agent;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.AgentService;

public class LoginAction extends BaseAction {

	@Resource
	private AgentService agentService;

	private String phone;
	private String password;

	public String in() {
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		QueryParam param = new QueryParam().add("phone", phone).add("pwd",
				md5PasswordEncoder.encodePassword(password, null));
		Agent agent = agentService.get(param, false);
		if (agent == null) {
			return ajaxJson("{\"success\":false}");
		}
		setSession(Const.SESSION_ADMIN_AGENTID, agent.getId());
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
