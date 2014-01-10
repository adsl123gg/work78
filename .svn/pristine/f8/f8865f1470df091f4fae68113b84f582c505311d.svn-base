package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.User;

@Repository
public class UserDao extends BaseDao<User, String>{
	
	public List<User> getUsers(){
		Criteria criteria=getSession().createCriteria(User.class);
		return criteria.list();
	}
	
}
