package com.wudianyi.wb.hongmao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wudianyi.wb.hongmao.dao.CommentDao;
import com.wudianyi.wb.hongmao.entity.Comment;
import com.wudianyi.wb.hongmao.service.CommentService;


@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment,String>
				implements CommentService{

		@Resource
		public void setBaseDao(CommentDao commentDao){
			super.setBaseDao(commentDao);
		}
		
		@Override
		public List getCommentList(Integer userid,Integer shopid){
			return null;
		}
}
