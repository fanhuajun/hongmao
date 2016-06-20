package com.wudianyi.wb.hongmao.action.admin.json;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.Agent;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.AgentService;

public class AgentAction extends BaseAction {

	@Resource
	private AgentService agentService;

	private String username;
	private String pwd;
	private String name;
	private Integer agentid;

	public String list() {

		list = agentService.getList(null, pn - 1 * (Const.BACK_PAGE_SIZE),
				Const.BACK_PAGE_SIZE, "createdate", "desc", false);
		return LIST;
	}

	public String totalNum() {
		System.out.println("keyword========" + keyword);
		tn = agentService.getTotalCount(null, false);
		System.out.println("tn========" + tn);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

	public String save() {
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		Agent agent = new Agent();
		agent.setCreatedate(new Date().getTime());
		agent.setMoney(0.00);
		agent.setName(name);
		agent.setDel(0);
		agent.setPhone(username);
		agent.setPwd(md5PasswordEncoder.encodePassword(pwd, null));
		if (agentid != null) {
			Agent upAgent = agentService.get(agentid);
			if (upAgent != null) {
				agent.setOne(agentid);
				agent.setTwo(agent.getOne());
				agent.setThree(agent.getTwo());
			}
		}
		agentService.save(agent);
		return ajaxJsonSuccessMessage(null);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

}
