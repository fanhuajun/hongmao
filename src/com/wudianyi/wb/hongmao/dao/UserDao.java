package com.wudianyi.wb.hongmao.dao;

import java.util.List;

import com.wudianyi.wb.hongmao.entity.User;

public interface UserDao extends BaseDao<User, Integer> {
	public List getUserWithMoney(Integer shopid, int pn, int ps);
}