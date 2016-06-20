package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.PrepaylogDao;
import com.wudianyi.wb.hongmao.entity.Prepaylog;
import com.wudianyi.wb.hongmao.service.PrepaylogService;




@Service
public class PrepaylogServiceImpl extends BaseServiceImpl<Prepaylog,String>
				implements PrepaylogService{

		@Resource
		public void setBaseDao(PrepaylogDao prepaylogDao){
			super.setBaseDao(prepaylogDao);
		}
}
