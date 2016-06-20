package com.wudianyi.wb.hongmao.action.json;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Category;
import com.wudianyi.wb.hongmao.service.CategoryService;

public class CategoryAction extends BaseAction {

	private Integer nodeid;

	@Resource
	private CategoryService categoryService;

	public String down() {
		List<Category> list = categoryService.getList(
				new QueryParam(1).add("nodeid", nodeid), 0, 0, "orderbyid",
				"desc", false);
		JSONObject retJson = new JSONObject();
		JSONArray categoryJson = JSONArray.fromObject(list);
		retJson.put("success", true);
		retJson.put("categories", categoryJson);
		return ajaxJson(retJson.toString());

	}

	public Integer getNodeid() {
		return nodeid;
	}

	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}

}
