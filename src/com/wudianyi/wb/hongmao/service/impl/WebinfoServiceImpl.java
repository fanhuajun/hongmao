package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.WebinfoDao;
import com.wudianyi.wb.hongmao.entity.Webinfo;
import com.wudianyi.wb.hongmao.service.WebinfoService;

@Service
public class WebinfoServiceImpl extends BaseServiceImpl<Webinfo, String>
		implements WebinfoService {

	@Resource
	public void setBaseDao(WebinfoDao webinfoDao) {
		super.setBaseDao(webinfoDao);
	}
}
