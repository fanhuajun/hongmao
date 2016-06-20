package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hm_deposit")
public class Deposit implements Serializable {

	private int userid;
	private Double money;
	private long createdate;
	private int tt;// 0：申请中，1：审核通过，-1：不通过
	private String statjson;// 状态更新的json
	private String deposittype;// 提现方式：weixin:微信提现，card：银行卡提现
	private String name;// 用户名字
	private String wxname;
	private String card;// 银行卡账号
	private String phone;// 用户电话
	@Column(name = "bankname")
	private String bankName;
	private Integer shopid;// 为0代表平台的提现
	private long begintime;// 涉及的订单开始时间
	private long endtime;// 涉及的订单结束时间

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public String getStatjson() {
		return statjson;
	}

	public void setStatjson(String statjson) {
		this.statjson = statjson;
	}

	public String getDeposittype() {
		return deposittype;
	}

	public void setDeposittype(String deposittype) {
		this.deposittype = deposittype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWxname() {
		return wxname;
	}

	public void setWxname(String wxname) {
		this.wxname = wxname;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public long getBegintime() {
		return begintime;
	}

	public void setBegintime(long begintime) {
		this.begintime = begintime;
	}

	public long getEndtime() {
		return endtime;
	}

	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}

}
