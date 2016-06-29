package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hm_shopcontent")
public class Shopcontent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int shopid;
	private Shopcategory shopcategory;
	private int orderbyid;// 越大的越靠前
	private String content;// 介绍
	private String pic;// 主图
	private int toindex;// 是否在商家主页显示0：否，1是
	private String title;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shopcategoryid")
	public Shopcategory getShopcategory() {
		return shopcategory;
	}

	public void setShopcategory(Shopcategory shopcategory) {
		this.shopcategory = shopcategory;
	}

	public int getOrderbyid() {
		return orderbyid;
	}

	public void setOrderbyid(int orderbyid) {
		this.orderbyid = orderbyid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getToindex() {
		return toindex;
	}

	public void setToindex(int toindex) {
		this.toindex = toindex;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
