package com.wudianyi.wb.hongmao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hm_shop")
public class Shop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;// 店铺名字
	private String cover;// 店铺封面
	private String address;// 店铺地址
	private String cuisine;// 菜系(例 川菜 湘菜 粤菜)
	private Integer consumption;// 人均消费，可以为空
	private Integer shoptypeone;// 第一级分类
	private String shoptypeonename;// 第一级分类名字
	private Integer shoptypetwo;// 第二级分类
	private String shoptypetwoname;// 第二级分类名字
	private Double point;// 平均分，最高5分，保存两位小数
	private String backjson;// 返佣
	private Long lastbackbegin1;// 最新的返佣设置开始时间
	private Long lastbackend1;// 最新的返佣设置结束时间
	private Double highestback1;// 1级最高返佣
	private Double lowestback1;// 1级最低返佣
	private Long lastbackbegin2;// 最新的返佣设置开始时间
	private Long lastbackend2;// 最新的返佣设置结束时间
	private Double highestback2;// 2级最高返佣
	private Double lowestback2;// 2级最低返佣

	private Long lastbackbegin3;// 最新的返佣设置开始时间
	private Long lastbackend3;// 最新的返佣设置结束时间
	private Double highestback3;// 2级最高返佣
	private Double lowestback3;// 2级最低返佣

	private Double longitude;// 经度
	private Double latitude;// 维度
	private Integer circleid;// 商圈ID
	private String circlename;// 商圈名字
	private Double discount;// 最新的消费折扣
	private Integer cityid;// 城市ID
	private Integer areaid;// 区域ID
	private Integer subshopid;// 总店id
	private String content;// 简介
	private String contentpic;// 简介配图
	private String thetime;// 营业时间
	private String phone;// 店铺电话
	private Integer commentcount;// 评价总数量
	private Integer sharecount;// 分享总数量
	private Integer cpi;// consumption per person 人均消费
	private String password;// 密码
	private Long createdate;// 创建时间
	private String tel;// 商店显示电话
	private String appid;
	@Column(name = "wxpayno")
	private String wxPayno;
	@Column(name = "wxpaysecret")
	private String wxPaySecrect; // 微信支付密码
	@Column(name = "appkey")
	private String appKey;
	private int isadmin;// 是否总管理员
	private int totaluser;// 总会员数量
	private double money = 0.00;
	private Integer agentid;// 上级代理商ID
	private long overduetime;// 到期时间

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getConsumption() {
		return consumption;
	}

	public void setConsumption(Integer consumption) {
		this.consumption = consumption;
	}

	public Integer getShoptypeone() {
		return shoptypeone;
	}

	public void setShoptypeone(Integer shoptypeone) {
		this.shoptypeone = shoptypeone;
	}

	public String getShoptypeonename() {
		return shoptypeonename;
	}

	public void setShoptypeonename(String shoptypeonename) {
		this.shoptypeonename = shoptypeonename;
	}

	public Integer getShoptypetwo() {
		return shoptypetwo;
	}

	public void setShoptypetwo(Integer shoptypetwo) {
		this.shoptypetwo = shoptypetwo;
	}

	public String getShoptypetwoname() {
		return shoptypetwoname;
	}

	public void setShoptypetwoname(String shoptypetwoname) {
		this.shoptypetwoname = shoptypetwoname;
	}

	public String getBackjson() {
		return backjson;
	}

	public void setBackjson(String backjson) {
		this.backjson = backjson;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getCircleid() {
		return circleid;
	}

	public void setCircleid(Integer circleid) {
		this.circleid = circleid;
	}

	public String getCirclename() {
		return circlename;
	}

	public void setCirclename(String circlename) {
		this.circlename = circlename;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public Integer getSubshopid() {
		return subshopid;
	}

	public void setSubshopid(Integer subshopid) {
		this.subshopid = subshopid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThetime() {
		return thetime;
	}

	public void setThetime(String thetime) {
		this.thetime = thetime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Long createdate) {
		this.createdate = createdate;
	}

	public String getContentpic() {
		return contentpic;
	}

	public void setContentpic(String contentpic) {
		this.contentpic = contentpic;
	}

	public Integer getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}

	public Integer getSharecount() {
		return sharecount;
	}

	public void setSharecount(Integer sharecount) {
		this.sharecount = sharecount;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public Long getLastbackbegin1() {
		return lastbackbegin1;
	}

	public void setLastbackbegin1(Long lastbackbegin1) {
		this.lastbackbegin1 = lastbackbegin1;
	}

	public Long getLastbackend1() {
		return lastbackend1;
	}

	public void setLastbackend1(Long lastbackend1) {
		this.lastbackend1 = lastbackend1;
	}

	public Double getHighestback1() {
		return highestback1;
	}

	public void setHighestback1(Double highestback1) {
		this.highestback1 = highestback1;
	}

	public Double getLowestback1() {
		return lowestback1;
	}

	public void setLowestback1(Double lowestback1) {
		this.lowestback1 = lowestback1;
	}

	public Long getLastbackbegin2() {
		return lastbackbegin2;
	}

	public void setLastbackbegin2(Long lastbackbegin2) {
		this.lastbackbegin2 = lastbackbegin2;
	}

	public Long getLastbackend2() {
		return lastbackend2;
	}

	public void setLastbackend2(Long lastbackend2) {
		this.lastbackend2 = lastbackend2;
	}

	public Double getHighestback2() {
		return highestback2;
	}

	public void setHighestback2(Double highestback2) {
		this.highestback2 = highestback2;
	}

	public Double getLowestback2() {
		return lowestback2;
	}

	public void setLowestback2(Double lowestback2) {
		this.lowestback2 = lowestback2;
	}

	public Integer getCpi() {
		return cpi;
	}

	public void setCpi(Integer cpi) {
		this.cpi = cpi;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getWxPaySecrect() {
		return wxPaySecrect;
	}

	public void setWxPaySecrect(String wxPaySecrect) {
		this.wxPaySecrect = wxPaySecrect;
	}

	public String getWxPayno() {
		return wxPayno;
	}

	public void setWxPayno(String wxPayno) {
		this.wxPayno = wxPayno;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public int getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}

	public int getTotaluser() {
		return totaluser;
	}

	public void setTotaluser(int totaluser) {
		this.totaluser = totaluser;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	public long getOverduetime() {
		return overduetime;
	}

	public void setOverduetime(long overduetime) {
		this.overduetime = overduetime;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getLastbackbegin3() {
		return lastbackbegin3;
	}

	public void setLastbackbegin3(Long lastbackbegin3) {
		this.lastbackbegin3 = lastbackbegin3;
	}

	public Long getLastbackend3() {
		return lastbackend3;
	}

	public void setLastbackend3(Long lastbackend3) {
		this.lastbackend3 = lastbackend3;
	}

	public Double getHighestback3() {
		return highestback3;
	}

	public void setHighestback3(Double highestback3) {
		this.highestback3 = highestback3;
	}

	public Double getLowestback3() {
		return lowestback3;
	}

	public void setLowestback3(Double lowestback3) {
		this.lowestback3 = lowestback3;
	}

}
