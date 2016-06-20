package com.wudianyi.wb.hongmao.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Circle;
import com.wudianyi.wb.hongmao.service.CircleService;

public class CircleAction extends BaseAction {
	public static void main(String[] args) {
		System.err.println(new Date().getTime());
	}

	private Integer areaid;

	@Resource
	private CircleService circleService;

	public String list() {
		List<Circle> list = circleService.getList(
				new QueryParam(1).add("areaid", areaid), 0, 0, "pinyin", "asc",
				false);
		JSONObject retJson = new JSONObject();
		JSONArray circlelistJson = new JSONArray();
		for (Circle circle : list) {
			JSONObject circleJson = new JSONObject();
			circleJson.put("name", circle.getName());
			circleJson.put("id", circle.getId());
			circlelistJson.add(circleJson);
		}
		retJson.put("success", true);
		retJson.put("circles", circlelistJson);
		return ajaxJson(retJson.toString());

	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

}
