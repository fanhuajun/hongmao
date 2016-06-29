package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wudianyi.wb.hongmao.util.StringUtils;

@Entity
@Table(name = "hm_user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String phone;
	private String password;// 登陆密码
	private String weixinid;
	private String pic;
	private double money;// 钱包余额
	private Integer one;// 我的上级用户
	private Integer two;// 我的上上级用户
	private Integer three;// 我的上上上级用户
	private String upstr;// 等级关系，用逗号隔开 oneid,twoid(上级用户id,上上级用户id)
	private double backmoney;// 我的总收益
	private double wdmoney;// 可提现金额
	private long createdate;
	@Column(name = "cityid")
	private Integer cityId;// 城市ID
	private Integer shopid;// 商店id
	private Integer rank;// 在商店中的消费排名(如果为空，则是最后一名，新加入的，一天统计一次)
	private Long lastdeposittime;// 上次提现时间

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Integer getOne() {
		return one;
	}

	public void setOne(Integer one) {
		this.one = one;
	}

	public Integer getTwo() {
		return two;
	}

	public void setTwo(Integer two) {
		this.two = two;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBackmoney() {
		return backmoney;
	}

	public void setBackmoney(double backmoney) {
		this.backmoney = backmoney;
	}

	public long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}

	/**
	 * 用户展示的名字
	 * 
	 * @return
	 */
	@Transient
	public String getUserDisplayName() {
		if (!StringUtils.isEmpty(name)) {
			return name;
		}
		if (!StringUtils.isEmpty(phone)) {
			if (phone.length() == 11) {
				return phone.substring(0, 3) + "****" + phone.substring(8, 11);
			}
		}
		return "红猫用户" + id;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public String getUpstr() {
		return upstr;
	}

	public void setUpstr(String upstr) {
		this.upstr = upstr;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public double getWdmoney() {
		return wdmoney;
	}

	public void setWdmoney(double wdmoney) {
		this.wdmoney = wdmoney;
	}

	public Integer getThree() {
		return three;
	}

	public void setThree(Integer three) {
		this.three = three;
	}

	public Long getLastdeposittime() {
		return lastdeposittime;
	}

	public void setLastdeposittime(Long lastdeposittime) {
		this.lastdeposittime = lastdeposittime;
	}

}
