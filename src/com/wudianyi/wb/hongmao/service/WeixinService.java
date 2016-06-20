package com.wudianyi.wb.hongmao.service;

public interface WeixinService {

	public String getAccessToken(String appId, String appSecret)
			throws Exception;

	public String getTicket(String appId, String appSecret) throws Exception;
}
