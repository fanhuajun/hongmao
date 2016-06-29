package com.wudianyi.wb.hongmao.action.admin.json;

import java.util.List;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.AreaService;


public class AreaAction extends BaseAction{
	
	@Resource
	private AreaService areaService;
	private Integer index;
	private List arealist;
	private int id;
	private int thisId;

	//显示区域
	public String list() {
		QueryParam param = new QueryParam().add("cityid", id);
		arealist = areaService.getList(param, 0, 0, null, null, false);
		setAttribute("slevel_id", id);
		System.out.println("arealist:"+arealist);
		return LIST;
	}
	
	 public String totalNum() {
		    QueryParam param = new QueryParam();
		    param.add("cityid", thisId);
			tn = areaService.getLikeTotalCount(null, null, null, param, false);
			
						System.out.println("tn========" + tn);
			return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\"" + Const.BACK_PAGE_SIZE + "\"}");
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



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getThisId() {
		return thisId;
	}

	public void setThisId(int thisId) {
		this.thisId = thisId;
	}

}
