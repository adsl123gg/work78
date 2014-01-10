package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ContactExtraDao;
import com.pojo.ContactExtra;
import com.pojo.User;

@Service
@Transactional
public class ContactExtraService {

	@Autowired
	private ContactExtraDao contactExtraDao;

	public void setContactExtraDao(ContactExtraDao contactExtraDao) {
		this.contactExtraDao = contactExtraDao;
	}
	
	public List<ContactExtra> getContactExtras(User user){
		return contactExtraDao.getContactExtras(user);
	}

	public void add(ContactExtra contactExtra) {
		contactExtraDao.save(contactExtra);
	}
	
}
