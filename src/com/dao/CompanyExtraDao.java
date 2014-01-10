package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.CompanyExtra;
import com.pojo.ContactExtra;
import com.pojo.User;

@Repository
public class CompanyExtraDao extends BaseDao<CompanyExtra, String>{
	
	public List<CompanyExtra> getCompanyExtras(User user){
		Criteria criteria=getSession().createCriteria(CompanyExtra.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		List<CompanyExtra> companies=criteria.list();
		
		return companies;
		
	}
	
}
