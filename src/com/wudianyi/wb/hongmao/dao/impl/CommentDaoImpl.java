package com.wudianyi.wb.hongmao.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wudianyi.wb.hongmao.dao.CommentDao;
import com.wudianyi.wb.hongmao.entity.Comment;

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment ,String>implements CommentDao{
	@Override
	public List getCommentList(Integer shopid, int pn, int ps){
		String hql = "select c.id, c.username,c.createdate,c.star,c.content,c.reply,c.replydate from Comment c,Shopvip s where";
		
		hql += " c.userid=s.userid and s.shopid=" + shopid  + "order by c.createdate desc";
		return this.getSession().createQuery(hql).setFirstResult(ps * (pn - 1))
				.setMaxResults(ps).list();
	}
}
