package com.wudianyi.wb.hongmao.action.admin;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.service.AreaService;
import com.wudianyi.wb.hongmao.service.CityService;

@ParentPackage("admin")
public class CityAction extends BaseAction{
	
	@Resource
	private CityService cityService;
	@Resource
	private AreaService areaService;
	private Integer index;
	private List arealist;
	
	

	//显示城市
	public String list() {
		list = cityService.getList(null, 0, 0, null, null, true);
		
		return LIST;
	}

	
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public List getArealist() {
		return arealist;
	}
	

}
