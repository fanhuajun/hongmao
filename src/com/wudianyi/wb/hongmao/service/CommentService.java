package com.wudianyi.wb.hongmao.service;

import java.util.List;

import com.wudianyi.wb.hongmao.entity.Comment;


public interface CommentService extends BaseService<Comment,String>{
	
	public List getCommentList(Integer userid,Integer shopid);

}
