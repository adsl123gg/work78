package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dao.BookMarkCompanykDao;
import com.pojo.BookMarkCompany;
import com.pojo.Company;

@Service
@Transactional
public class BookMarkCompanyService {

	@Autowired
	private BookMarkCompanykDao bookMarkCompanykDao;

	public void setBookMarkCompanykDao(BookMarkCompanykDao bookMarkCompanykDao) {
		this.bookMarkCompanykDao = bookMarkCompanykDao;
	}
	
	public List<BookMarkCompany> getBookMarkCompanies(Company company){
		return bookMarkCompanykDao.getBookMarkCompanies(company);
	}
	
}
