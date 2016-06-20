package com.wudianyi.wb.hongmao.action;

import java.util.List;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Area;
import com.wudianyi.wb.hongmao.entity.Category;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.AreaService;
import com.wudianyi.wb.hongmao.service.CategoryService;

public class ShopsAction extends BaseAction {

	@Resource
	private CategoryService categoryService;

	@Resource
	private AreaService areaService;

	@Override
	public String execute() throws Exception {
		
		setSession(Const.SESSION_LONG_LAT, "22.6629678503,114.0056875204");

		List<Category> categories = categoryService.getList(
				new QueryParam(1).add("nodeid", 0), 0, 0, "orderbyid", "desc",
				true);
		setAttribute("categories", categories);
		Integer cityid = (Integer) getSession(Const.SESSION_CITY_ID);

		List<Area> areas = areaService.getList(
				new QueryParam(1).add("cityid", cityid), 0, 0, "orderbyid",
				"desc", true);
		setAttribute("areas", areas);

		String long_lat = getSession(Const.SESSION_LONG_LAT).toString();

		setAttribute("long_lat", long_lat);
		return "shops";
	}
}
