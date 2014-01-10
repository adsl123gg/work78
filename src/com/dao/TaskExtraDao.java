package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.TaskExtra;
import com.pojo.User;

@Repository
public class TaskExtraDao extends BaseDao<TaskExtra, String>{

	public List<TaskExtra> getTaskExtras(User user) {
		Criteria criteria=getSession().createCriteria(TaskExtra.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		List<TaskExtra> tasks=criteria.list();
		
		return tasks;
	}
	
}
