package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 店铺会员类 记录用户是不是属于某一家商店的会员
 * 
 * @author rhett
 * 
 */
@Entity
@Table(name = "hm_shopvip")
public class Shopvip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;// id，由userid-shopid组成
	private Integer shopid;// 商店id
	private Integer userid;// 用户id
	private long createdate;// 创建时间
	private String prepayjson;// 预付款金额
	private double backmoney;// 总返佣金额
	private Double money;// 总预付款金额

	public Shopvip() {
	}

	public Shopvip( Integer userid,Integer shopid) {
		super();
		this.id = userid + "z" + shopid;
		this.shopid = shopid;
		this.userid = userid;
		this.createdate = new Date().getTime();
		this.prepayjson = "[]";
		this.backmoney = 0.00;
		this.money = 0.00;
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}

	public String getPrepayjson() {
		return prepayjson;
	}

	public void setPrepayjson(String prepayjson) {
		this.prepayjson = prepayjson;
	}

	public double getBackmoney() {
		return backmoney;
	}

	public void setBackmoney(double backmoney) {
		this.backmoney = backmoney;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
