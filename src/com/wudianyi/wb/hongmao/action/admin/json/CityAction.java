package com.wudianyi.wb.hongmao.action.admin.json;


import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Area;
import com.wudianyi.wb.hongmao.entity.City;
import com.wudianyi.wb.hongmao.service.AreaService;
import com.wudianyi.wb.hongmao.service.CityService;
import com.wudianyi.wb.hongmao.service.impl.AreaServiceImpl;

public class CityAction extends BaseAction {
	
	private String addOrEdit;
	private int thisId;
	private String name;
	private Integer parentId;
	private String delcategory;

	@Resource
    private CityService cityService;
	@Resource
	private AreaService areaService;
	
	// 添加或更新分类信息
	public String saveOrUpdate() {
			City city = new City();
			Area area = new Area();
			if ("edit1".equals(addOrEdit)) {
				city = cityService.get(thisId);
				city.setName(name);
				cityService.update(city);
				
			}else if("edit2".equals(addOrEdit)){
				area = areaService.get(thisId);
				area.setName(name);
				areaService.update(area);
				
			}else {
				// 添加一级分类
				if ("add1".equals(addOrEdit)) {
					city.setName(name);
					cityService.save(city);
				}
				// 添加二级分类
				if ("add2".equals(addOrEdit)) {
					area.setCityid(parentId);
					area.setName(name);
					areaService.save(area);
				}
		}
		return ajaxJson("{'success':true}");
	}
	 
	    //删除分类
	    public String delete(){
	    	if("del1".equals(delcategory)){
	    		City city = cityService.get(thisId);
	    		cityService.delete(city);
	    	}else if("del2".equals(delcategory)){
	    		Area area = areaService.get(thisId);
	    		areaService.delete(area);
	    	}
	    	
	    	return ajaxJson("{'success':true}");
	    }
		
		public String getAddOrEdit() {
			return addOrEdit;
		}


		public void setAddOrEdit(String addOrEdit) {
			this.addOrEdit = addOrEdit;
		}
		
		public Integer getParentId() {
			return parentId;
		}

		public void setParentId(Integer parentId) {
			this.parentId = parentId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getThisId() {
			return thisId;
		}
		public void setThisId(int thisId) {
			this.thisId = thisId;
		}
		
		public String getDelcategory() {
			return delcategory;
		}
		public void setDelcategory(String delcategory) {
			this.delcategory = delcategory;
		}
		

	
   
}
