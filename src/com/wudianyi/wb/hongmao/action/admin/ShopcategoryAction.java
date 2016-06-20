package com.wudianyi.wb.hongmao.action.admin;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.service.AreaService;
import com.wudianyi.wb.hongmao.service.CityService;
import com.wudianyi.wb.hongmao.service.ShopcategoryService;

@ParentPackage("admin")
public class ShopcategoryAction extends BaseAction{
	
	@Resource
	private ShopcategoryService shopcategoryService;
	
	public String list() {
		
		list = shopcategoryService.getList(null, 0, 0, "orderbyid", "asc", true);
		
		
		return LIST;
	}

}
