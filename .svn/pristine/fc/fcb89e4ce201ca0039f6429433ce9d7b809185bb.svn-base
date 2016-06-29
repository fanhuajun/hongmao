package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hm_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String ordersn;// 订单编号
	private int userid;// 用户id
	private int stat;// 支付状态 0：未支付，1：已支付 2：已评价
	private int shopid;// 商铺id
	private String shopname;// 商铺名字
	private Double shopstar;// 商户评星
	private Long paydate;// 支付时间
	private Double sourcemoney;// 原价
	private Double money;// 实付，用微信支付付了多少钱
	private Double allpaymoney;// 实际上支付了多少，包括预付款的
	private Double shopmoney;// 从商户预存中消耗的金额
	private String consumeJson;// 用于保存用户具体的消费信息 [{id:'',money:''},{},..]
	private Integer oneuserid;// 1级用户id
	private Integer twouserid;// 2级用户id
	private Integer threeuserid;// 3级用户id
	private Double onebackmoney;// 返给1级的金额
	private Double twobackmoney;// 返给2级的金额
	private Double threebackmoney;// 返给3级的金额
	private Integer onerank;// 第1名排名情况
	private Integer tworank;// 第2级排名情况
	private Integer threerank;// 第3级排名情况
	private String username;
	private String phone;//用户电话
	private String note;//用户下单时留言

	// @Column(length = 32, nullable = true)
	// @GeneratedValue(generator = "uuid")
	// @GenericGenerator(name = "uuid", strategy = "uuid")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrdersn() {
		return ordersn;
	}

	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public Double getShopstar() {
		return shopstar;
	}

	public void setShopstar(Double shopstar) {
		this.shopstar = shopstar;
	}

	public Long getPaydate() {
		return paydate;
	}

	public void setPaydate(Long paydate) {
		this.paydate = paydate;
	}

	public Double getSourcemoney() {
		return sourcemoney;
	}

	public void setSourcemoney(Double sourcemoney) {
		this.sourcemoney = sourcemoney;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getShopmoney() {
		return shopmoney;
	}

	public void setShopmoney(Double shopmoney) {
		this.shopmoney = shopmoney;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getConsumeJson() {
		return consumeJson;
	}

	public void setConsumeJson(String consumeJson) {
		this.consumeJson = consumeJson;
	}

	public Double getOnebackmoney() {
		return onebackmoney;
	}

	public void setOnebackmoney(Double onebackmoney) {
		this.onebackmoney = onebackmoney;
	}

	public Double getTwobackmoney() {
		return twobackmoney;
	}

	public void setTwobackmoney(Double twobackmoney) {
		this.twobackmoney = twobackmoney;
	}

	public Integer getOneuserid() {
		return oneuserid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setOneuserid(Integer oneuserid) {
		this.oneuserid = oneuserid;
	}

	public Integer getTwouserid() {
		return twouserid;
	}

	public void setTwouserid(Integer twouserid) {
		this.twouserid = twouserid;
	}

	public int getOnerank() {
		return onerank;
	}

	public void setOnerank(int onerank) {
		this.onerank = onerank;
	}

	public Integer getTworank() {
		return tworank;
	}

	public void setTworank(Integer tworank) {
		this.tworank = tworank;
	}

	public void setOnerank(Integer onerank) {
		this.onerank = onerank;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getThreeuserid() {
		return threeuserid;
	}

	public void setThreeuserid(Integer threeuserid) {
		this.threeuserid = threeuserid;
	}

	public Double getThreebackmoney() {
		return threebackmoney;
	}

	public void setThreebackmoney(Double threebackmoney) {
		this.threebackmoney = threebackmoney;
	}

	public Integer getThreerank() {
		return threerank;
	}

	public void setThreerank(Integer threerank) {
		this.threerank = threerank;
	}

	public Double getAllpaymoney() {
		return allpaymoney;
	}

	public void setAllpaymoney(Double allpaymoney) {
		this.allpaymoney = allpaymoney;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
