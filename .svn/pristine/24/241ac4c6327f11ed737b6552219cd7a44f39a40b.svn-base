package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.wudianyi.wb.hongmao.util.StringUtils;

@Entity
@Table(name = "hm_comment")
public class Comment implements Serializable {

	/**
	 * 评价
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private int  userid;// 用户id
	private String username;// 用户名字
	private String userpic;// 用户头像
	private long createdate;// 创建时间
	private int star;// 评星
	private String content;// 评论内容
	private String pics;// 图片，可以多张，用逗号隔开
	private String orderid;// 订单id
	private int tt;// 0:评论，1：分享
	private int shopid;
	private String reply;//回复
	private long replydate;//回复时间 
	

	@Id
	@Column(length = 32, nullable = true)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpic() {
		return userpic;
	}

	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}

	public long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(long createdate) {
		this.createdate = createdate;
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
	
	@Transient
	public String[] getPicsList() {
		if (pics == null) {
			return null;
		}
		return pics.split(", ");
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	@Transient
	public String[] getPicList() {
		if (StringUtils.isEmpty(pics)) {
			return null;
		}
		return pics.split(",");
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public long getReplydate() {
		return replydate;
	}

	public void setReplydate(long replydate) {
		this.replydate = replydate;
	}

	

	
}
