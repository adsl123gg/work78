package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CompanyExtraDao;
import com.pojo.CompanyExtra;
import com.pojo.User;

@Service
@Transactional
public class CompanyExtraService {

	@Autowired
	private CompanyExtraDao companyExtraDao;

	public void setCompanyExtraDao(CompanyExtraDao companyExtraDao) {
		this.companyExtraDao = companyExtraDao;
	}
	
	public List<CompanyExtra> getCompanyExtras(User user){
		return companyExtraDao.getCompanyExtras(user);
	}

	public void add(CompanyExtra companyExtra) {
		companyExtraDao.save(companyExtra);
	}
	
}
