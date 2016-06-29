package com.wudianyi.wb.hongmao.action.agent.json;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.service.ShopService;

public class ShopAction extends BaseAction {

	@Resource
	private ShopService shopService;
	private Integer shopid;
	private String name;// 店铺名字
	private String cover;// 店铺封面
	private String address;// 店铺地址
	private Integer consumption;// 人均消费，可以为空
	private String backjson;// 返佣
	private Long lastbackbegin1;// 最新的返佣设置开始时间
	private Long lastbackend1;// 最新的返佣设置结束时间
	private Double highestback1;// 最高返佣
	private Double lowestback1;// 最低返佣
	private Long lastbackbegin2;// 最新的返佣设置开始时间
	private Long lastbackend2;// 最新的返佣设置结束时间
	private Double highestback2;// 最高返佣
	private Double lowestback2;// 最低返佣
	private Double discount;// 最新的消费折扣
	private String thetime;// 营业时间
	private String phone;// 店铺电话
	private int commentcount;// 评价总数量
	private int sharecount;// 分享总数量

	private Long createdate;// 创建时间
	private String passwordnow;// 当前密码
	private String password2;// 新密码

	public String list() {
		Integer agentid = (Integer) getSession(Const.SESSION_ADMIN_AGENTID);
		QueryParam params = new QueryParam(1).add("agentid", agentid);
		list = shopService
				.getLikeList("phone", keyword, null, params, (pn - 1)
						* Const.BACK_PAGE_SIZE, Const.BACK_PAGE_SIZE, null,
						null, false);
		System.err.println("list:" + list);
		return LIST;
	}

	public String totalNum() {
		Integer agentid = (Integer) getSession(Const.SESSION_ADMIN_AGENTID);
		QueryParam params = new QueryParam(1).add("agentid", agentid);
		tn = shopService.getLikeTotalCount("phone", keyword, null, params,
				false);

		System.out.println("tn========" + tn);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
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

	public String getBackjson() {
		return backjson;
	}

	public void setBackjson(String backjson) {
		this.backjson = backjson;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
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

	public int getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}

	public int getSharecount() {
		return sharecount;
	}

	public void setSharecount(int sharecount) {
		this.sharecount = sharecount;
	}

	public Long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Long createdate) {
		this.createdate = createdate;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
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

	public String getPasswordnow() {
		return passwordnow;
	}

	public void setPasswordnow(String passwordnow) {
		this.passwordnow = passwordnow;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
