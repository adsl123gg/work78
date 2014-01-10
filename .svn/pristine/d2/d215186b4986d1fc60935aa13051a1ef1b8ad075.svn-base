package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.Company;
import com.pojo.CompanyComment;
import com.pojo.CompanyEvent;

@Repository
public class CompanyEventDao extends BaseDao<CompanyEvent, String>{
	
	public List<CompanyEvent> getCompanyComments(Company company) {
		Criteria criteria=getSession().createCriteria(CompanyEvent.class);
		criteria.add(Restrictions.eq("company", company));
		criteria.addOrder(Order.desc("createtime"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		List<CompanyEvent> companies=criteria.list();
		
		return companies;
	}
}
