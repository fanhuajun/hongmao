package com.wudianyi.wb.hongmao.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.AgentlogDao;
import com.wudianyi.wb.hongmao.entity.Agentlog;
import com.wudianyi.wb.hongmao.service.impl.BaseServiceImpl;

@Service
public class AgentlogServiceImpl extends BaseServiceImpl<Agentlog, String>
		implements AgentlogService {

	@Resource
	public void setBaseDao(AgentlogDao agentlogDao) {
		super.setBaseDao(agentlogDao);
	}

}
