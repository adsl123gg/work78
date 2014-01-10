package com.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import antlr.collections.List;

import com.core.BaseDao;
import com.pojo.Chance;
import com.pojo.ChanceEvent;
import com.pojo.User;

@Repository
public class ChanceEventDao extends BaseDao<ChanceEvent, String>{
	
	public java.util.List<ChanceEvent> getcChanceEvents(Chance chance){
		Criteria criteria=getSession().createCriteria(ChanceEvent.class);
		criteria.add(Restrictions.eq("chance", chance));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		criteria.addOrder(Order.desc("createtime"));
		java.util.List<ChanceEvent> chanceevents=criteria.list();
		
		return chanceevents;
	}
}
