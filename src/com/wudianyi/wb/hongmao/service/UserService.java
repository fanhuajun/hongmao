package com.wudianyi.wb.hongmao.service;

import java.util.List;

import com.wudianyi.wb.hongmao.entity.User;

public interface UserService extends BaseService<User, Integer> {
	/**
	 * 根据微信ID插入或者添加一个新的用户，如果该weixinid已经有注册用户了，则不做操作
	 * 
	 * @param weixinid
	 *            微信id
	 * @param uid
	 *            上级用户id
	 * @return
	 */
	public Integer saveOrUpdateUser(String weixinid, String uid,String shopid);

	public List getUserWithMoney(String hql,Integer shopid, int pn, int ps);
	
	public int getTotalCount(String hql,Integer shopid);
}
