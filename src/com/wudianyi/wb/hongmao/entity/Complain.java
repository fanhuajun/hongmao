package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 投诉建议
 * 
 * @author rhett
 * 
 */
@Entity
@Table(name = "hm_complain")
public class Complain implements Serializable {

	/**
	 * 投诉建议
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int shopid;//店铺id
	private String shopname;//店铺名称
	private Integer userid;//用户id
	private String username;//用户名
	private String content;//建议内容
	private int backid;//反馈填写人id
	private String backname;//反馈填写人名称
	private String feedback;//反馈内容

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getBackid() {
		return backid;
	}

	public void setBackid(int backid) {
		this.backid = backid;
	}

	public String getBackname() {
		return backname;
	}

	public void setBackname(String backname) {
		this.backname = backname;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
