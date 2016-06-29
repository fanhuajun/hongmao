package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 预付款明细记录
 * 
 * @author rhett
 * 
 */
@Entity
@Table(name = "hm_prepaylog")
public class Prepaylog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private int userid;
	private int isin;// 进账还是出账0出，1进账
	private Double money;// 涉及的金额
	private int tt;// 类别: -2待充值,0充值成功，-1消费,1返佣,2申请提现,3提现成功,4提现失败
	private long createdate;// 时间
	private Integer shopid;// 商家的id 如果是平台的进账则为空
	private Double discount;// 折扣
	private String linkid;// 消费或提现时用来标记其对应的充值记录
	private Double restmoney;// 充值的话(tt=0)，用剩多少钱,如果tt=1的话（为用户消费的金额）
	@Column(name = "displayorder")
	private Integer displayOrder;
	private Integer depositid;
	private String attach;// 附加值

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

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public String getLinkid() {
		return linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}

	public int getIsin() {
		return isin;
	}

	public void setIsin(int isin) {
		this.isin = isin;
	}

	public Double getRestmoney() {
		return restmoney;
	}

	public void setRestmoney(Double restmoney) {
		this.restmoney = restmoney;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Integer getDepositid() {
		return depositid;
	}

	public void setDepositid(Integer depositid) {
		this.depositid = depositid;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

}
