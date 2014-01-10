package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ContactCommentDao;
import com.pojo.Contact;
import com.pojo.ContactComment;
import com.pojo.ContactEvent;

@Service
@Transactional
public class ContactCommentService {

	@Autowired
	private ContactCommentDao contactCommentDao;

	public void setContactCommentDao(ContactCommentDao contactCommentDao) {
		this.contactCommentDao = contactCommentDao;
	}
	
	public List<ContactComment> getComments(ContactEvent contactEvent){
		return contactCommentDao.getContactComments(contactEvent);
	}
	
	public ContactComment findById(String id){
		return contactCommentDao.findById(id);
	}
	
	public void del(String id){
		 contactCommentDao.delete(id);
	}
	
	public void add(ContactComment comment){
		 contactCommentDao.save(comment);
	}
	
}
