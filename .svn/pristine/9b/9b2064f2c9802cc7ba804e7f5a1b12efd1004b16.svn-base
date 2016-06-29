package com.wudianyi.wb.hongmao.action.admin;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.News;
import com.wudianyi.wb.hongmao.service.NewsService;

public class NewsAction extends BaseAction {

	private Integer id;

	private News news;

	@Resource
	private NewsService newsService;

	public String list() {
		return LIST;
	}

	public String edit() {
		if (id != null) {
			news = newsService.get(id);
		}
		return INPUT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public News getNews() {
		return news;
	}

}
