package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.ContactExtra;
import com.pojo.Message;
import com.pojo.User;

@Repository
public class ContactExtraDao extends BaseDao<ContactExtra, String>{
	
	public List<ContactExtra> getContactExtras(User user){
		Criteria criteria=getSession().createCriteria(ContactExtra.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		List<ContactExtra> companies=criteria.list();
		
		return companies;
		
	}
	
}
