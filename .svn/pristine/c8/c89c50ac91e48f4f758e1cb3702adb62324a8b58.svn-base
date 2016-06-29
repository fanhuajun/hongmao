package com.wudianyi.wb.hongmao.action.json;

import java.util.Date;

import javax.annotation.Resource;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.entity.Comment;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Order;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.CommentService;
import com.wudianyi.wb.hongmao.service.OrderService;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.service.UserService;
import com.wudianyi.wb.hongmao.util.StringUtils;

public class OrderAction extends BaseAction {

	private String orderid;// 前台传来的订单号
	private int star;// 前台传来的评价分数
	private String content;// 前台传来的评论
	private String pics;// 前台传来的评论图片

	@Resource
	private ShopService shopService;
	@Resource
	private UserService userService;
	@Resource
	private OrderService orderService;
	@Resource
	private CommentService commentService;

	/*
	 * 保存评价
	 */
	public String comment() {
		Order order = orderService.get(orderid);
		Integer userid = (Integer) getSession(Const.SESSION_USER_ID);
		if (order.getStat() != 2 && order.getUserid() == userid.intValue()) {
			Shop shop = shopService.get(order.getShopid());
			User user = userService.get(order.getUserid());
			Comment comment = new Comment();
			comment.setUserid(user.getId());
			comment.setUsername(user.getUserDisplayName());
			comment.setUserpic(user.getPic());
			Date date = new Date();
			comment.setCreatedate(date.getTime());
			comment.setStar(star);
			comment.setContent(content);
			comment.setPics(pics);
			comment.setOrderid(orderid);
			comment.setTt(0);
			comment.setShopid(shop.getId());
			commentService.save(comment);
			order.setStat(2);
			orderService.update(order);
		}
		return ajaxJsonSuccessMessage(null);
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

}
