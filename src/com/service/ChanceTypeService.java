package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ChanceTypeDao;
import com.pojo.ChanceType;

@Service
@Transactional
public class ChanceTypeService {

	@Autowired
	private ChanceTypeDao chanceTypeDao;

	public void setChanceTypeDao(ChanceTypeDao chanceTypeDao) {
		this.chanceTypeDao = chanceTypeDao;
	}
	
	public void add(ChanceType chanceType){
		chanceTypeDao.save(chanceType);
	}
	
	public void delete(String id){
		chanceTypeDao.delete(id);
	}
	
	public ChanceType getChanceType(String id){
		return chanceTypeDao.findById(id);
	}
	
	public ChanceType find(String id){
		return chanceTypeDao.findById(id);
	}
	
	
}
