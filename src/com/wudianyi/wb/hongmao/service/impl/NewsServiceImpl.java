package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.NewsDao;
import com.wudianyi.wb.hongmao.entity.News;

import com.wudianyi.wb.hongmao.service.NewsService;

@Service
public class NewsServiceImpl extends BaseServiceImpl<News, Integer> implements
		NewsService {

	@Resource
	public void setBaseDao(NewsDao newsDao) {
		super.setBaseDao(newsDao);
	}

}
