package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.Task;
import com.pojo.User;

@Repository
public class TaskDao extends BaseDao<Task, String>{
	
	public List<Task> getTasks(User user){
		Criteria criteria=getSession().createCriteria(Task.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.add(Restrictions.eq("status", "未完成"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		criteria.addOrder(Order.desc("createtime"));
		List<Task> tasks=criteria.list();
		
		return tasks;
	}
	
	public List<Task> getCompletedTasks(User user){
		Criteria criteria=getSession().createCriteria(Task.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.add(Restrictions.eq("status", "已完成"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		criteria.addOrder(Order.desc("createtime"));
		List<Task> tasks=criteria.list();
		
		return tasks;
	}
	
}
