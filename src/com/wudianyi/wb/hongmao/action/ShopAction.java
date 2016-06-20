package com.wudianyi.wb.hongmao.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Comment;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.News;
import com.wudianyi.wb.hongmao.entity.Shop;
import com.wudianyi.wb.hongmao.entity.ShopNews;
import com.wudianyi.wb.hongmao.entity.Shopcontent;
import com.wudianyi.wb.hongmao.entity.Shopvip;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.CommentService;
import com.wudianyi.wb.hongmao.service.NewsService;
import com.wudianyi.wb.hongmao.service.ShopNewsService;
import com.wudianyi.wb.hongmao.service.ShopService;
import com.wudianyi.wb.hongmao.service.ShopcontentService;
import com.wudianyi.wb.hongmao.service.ShopvipService;
import com.wudianyi.wb.hongmao.service.UserService;

@ParentPackage("front")
public class ShopAction extends BaseAction {
    private int contentid;
	@Resource
	private ShopService shopService;
	@Resource
	private ShopvipService shopvipService;
	@Resource
	private NewsService newsService;
	@Resource
	private ShopcontentService shopcontentService;
	@Resource
	private CommentService commentService;
	@Resource
	private UserService userService;
	@Override
	public String execute() {
		Object userobj = getSession(Const.SESSION_USER_ID);
		Integer id = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		if (userobj != null) {
			Integer userid = (Integer) userobj;
			Shopvip shopvip = shopvipService.get(userid + "z" + id);
			User user = userService.get(userid);
			setAttribute("shopvip", shopvip);
			setAttribute("user", user);
		}
		Shop shop = shopService.get(id);
		if (shop == null)
			shop = new Shop();
		setAttribute("shop", shop);
		List<News> lastNews = newsService.getList(
				new QueryParam(1).add("shopid", id), 0, 1, "createdate",
				"desc", false);
		setAttribute("lastNews", lastNews);
		List<Shopcontent> contens = shopcontentService.getList(
				new QueryParam(2).add("shopid", id).add("toindex", 1), 0, 0,
				"shopcategory.id", "desc", false);
		setAttribute("contents", contens);
		System.err.println("contens.size=" + contens.size());
		List<Comment> comments = commentService.getList(
				new QueryParam(1).add("shopid", id), 0, 1, "createdate",
				"desc", false);
		int commentTotal = commentService.getTotalCount(new QueryParam(1).add("shopid", id), false);
		setAttribute("comments", comments);
		setAttribute("commentTotal", commentTotal);
		if (shop.getSubshopid() != null) {
			List<Shop> otherShops = shopService.getList(
					new QueryParam(1).add("subshopid", shop.getSubshopid()), 0,
					3, null, null, false);
			setAttribute("otherShops", otherShops);
		}

		return "shop";
	}

	/*
	 * 商家搜索
	 */
	public String shopsearch() {

		return "search";
	}
	
	/*
	 * 商家故事、内容详情
	 * */
	public String shopStory(){
		Integer id = (Integer) getSession(Const.SESSION_FRONT_SHOPID);
		Shop shop = shopService.get(id);
		if (shop == null)
			shop = new Shop();
		setAttribute("shop", shop);
		return "shopStory";
	}
	
	public String shopcontent(){
		Shopcontent shopcontent = shopcontentService.get(contentid);
		setAttribute("content", shopcontent);;
		return "shopcontent";
	}

	public static void main(String[] args) {
		System.out.println(new Date().getTime());
	}

	public int getContentid() {
		return contentid;
	}

	public void setContentid(int contentid) {
		this.contentid = contentid;
	}

	
}
