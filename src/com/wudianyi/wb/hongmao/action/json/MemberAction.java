package com.wudianyi.wb.hongmao.action.json;

import javax.annotation.Resource;

import org.bouncycastle.jce.provider.symmetric.Grain128.Base;

import com.wudianyi.wb.hongmao.action.BaseAction;
import com.wudianyi.wb.hongmao.common.QueryParam;
import com.wudianyi.wb.hongmao.entity.Const;
import com.wudianyi.wb.hongmao.service.UserService;

public class MemberAction extends BaseAction {
	@Resource
	private UserService userService;
	private int level;

	public String list() {
		String levelStr = "one";
		if (level == 2) {
			levelStr = "two";
		}else if(level ==3){
			levelStr = "three";
		}
		Object userobj = getSession(Const.SESSION_USER_ID);
		Integer userid  = 0;
		if(userobj==null){
			userid = (Integer) userobj;
		}

		list = userService.getList(
				new QueryParam(2).add(levelStr, userid),
				Const.FRONT_PAGE_SIZE * (pn - 1), Const.FRONT_PAGE_SIZE,
				"createdate", "desc", false);
		return LIST;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
