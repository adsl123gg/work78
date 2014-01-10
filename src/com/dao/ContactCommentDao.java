package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.Chance;
import com.pojo.Contact;
import com.pojo.ContactComment;
import com.pojo.ContactEvent;
import com.pojo.User;

@Repository
public class ContactCommentDao extends BaseDao<ContactComment, String>{
	
	public List<ContactComment> getContactComments(ContactEvent contactEvent){
		Criteria criteria=getSession().createCriteria(ContactComment.class);
		criteria.add(Restrictions.eq("contactEvent", contactEvent));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		criteria.addOrder(Order.asc("createtime"));
		List<ContactComment> contactComments=criteria.list();
		
		return contactComments;
	}
}
