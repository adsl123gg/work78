package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.Chance;
import com.pojo.Contact;
import com.pojo.ContactEvent;
import com.pojo.User;

@Repository
public class ContactEventDao extends BaseDao<ContactEvent, String>{

	public List<ContactEvent> getContactEvents(User user) {
		Criteria criteria=getSession().createCriteria(ContactEvent.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		criteria.addOrder(Order.desc("createtime"));
		List<ContactEvent> contactEvents=criteria.list();
		
		return contactEvents;
	}
	
	public List<ContactEvent> getContactEvents(Contact contact) {
		Criteria criteria=getSession().createCriteria(ContactEvent.class);
		criteria.add(Restrictions.eq("contact", contact));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		criteria.addOrder(Order.desc("createtime"));
		List<ContactEvent> contactEvents=criteria.list();
		
		return contactEvents;
	}
	
}
