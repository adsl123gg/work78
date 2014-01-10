package com.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T,PK extends Serializable> {

	private Class<?> calzz;
	
	public BaseDao(){
		ParameterizedType p= (ParameterizedType)this.getClass().getGenericSuperclass();
		Type[] types=p.getActualTypeArguments();
		calzz=(Class<?>) types[0];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void save(T t){
		getSession().saveOrUpdate(t);
	}
	
	public void delete(PK id){
		getSession().delete(findById(id));
	}
	
	@SuppressWarnings("unchecked")
	public T findById(PK id){
		return (T) getSession().get(calzz, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		Criteria criteria=getSession().createCriteria(calzz);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	
}
