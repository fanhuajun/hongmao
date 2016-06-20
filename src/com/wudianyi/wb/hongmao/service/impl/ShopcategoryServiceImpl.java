package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.ShopcategoryDao;
import com.wudianyi.wb.hongmao.entity.Shopcategory;
import com.wudianyi.wb.hongmao.service.ShopcategoryService;




@Service
public class ShopcategoryServiceImpl extends BaseServiceImpl<Shopcategory,Integer>
				implements ShopcategoryService{

		@Resource
		public void setBaseDao(ShopcategoryDao shopcategoryDao){
			super.setBaseDao(shopcategoryDao);
		}
}
