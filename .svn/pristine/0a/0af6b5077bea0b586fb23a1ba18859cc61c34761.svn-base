package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.Message;
import com.pojo.User;

@Repository
public class MessageDao extends BaseDao<Message, String>{

	public List<Message> getMessages(User user,int i) {
		Criteria criteria=getSession().createCriteria(Message.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		criteria.addOrder(Order.desc("createtime"));
		criteria.setFirstResult(i*10);
		criteria.setMaxResults(10);
		List<Message> companies=criteria.list();
		
		return companies;
	}

	public String getNum(User user) {
		Criteria criteria=getSession().createCriteria(Message.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.setProjection(Projections.count("id")); 
		
		return criteria.uniqueResult().toString();
	}
	
}
