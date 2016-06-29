package com.wudianyi.wb.hongmao.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Prepaylog;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.entity.Shopvip;
import com.wudianyi.wb.hongmao.service.PrepaylogService;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.service.ShopvipService;
import com.wudianyi.wb.hongmao.util.StringUtils;
import com.wudianyi.wb.hongmao.vo.PrepayVo;

@ParentPackage("user")
public class PrepaylogAction extends BaseAction{

	@Resource
	private PrepaylogService prepaylogService;
	@Resource
	private ShopvipService shopvipService;
	@Resource
	private ShopService shopService;
	
	private String shopvipid;//shopvip的id
	
	/*
	 *   我的预付 （个人所有的预存商店列表）
	 */
	public String list(){
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		QueryParam param = new QueryParam(1);
		param.add("userid", userid);
		list = shopvipService.getList(param, 0, 0, "createdate", "desc", false);
		if(list != null){
			List<Shop> shoplist = new ArrayList<Shop>();
			List<Prepaylog> prelist = new ArrayList<Prepaylog>();
			
			for (int i = 0; i < list.size(); i++) {
				Shopvip obj=( Shopvip)list.get(i);
				 shoplist.add(shopService.get(obj.getShopid()));//获取shop信息 放进shoplist
			} 
			setAttribute("shoplist", shoplist);
			
			
			QueryParam param2 = new QueryParam(2);
			param2.add("userid",userid ).add("tt",0);
			prelist = prepaylogService.getList(param2, 0, 2, "createdate", "desc", false);
			
			setAttribute("prelist", prelist);
			
			
			
		}
		return LIST;
		
	}
	
	/*
	 * 预付明细
	 */
	public String detail(){
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		Integer shopid = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		QueryParam param = new QueryParam(3);
		param.add("userid", userid).add("shopid", shopid).add("tt!", -2);
		list = prepaylogService.getList(param, 0, 0, "createdate", "desc", false);
		Shop shop = shopService.get(shopid);
		setAttribute("shop", shop);
		shopvipid = userid + "z" + shopid;
		Shopvip shopvip = shopvipService.get(shopvipid);
		if(shopvip!=null) {
			
		
			setAttribute("shopvip", shopvip);
			
			
			String prepayjson = shopvip.getPrepayjson();
			if(!StringUtils.isEmpty(prepayjson)) {
				JSONArray ary = JSONArray.fromObject(prepayjson);
				List<PrepayVo> prepayList = JSONArray.toList(ary, PrepayVo.class);
				setAttribute("prepayList", prepayList);
			}
		}
		return "detail";
	}


	public String getShopvipid() {
		return shopvipid;
	}
	public void setShopvipid(String shopvipid) {
		this.shopvipid = shopvipid;
	}
	
	
	
	
	
}
