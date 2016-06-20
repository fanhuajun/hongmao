package com.wudianyi.wb.hongmao.service.impl;

import javax.annotation.Resource;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.ShopvipDao;
import com.wudianyi.wb.hongmao.entity.Shopvip;
import com.wudianyi.wb.hongmao.service.ShopvipService;
import com.wudianyi.wb.hongmao.util.StringUtils;

@Service
public class ShopvipServiceImpl extends BaseServiceImpl<Shopvip, String>
		implements ShopvipService {

	@Resource
	public void setBaseDao(ShopvipDao shopvipDao) {
		super.setBaseDao(shopvipDao);
	}

	@Override
	public Shopvip saveOrget(Integer userid, Integer shopid) {
		System.err.println(userid + "z" + shopid+"=====================");
		Shopvip shopvip = this.get(userid + "z" + shopid);
		System.err.println("shopvip===="+shopvip);
		if (shopvip == null) {
			shopvip = new Shopvip(userid, shopid);
			this.save(shopvip);
		}
		return shopvip;
	}

}
