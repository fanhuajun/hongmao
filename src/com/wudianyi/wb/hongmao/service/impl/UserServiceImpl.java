package com.wudianyi.wb.hongmao.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.dao.UserDao;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.service.ShopvipService;
import com.wudianyi.wb.hongmao.service.UserService;
import com.wudianyi.wb.hongmao.util.StringUtils;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements
		UserService {
	@Resource
	private UserDao userDao;
    @Resource
    private ShopvipService shopvipService;
    @Resource
    private ShopService shopService;
    
	@Resource
	public void setBaseDao(UserDao userDao) {
		super.setBaseDao(userDao);
	}

	/**
	 * @param weixinid
	 * @param uid
	 * @return
	 */
	public Integer saveOrUpdateUser(String weixinid, String uid, String shopid) {
		User user = userDao.get(new QueryParam(1).add("weixinid", weixinid),
				false);
		if (user == null) {// 如果没有这个用户，则添加一个这样的用户
			int shopidt = Integer.parseInt(shopid); 
			int totalNum = shopvipService.getTotalCount(new QueryParam()
			.add("shopid", shopidt) , false);
			user = new User(); 
			user.setCreatedate(new Date().getTime()); //添加下级会员加入时间
			Shop shop = shopService.get(shopidt);
			shop.setTotaluser(totalNum);
			     shopService.update(shop);
			
			if (!StringUtils.isEmpty(uid)) {
				user.setWeixinid(weixinid);
				// 找到上级用户
				User upUser = userDao.get(Integer.parseInt(uid));
				if (upUser != null) {
					user.setOne(upUser.getId());
					user.setTwo(upUser.getOne());
					user.setThree(upUser.getTwo());
					if (shopid != null) {
						user.setShopid(Integer.parseInt(shopid));
					}
				}

			}
			return userDao.save(user);
		}
		return user.getId();
	}

	@Override
	public List getUserWithMoney(String hql,Integer shopid, int pn, int ps) {
		// TODO Auto-generated method stub
		return userDao.getUserWithMoney(hql,shopid, pn, ps);
	}
	@Override
	public int getTotalCount(String hql,Integer shopid){
		return userDao.getTotalCount(hql,shopid);
	}
}
