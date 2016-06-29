package com.wudianyi.wb.hongmao.action.admin.json;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shopcategory;
import com.wudianyi.wb.hongmao.entity.Shopcontent;
import com.wudianyi.wb.hongmao.service.ShopcategoryService;
import com.wudianyi.wb.hongmao.service.ShopcontentService;


public class ShopcontentAction extends BaseAction{
	
	private Integer thisId;
	private String addOrEdit;
	private String name;
	private Integer parentId;
	private String pic;
	private String content;
	private String title;
	private Integer toindex;
	private int orderbyid1;
	private int orderbyid2;

	@Resource
    private ShopcontentService shopcontentService;	
	@Resource
	private ShopcategoryService shopcategoryService;
	
	public String getcontent(){
		QueryParam param = new QueryParam();
		param.add("id", thisId);
		Shopcontent shopcontent = shopcontentService.get(param, false);
		JSONObject retObject = new JSONObject();
		retObject.put("wenId", shopcontent.getId());
		retObject.put("pic", shopcontent.getPic());
		retObject.put("content", shopcontent.getContent());
		retObject.put("success", true);
		retObject.put("title", shopcontent.getTitle());
		retObject.put("toindex", shopcontent.getToindex());
		setAttribute("content", shopcontent.getContent());
		return ajaxJson(retObject.toString()); 
	}
	
	//保存或修改
	public String saveOrUpdate() {
		
		int shopid =(Integer) getSession(Const.SESSION_ADMIN_SHOPID);
		System.out.println("addOrEdit:....."+addOrEdit);
	    Shopcategory shopcategory = new Shopcategory();
		if ("edit1".equals(addOrEdit)) {
			shopcategory = shopcategoryService.get(thisId);
			shopcategory.setName(name);
			System.out.println("orderbyid1...."+orderbyid1);
			shopcategory.setOrderbyid(orderbyid1);
			shopcategoryService.update(shopcategory);
			
		}else if("edit2".equals(addOrEdit)){
			Shopcontent shopcontent = shopcontentService.get(thisId);
			shopcontent.setTitle(title);
			shopcontent.setOrderbyid(orderbyid2); 
			shopcontent.setPic(pic);
			shopcontent.setToindex(toindex);
			shopcontent.setContent(content);
			shopcontentService.update(shopcontent);
			
		}else {
			// 添加一级分类
			if ("add1".equals(addOrEdit)) {
				shopcategory.setShopid(shopid);
				shopcategory.setName(name);
				shopcategory.setOrderbyid(orderbyid1);
				shopcategoryService.save(shopcategory);
			}
			// 添加二级分类
			if ("add2".equals(addOrEdit)) {
				System.out.println("parentId:.."+parentId);
				Shopcategory shopcategory2 = shopcategoryService.get(parentId); 
				Shopcontent shopcontent = new Shopcontent();
				shopcontent.setTitle(title);
				shopcontent.setPic(pic);
				shopcontent.setShopid(shopid);
				shopcontent.setOrderbyid(orderbyid2); 
				shopcontent.setToindex(toindex);
				shopcontent.setContent(content);
				shopcontent.setShopcategory(shopcategory2);
				shopcontentService.save(shopcontent);
			}
	    }
	return ajaxJson("{'success':true}");
    }
	
	public Integer getThisId() {
		return thisId;
	}
	public void setThisId(Integer thisId) {
		this.thisId = thisId;
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
	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getToindex() {
		return toindex;
	}

	public void setToindex(Integer toindex) {
		this.toindex = toindex;
	}

	public int getOrderbyid1() {
		return orderbyid1;
	}

	public void setOrderbyid1(int orderbyid1) {
		this.orderbyid1 = orderbyid1;
	}

	public int getOrderbyid2() {
		return orderbyid2;
	}

	public void setOrderbyid2(int orderbyid2) {
		this.orderbyid2 = orderbyid2;
	}




}
