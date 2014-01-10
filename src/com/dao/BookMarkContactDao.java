package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.BookMarkContact;
import com.pojo.Contact;
import com.pojo.User;

@Repository
public class BookMarkContactDao extends BaseDao<BookMarkContact, String>{
	
	public List<BookMarkContact> getBookMarkContacts(Contact contact){
		Criteria criteria=getSession().createCriteria(BookMarkContact.class);
		criteria.add(Restrictions.eq("contact", contact));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		List<BookMarkContact> bookMarkContacts=criteria.list();
		
		return bookMarkContacts;
	}
}
