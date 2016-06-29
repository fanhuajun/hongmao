package com.wudianyi.wb.hongmao.action.admin.json;

import java.util.Date;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.News;
import com.wudianyi.wb.hongmao.service.NewsService;

public class NewsAction extends BaseAction {

	@Resource
	private NewsService newsService;

	private String title;

	private String picUrl;

	private String content;

	private Integer id;

	public String list() {
		Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
		if (shopid == null) {
			shopid = 0;
		}
		list = newsService.getList(new QueryParam(1).add("shopid", shopid),
				(pn - 1) * Const.BACK_PAGE_SIZE, Const.BACK_PAGE_SIZE,
				"createdate", "desc", false);

		return LIST;
	}

	public String totalNum() {
		Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);
		if (shopid == null) {
			shopid = 0;
		}
		tn = newsService.getTotalCount(new QueryParam(1).add("shopid", shopid),
				false);

		System.out.println("tn========" + tn);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

	public String edit() {
		Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);

		News news = null;
		if (id != null) {
			news = newsService.get(id);
		}
		boolean save = false;
		if (news == null) {
			save = true;
			news = new News();
			news.setCreatedate(new Date().getTime());
		}
		news.setContent(content);
		news.setPic(picUrl);
		news.setShopid(shopid);
		news.setTitle(title);
		if (save) {
			newsService.save(news);
		} else {
			newsService.update(news);
		}
		return ajaxJsonSuccessMessage("news!list.action");
	}

	public String delete() {
		newsService.delete(id);
		return ajaxHtml("success");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
