package com.wudianyi.wb.hongmao.action.admin.json;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.entity.Deposit;
import com.wudianyi.wb.hongmao.entity.Prepaylog;
import com.wudianyi.wb.hongmao.entity.Shopvip;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.DepositService;
import com.wudianyi.wb.hongmao.service.PrepaylogService;
import com.wudianyi.wb.hongmao.service.ShopvipService;
import com.wudianyi.wb.hongmao.service.UserService;

public class DepositAction extends BaseAction {
	
	
	private int id;
	private Integer stat;
	
	@Resource
    private DepositService depositService;	
	@Resource
	private UserService userService;
	@Resource
	private PrepaylogService prepaylogService;
	@Resource
	private ShopvipService shopvipService;
	
    public String list(){
    	Integer shopid = (Integer)getSession(Const.SESSION_ADMIN_SHOPID);
    	System.out.println("shopid===" + shopid);
    	System.out.println("stat===" + stat);

		QueryParam params = new QueryParam().add("shopid", shopid);
		if(stat!=null) {
			params.add("tt", stat);
		}
		list = depositService.getList(params, (pn-1)*Const.BACK_PAGE_SIZE, Const.BACK_PAGE_SIZE, "createdate", "desc", false);
		return LIST;
	}
    
    public String totalNum() {
    	Integer shopid = (Integer)getSession(Const.SESSION_ADMIN_SHOPID);
    	QueryParam params = new QueryParam().add("shopid", shopid);
		if(stat!=null) {
			params.add("tt", stat);
		}
    	tn = depositService.getTotalCount(params, false);
		
					System.out.println("tn========" + tn);
		return ajaxJson("{\"total\":\"" + tn + "\",\"size\":\"" + Const.BACK_PAGE_SIZE + "\"}");
	}
    
    public String statchange(){
    	Deposit deposit = depositService.get(id);
    	Prepaylog prepay;
    	//如果提现通过，将提现记录改为提现成功
    	if(stat==1) {
    		QueryParam params = new QueryParam().add("depositid", deposit.getId());
			List<Prepaylog> prepayList = prepaylogService.getList(params, 0, 0, null, null, false);
			for (Prepaylog prepaylog : prepayList) {
				prepaylog.setTt(3);
				prepaylogService.update(prepaylog);
			}
    		
    	//如果提现被拒绝，则退钱
    	}else {
    		//如果是平台提现，则直接返回给用户账号，并新增流水记录
    		if(deposit.getShopid()==0) {
    			User user = userService.get(deposit.getUserid());
    			user.setMoney(user.getMoney() + deposit.getMoney());
    			userService.update(user);
    			
    			prepay = new Prepaylog();
    			prepay.setCreatedate(new Date().getTime());
    			prepay.setIsin(1);
    			prepay.setMoney(deposit.getMoney());
    			prepay.setTt(4);
    			prepay.setUserid(user.getId());
    			prepaylogService.save(prepay);
    		//如果是商家提现，就根据当初具体的扣取情况去返回
    		}else {
    			QueryParam params = new QueryParam().add("depositid", deposit.getId());
    			List<Prepaylog> prepayList = prepaylogService.getList(params, 0, 0, null, null, false);
    			Prepaylog newLog;
    			Prepaylog origLog;
    			List<Prepaylog> indexList;
    			for (Prepaylog prepaylog : prepayList) {
    				//将原充值记录的余额补上
    				origLog = prepaylogService.get(prepaylog.getLinkid());
    				origLog.setRestmoney(origLog.getRestmoney() + prepaylog.getMoney());
    				prepaylogService.update(origLog);
    				
    				//新增一条流水记录
    				newLog = new Prepaylog();
    				newLog.setCreatedate(new Date().getTime());
    				newLog.setDepositid(deposit.getId());
    				newLog.setDiscount(prepaylog.getDiscount());
    				newLog.setIsin(1);
    				newLog.setLinkid(prepaylog.getLinkid());
    				newLog.setMoney(prepaylog.getMoney());
    				newLog.setShopid(prepaylog.getShopid());
    				newLog.setTt(4);
    				newLog.setUserid(prepaylog.getUserid());

    				params = new QueryParam().add("linkid", prepaylog.getLinkid());
    				indexList = prepaylogService.getList(params, 0, 1, "displayOrder", "desc", false);
    				newLog.setDisplayOrder(indexList.get(0).getDisplayOrder() - 1);
    				prepaylogService.save(newLog);
					
				}
    			
    			params = new QueryParam(4).add("restmoney>", 0.0)
    					.add("userid", deposit.getUserid()).add("shopid", deposit.getShopid()).add("tt", 0);
    			List<Prepaylog> list = prepaylogService.getList(params, 0, 0, "discount", "asc", false);
    			
    			//同时更新shopvip
    			if(list.size() > 0) {
    				
    				JSONArray jsonAry = new JSONArray();
    				double totalMoney = 0;
    				for (Prepaylog prepaylog : list) {
    					JSONObject jsonObj = new JSONObject();
    					jsonObj.put("id", prepaylog.getId());
    					jsonObj.put("createdate", prepaylog.getCreatedate());
    					jsonObj.put("money", prepaylog.getRestmoney());
    					jsonObj.put("discount", prepaylog.getDiscount());
    					jsonAry.add(jsonObj);
    					totalMoney += prepaylog.getRestmoney();
    				}
    				Shopvip shopvip = shopvipService.get(deposit.getUserid()+"z"+deposit.getShopid());
    				shopvip.setPrepayjson(jsonAry.toString());
    				shopvip.setMoney(totalMoney);
    				shopvipService.update(shopvip);
    			}
    			
    		}
    		
    	}
    	
    	deposit.setTt(stat);
    	depositService.update(deposit);
	 return ajaxJson("{\"success\":true}");
    }


	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
