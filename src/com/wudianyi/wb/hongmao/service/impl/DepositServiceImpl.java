package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.DepositDao;
import com.wudianyi.wb.hongmao.entity.Deposit;
import com.wudianyi.wb.hongmao.service.DepositService;




@Service
public class DepositServiceImpl extends BaseServiceImpl<Deposit,Integer>
				implements DepositService{

		@Resource
		public void setBaseDao(DepositDao depositDao){
			super.setBaseDao(depositDao);
		}
}
