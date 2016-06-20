package com.wudianyi.wb.hongmao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hm_shopcategory")
public class Shopcategory {
	private int id;
	private Integer shopid;// 店铺id
	private String name;// 分类名字
	private int orderbyid;// 越大越靠前

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderbyid() {
		return orderbyid;
	}

	public void setOrderbyid(int orderbyid) {
		this.orderbyid = orderbyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
}
