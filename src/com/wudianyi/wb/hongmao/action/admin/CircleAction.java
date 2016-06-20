package com.wudianyi.wb.hongmao.action.admin;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.action.BaseAction;


@ParentPackage("admin")
public class CircleAction extends BaseAction{
	
    public String list(){
		
		return LIST;
	}
}