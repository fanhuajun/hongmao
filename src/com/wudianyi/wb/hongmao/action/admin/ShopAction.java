package com.wudianyi.wb.hongmao.action.admin;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.tuckey.web.filters.urlrewrite.SetAttribute;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.CommentService;
import com.wudianyi.wb.hongmao.service.ShopService;

@ParentPackage("admin")
public class ShopAction extends BaseAction{
	@Resource
	private ShopService shopService;
	@Resource
	private CommentService commentService;
	private Shop shop;

	public String list(){
		
		return LIST;
	}
	
	public String alterpass(){
		
		return "alterpass";
	}
    
	public String detail (){
		Integer shopid = (Integer)getSession(Const.SESSION_ADMIN_SHOPID);
		shop = shopService.get(shopid);
		return "detail";
	}
    public String edit (){
    	Integer shopid = (Integer)getSession(Const.SESSION_ADMIN_SHOPID);
    	shop = shopService.get(shopid);
    	int commentTotal = commentService.getTotalCount(null, false);
    	setAttribute("commentTotal", commentTotal);
    	setAttribute("shop", shop);
    	return "edit";
    }
    
    public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}