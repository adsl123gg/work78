package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.BookMarkCompany;
import com.pojo.Chance;
import com.pojo.Company;
import com.pojo.User;

@Repository
public class BookMarkCompanykDao extends BaseDao<BookMarkCompany, String>{
	
	public List<BookMarkCompany> getBookMarkCompanies(Company company){
		Criteria criteria=getSession().createCriteria(BookMarkCompany.class);
		criteria.add(Restrictions.eq("company", company));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		List<BookMarkCompany> chances=criteria.list();
		
		return chances;
	}
	
}
