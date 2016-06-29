package com.wudianyi.wb.hongmao.action.admin;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Deposit;
import com.wudianyi.wb.hongmao.entity.User;
import com.wudianyi.wb.hongmao.service.DepositService;
import com.wudianyi.wb.hongmao.service.UserService;

@ParentPackage("admin")
public class DepositAction extends BaseAction{
	@Resource
    private DepositService depositService; 	
	private int id;
	
    public String list(){
    	
		return LIST;
	}
    
    public String execute(){
    	Deposit deposit = depositService.get(id);
    	setAttribute("deposit", deposit); 
    	return "deposit";
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
}