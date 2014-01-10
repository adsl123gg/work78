package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ContactDao;
import com.pojo.Company;
import com.pojo.Contact;
import com.pojo.User;

@Service
@Transactional
public class ContactService {

	@Autowired
	private ContactDao contactDao;

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	public Contact findById(String id){
		return contactDao.findById(id);
	}
	
	public List<Contact> getContacts(User user){
		return contactDao.getContacts(user);
	}
	
	public void add(Contact contact){
		contactDao.save(contact);
	}
	
	public List<Contact> getCompanyContacts(Company company) {
		return contactDao.getCompanyContacts(company);
	}
	
}
