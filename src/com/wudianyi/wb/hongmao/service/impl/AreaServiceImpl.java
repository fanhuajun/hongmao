package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.AreaDao;
import com.wudianyi.wb.hongmao.entity.Area;
import com.wudianyi.wb.hongmao.service.AreaService;


@Service
public class AreaServiceImpl extends BaseServiceImpl<Area,Integer>
				implements AreaService{

		@Resource
		public void setBaseDao(AreaDao areaDao){
			super.setBaseDao(areaDao);
		}
}
