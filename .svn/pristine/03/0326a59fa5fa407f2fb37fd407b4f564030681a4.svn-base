package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ChanceCommentDao;
import com.pojo.ChanceComment;
import com.pojo.ChanceEvent;
import com.sun.org.apache.bcel.internal.generic.RETURN;

@Service
@Transactional
public class ChanceCommentService {

	@Autowired
	private ChanceCommentDao chanceCommentDao;
	
	public List<ChanceComment> getChanceComments(ChanceEvent chanceEvent){
		return chanceCommentDao.getChances(chanceEvent);
	}
	
	public void add(ChanceComment chanceComment){
		chanceCommentDao.save(chanceComment);
	}

	public void delete(String id) {
		chanceCommentDao.delete(id);
	}
	
	public ChanceComment find(String id){
		return chanceCommentDao.findById(id);
	}
		
	
}
