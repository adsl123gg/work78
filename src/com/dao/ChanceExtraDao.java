package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.pojo.Chance;
import com.pojo.ChanceExtra;
import com.pojo.User;

@Repository
public class ChanceExtraDao extends BaseDao<ChanceExtra, String>{
	
	public List<ChanceExtra> getChanceExtras(User user){
		Criteria criteria=getSession().createCriteria(ChanceExtra.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		List<ChanceExtra> chanceExtras=criteria.list();
		
		return chanceExtras;
	}
}
