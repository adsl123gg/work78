package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ContactEventDao;
import com.pojo.Contact;
import com.pojo.ContactEvent;
import com.pojo.User;

@Service
@Transactional
public class ContactEventservice {

	@Autowired
	private ContactEventDao contactEventDao;

	public void setContactEventDao(ContactEventDao contactEventDao) {
		this.contactEventDao = contactEventDao;
	}
	
	public java.util.List<ContactEvent> getContactEvents(User user){
		return contactEventDao.getContactEvents(user);
	}
	
	public java.util.List<ContactEvent> getContactEvents(Contact contact){
		return contactEventDao.getContactEvents(contact);
	}

	public void add(ContactEvent contactEvent) {
		contactEventDao.save(contactEvent);
	}
	
	public ContactEvent findById(String id){
		return contactEventDao.findById(id);
	}
	
	public void deleteById(String id){
		 contactEventDao.delete(id);
	}
	
}
