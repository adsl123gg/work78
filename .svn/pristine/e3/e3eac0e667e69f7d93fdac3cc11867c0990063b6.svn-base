package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CompanyDao;
import com.pojo.Company;
import com.pojo.User;

@Service
@Transactional
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	
	public List<Company> getCompanies(User user){
		return companyDao.getContacts(user);
	}
	
	public void add(Company company){
		companyDao.save(company);
	}
	
	public Company findById(String id){
		return companyDao.findById(id);
	}
	
	public void delete(String id){
		companyDao.delete(id);
	}
	
}
