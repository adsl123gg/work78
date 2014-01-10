package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CompanyEventDao;
import com.pojo.Company;
import com.pojo.CompanyEvent;

@Service
@Transactional
public class CompanyEventService {

	@Autowired
	private CompanyEventDao companyEventDao;

	public void setCompanyEventDao(CompanyEventDao companyEventDao) {
		this.companyEventDao = companyEventDao;
	}
	
	public List<CompanyEvent> getCompanyEvents(Company company){
		return companyEventDao.getCompanyComments(company);
	}

	public void add(CompanyEvent companyEvent) {
		companyEventDao.save(companyEvent);
	}
	
	public CompanyEvent findById(String id){
		return companyEventDao.findById(id);
	}
	
	public void delete(String id){
		companyEventDao.delete(id);
	}
	
}
