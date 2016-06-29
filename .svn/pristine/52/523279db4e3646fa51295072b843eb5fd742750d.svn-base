package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 城市区域类
 * @author rhett
 *
 */
@Entity
@Table(name = "hm_area")
public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Integer cityid;//城市Id
	private String name;//区域名字
	private int orderbyid;//越大越靠前
    
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderbyid() {
		return orderbyid;
	}

	public void setOrderbyid(int orderbyid) {
		this.orderbyid = orderbyid;
	}
	

}
