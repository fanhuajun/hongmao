package com.wudianyi.wb.hongmao.action.admin.json;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import net.sf.json.JSONObject;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Agent;
import com.wudianyi.wb.hongmao.entity.Agentlog;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Openlog;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.entity.Webinfo;
import com.wudianyi.wb.hongmao.service.AgentService;
import com.wudianyi.wb.hongmao.service.AgentlogService;
import com.wudianyi.wb.hongmao.service.OpenlogService;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.service.WebinfoService;

public class OpenAction extends BaseAction {

	private String username;
	private String pwd;
	private String name;
	private String phone;
	private String end;
	private Integer agentid;
	private Double money;

	@Resource
	private AgentService agentService;

	@Resource
	private ShopService shopService;

	@Resource
	private OpenlogService openlogService;

	@Resource
	private WebinfoService webinfoService;

	@Resource
	private AgentlogService agentlogService;

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		Agent agent = null;
		Webinfo webinfo = webinfoService.get(Const.WEBINFO_ID);
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		JSONObject retJson = new JSONObject();
		Shop checkShop = shopService.get(
				new QueryParam(1).add("phone", username), false);
		if (checkShop != null) {
			retJson.put("success", false);
			retJson.put("msg", "用户名已经存在");
			return ajaxJson(retJson.toString());
		}

		if (agentid != null) {
			// 扣取代理的钱
			agent = agentService.get(agentid);
			if (agent == null) {
				retJson.put("success", false);
				retJson.put("msg", "代理ID不存在");
				return ajaxJson(retJson.toString());
			}

			if (agent.getMoney() < money) {
				retJson.put("success", false);
				retJson.put("msg", "该代理余额不足");
				return ajaxJson(retJson.toString());
			}
			agent.setMoney(agent.getMoney() - money);
			// 返佣
			double backmoney = money * webinfo.getAgentback();
			agent.setMoney(agent.getMoney() + backmoney);

			agentService.update(agent);

		}

		Shop shop = new Shop();

		shop.setName(name);
		shop.setPhone(username);
		shop.setPassword(md5PasswordEncoder.encodePassword(pwd, null));
		shop.setTel(phone);
		shop.setOverduetime(sdf.parse(end).getTime());
		shop.setAgentid(agentid);

		// 开通记录
		Openlog openlog = new Openlog();
		openlog.setAgentid(agentid);
		openlog.setBegin(new Date().getTime());
		openlog.setEnd(sdf.parse(end).getTime());
		openlog.setMoney(money);
		openlog.setShopid(shop.getId());
		openlogService.save(openlog);

		if (agentid != null) {
			Agentlog agentlog = new Agentlog();
			agentlog.setContent("开通了商铺：" + name);
			agentlog.setCreatedate(new Date().getTime());
			agentlog.setLinkid(shop.getId() + "");
			agentlog.setMoney(money);
			agentlog.setAgentid(agentid);
			agentlog.setTt(-1);
			agentlogService.save(agentlog);

			// 返佣记录
			Agentlog agentlog2 = new Agentlog();
			agentlog2.setContent("商铺开通返佣");
			agentlog2.setCreatedate(new Date().getTime());
			agentlog2.setLinkid(shop.getId() + "");
			agentlog2.setMoney(money * webinfo.getAgentback());
			agentlog2.setTt(1);
			agentlog.setAgentid(agentid);
			agentlogService.save(agentlog2);

		}

		// 上级返佣
		if (agent != null) {
			if (agent.getOne() != null) {
				Agent one = agentService.get(agent.getOne());
				if (one != null) {
					Agentlog onelog = new Agentlog();
					onelog.setAgentid(agent.getOne());
					onelog.setMoney(money * webinfo.getAgentone());
					onelog.setCreatedate(new Date().getTime());
					onelog.setTt(1);
					onelog.setLinkid(shop.getId() + "");
					onelog.setContent("商铺开通返佣");
					agentlogService.save(onelog);
					one.setMoney(one.getMoney() + onelog.getMoney());
					agentService.update(one);
				}
			}

			if (agent.getTwo() != null) {
				Agent two = agentService.get(agent.getTwo());
				if (two != null) {
					Agentlog twolog = new Agentlog();
					twolog.setAgentid(agent.getTwo());
					twolog.setMoney(money * webinfo.getAgenttwo());
					twolog.setCreatedate(new Date().getTime());
					twolog.setTt(1);
					twolog.setLinkid(shop.getId() + "");
					twolog.setContent("商铺开通返佣");
					agentlogService.save(twolog);
					two.setMoney(two.getMoney() + twolog.getMoney());
					agentService.update(two);
				}
			}

			if (agent.getThree() != null) {
				Agent three = agentService.get(agent.getThree());
				if (three != null) {
					Agentlog threelog = new Agentlog();
					threelog.setAgentid(agent.getTwo());
					threelog.setMoney(money * webinfo.getAgentthree());
					threelog.setCreatedate(new Date().getTime());
					threelog.setTt(1);
					threelog.setLinkid(shop.getId() + "");
					threelog.setContent("商铺开通返佣");
					agentlogService.save(threelog);
					three.setMoney(three.getMoney() + threelog.getMoney());
					agentService.update(three);
				}
			}

		}

		retJson.put("success", true);
		return ajaxJson(retJson.toString());
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
