package com.wudianyi.wb.hongmao.action.admin.json;

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

	private Long lastbackbegin3;// 最新的返佣设置开始时间
	private Long lastbackend3;// 最新的返佣设置结束时间
	private Double highestback3;// 最高返佣
	private Double lowestback3;// 最低返佣

	private Double discount;// 最新的消费折扣
	private String cuisine;
	private String thetime;// 营业时间
	private String phone;// 店铺电话
	private int commentcount;// 评价总数量
	private int sharecount;// 分享总数量

	private Long createdate;// 创建时间
	private String passwordnow;// 当前密码
	private String password2;// 新密码

	public String list() {

		QueryParam params = new QueryParam();
		System.err.println("keyword:" + keyword);
		list = shopService
				.getLikeList("phone", keyword, null, params, (pn - 1)
						* Const.BACK_PAGE_SIZE, Const.BACK_PAGE_SIZE, null,
						null, false);
		System.err.println("list:" + list);
		return LIST;
	}

	public String totalNum() {
		System.out.println("keyword========" + keyword);
		tn = shopService.getLikeTotalCount("phone", keyword, null, null, false);

		System.out.println("tn========" + tn);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\""
				+ Const.BACK_PAGE_SIZE + "\"}");
	}

	public String shopedit() {

		shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);

		Shop shop = shopService.get(shopid);
		System.out.println("address:...." + address);
		shop.setAddress(address);
		shop.setBackjson(backjson);
		shop.setCommentcount(commentcount);
		shop.setSharecount(sharecount);
		shop.setConsumption(consumption);
		shop.setDiscount(discount);
		shop.setCuisine(cuisine);
		shop.setCover(cover);
		shop.setHighestback1(highestback1/100);
		shop.setLastbackbegin1(lastbackbegin1);
		shop.setLastbackend1(lastbackend1);
		shop.setLowestback1(lowestback1/100);
		shop.setHighestback2(highestback2/100);
		shop.setLastbackbegin2(lastbackbegin2);
		shop.setLastbackend2(lastbackend2);
		shop.setLowestback2(lowestback2/100);

		shop.setHighestback3(highestback3/100);
		shop.setLastbackbegin3(lastbackbegin3);
		shop.setLastbackend3(lastbackend3);
		shop.setLowestback3(lowestback3/100);

		shop.setName(name);
		shop.setPhone(phone);
		shop.setThetime(thetime);
		shopService.update(shop);
		return ajaxJson("{\"success\":true}");
	}

	public String alterpass() {
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		Integer shopid = (Integer) getSession(Const.SESSION_ADMIN_SHOPID);

		Shop shop = shopService.get(
				new QueryParam(2).add("id", shopid).add("password",
						md5PasswordEncoder.encodePassword(passwordnow, null)),
				false);
		if (shop == null) {
			return ajaxJson("{'error':1}");
		}

		Shop shop2 = shopService
				.get(new QueryParam(1).add("id", shopid), false);
		shop2.setPassword(md5PasswordEncoder.encodePassword(password2, null));
		shopService.update(shop2);
		return ajaxJson("{'success':true}");
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

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
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
