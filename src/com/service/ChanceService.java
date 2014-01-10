package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ChanceDao;
import com.pojo.Chance;
import com.pojo.Company;
import com.pojo.Contact;
import com.pojo.User;

@Service
@Transactional
public class ChanceService {

	@Autowired
	private ChanceDao chanceDao;

	public void setChanceDao(ChanceDao chanceDao) {
		this.chanceDao = chanceDao;
	}
	
	public void addChance(Chance chance){
		chanceDao.save(chance);
	}
	
	public List<Chance> getChances(User user){
		return chanceDao.getChances(user);
	}
	
	public Chance findById(String id){
		return chanceDao.findById(id);
	}
	
	public List<Chance> getContactChances(Contact contact){
		return chanceDao.getContactChances(contact);
	}
	
	public List<Chance> getCompanyChances(Company company) {
		return chanceDao.getCompanyChances(company);
	}
	
}
