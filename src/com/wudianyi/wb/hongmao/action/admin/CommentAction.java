package com.wudianyi.wb.hongmao.action.admin;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.hongmao.action.BaseAction;

@ParentPackage("admin")
public class CommentAction extends BaseAction {
	private String id;

	public String list() {
		return LIST;
	}

	public String listid() {
		System.out.println("listid,id:" + id);
		return ajaxJsonSuccessMessage("comment!list.action");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
