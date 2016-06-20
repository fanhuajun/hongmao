package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.RechargelogDao;
import com.wudianyi.wb.hongmao.entity.Rechargelog;
import com.wudianyi.wb.hongmao.service.RechargelogService;

@Service
public class RechargelogServiceImpl extends
		BaseServiceImpl<Rechargelog, String> implements RechargelogService {

	@Resource
	public void setBaseDao(RechargelogDao rechargelogDao) {
		super.setBaseDao(rechargelogDao);
	}
}
