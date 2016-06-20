package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.AgentDao;
import com.wudianyi.wb.hongmao.entity.Agent;
import com.wudianyi.wb.hongmao.service.AgentService;

@Service
public class AgentServiceImpl extends BaseServiceImpl<Agent, Integer> implements
		AgentService {
	@Resource
	public void setBaseDao(AgentDao agentDao) {
		super.setBaseDao(agentDao);
	}
}
