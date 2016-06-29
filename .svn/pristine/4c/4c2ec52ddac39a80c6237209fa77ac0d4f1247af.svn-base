package com.wudianyi.wb.hongmao.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.service.CacheService;
import com.wudianyi.wb.hongmao.service.WxmenuService;
import com.wudianyi.wb.hongmao.util.WxMenuUtils;

@Service
public class WxmenuServiceImpl implements WxmenuService {

	@Resource
	private CacheService cacheService;

	@Override
	public String getAccessToken(String appId, String appSecret)
			throws Exception {
		if (cacheService.getData("accessToken_" + appId) == null) {
			String token = WxMenuUtils.getAccessToken(appId, appSecret);
			cacheService.setData("accessToken_" + appId, token, 2000);
			return token;
		} else {
			return (String) cacheService.getData("accessToken_" + appId);
		}
	}

	@Override
	public String getTicket(String appId, String appSecret) throws Exception {
		if (cacheService.getData("jsapiTicket_" + appId) == null) {
			String token = getAccessToken(appId, appSecret);
			String tick = WxMenuUtils.getJsapiTicket(token);
			cacheService.setData("jsapiTicket_" + appId, tick, 3600);
			return token;
		} else {
			return (String) cacheService.getData("jsapiTicket_" + appId);
		}
	}

}
