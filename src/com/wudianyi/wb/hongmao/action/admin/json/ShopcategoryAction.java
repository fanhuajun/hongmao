package com.wudianyi.wb.hongmao.action.admin.json;

import java.util.List;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Area;
import com.wudianyi.wb.hongmao.entity.City;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shopcategory;
import com.wudianyi.wb.hongmao.entity.Shopcontent;
import com.wudianyi.wb.hongmao.service.AreaService;
import com.wudianyi.wb.hongmao.service.ShopcategoryService;
import com.wudianyi.wb.hongmao.service.ShopcontentService;


public class ShopcategoryAction extends BaseAction{
	
	@Resource
	private ShopcategoryService shopcategoryService;
	@Resource
	private ShopcontentService shopcontentService;
	
	private Integer index;
	private List shopcategorylist;
	private int parentId;
	private int thisId;
	private String addOrEdit;
	private String name;
	private String delcategory;

	//显示区域
	public String list() {
		QueryParam param = new QueryParam().add("shopcategory.id", parentId);
		list =  shopcontentService.getList(param, 0, 0, null, null, false);
		setAttribute("slevel_id", parentId);
		return LIST;
	}
	
	 public String totalNum() {
		    QueryParam param = new QueryParam();
		    param.add("shopcategory.id", thisId);
			tn = shopcontentService.getLikeTotalCount(null, null, null, param, false);
			
			return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\"" + Const.BACK_PAGE_SIZE + "\"}");
		}

	
		 
		    //删除分类
		    public String delete(){
		    	if("del1".equals(delcategory)){
		    		Shopcategory shopcategory = shopcategoryService.get(thisId);
		    		shopcategoryService.delete(shopcategory);
		    	}else if("del2".equals(delcategory)){
		    		Shopcontent shopcontent = shopcontentService.get(thisId);
		    		shopcontentService.delete(shopcontent);
		    	}
		    	
		    	return ajaxJson("{'success':true}");
		    }
	
	public Integer getIndex() { 
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}

	public int getThisId() {
		return thisId;
	}

	public void setThisId(int thisId) {
		this.thisId = thisId;
	}

	public List getShopcategorylist() {
		return shopcategorylist;
	}

	public void setShopcategorylist(List shopcategorylist) {
		this.shopcategorylist = shopcategorylist;
	}
	
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public String getAddOrEdit() {
		return addOrEdit;
	}

	public void setAddOrEdit(String addOrEdit) {
		this.addOrEdit = addOrEdit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDelcategory() {
		return delcategory;
	}

	public void setDelcategory(String delcategory) {
		this.delcategory = delcategory;
	}

}
