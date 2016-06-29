package com.wudianyi.wb.hongmao.dao;

import java.util.List;

import com.wudianyi.wb.hongmao.entity.User;

public interface UserDao extends BaseDao<User, Integer> {
	public List getUserWithMoney(String hql,Integer shopid, int pn, int ps);
	
	public int getTotalCount(String hql,Integer shopid);
}