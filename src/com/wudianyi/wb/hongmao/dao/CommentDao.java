package com.wudianyi.wb.hongmao.dao;

import java.util.List;

import com.wudianyi.wb.hongmao.entity.Comment;


public interface CommentDao extends BaseDao<Comment,String>{
	public List getCommentList(Integer shopid, int pn, int ps); 
}