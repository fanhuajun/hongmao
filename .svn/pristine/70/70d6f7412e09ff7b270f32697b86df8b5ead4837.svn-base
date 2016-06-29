package com.wudianyi.wb.hongmao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 预约
 * 
 * @author rhett
 * 
 */
@Entity
@Table(name = "hm_appointment")
public class Appointment {
	private int id;
	private int shopid;
	private String username;//预约创建人
	private long createdate;// 创建时间
	private String appointdate;// 预约时间
	private String num;// 用餐人数
	private String phone;// 电话
	private int tt;// 0:预约中，1预约成功，-1：预约失败
	private String statjson;// 状态更新的json

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

	public long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAppointdate() {
		return appointdate;
	}

	public void setAppointdate(String appointdate) {
		this.appointdate = appointdate;
	}

}
