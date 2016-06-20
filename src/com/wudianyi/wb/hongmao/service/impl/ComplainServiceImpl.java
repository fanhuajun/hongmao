package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.ComplainDao;
import com.wudianyi.wb.hongmao.entity.Complain;
import com.wudianyi.wb.hongmao.service.ComplainService;




@Service
public class ComplainServiceImpl extends BaseServiceImpl<Complain,Integer>
				implements ComplainService{

		@Resource
		public void setBaseDao(ComplainDao complainDao){
			super.setBaseDao(complainDao);
		}
}
