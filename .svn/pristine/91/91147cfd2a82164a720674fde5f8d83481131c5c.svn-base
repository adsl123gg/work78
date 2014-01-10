package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ChanceEventDao;
import com.pojo.Chance;
import com.pojo.ChanceEvent;

@Service
@Transactional
public class ChanceEventService {

	@Autowired
	private ChanceEventDao chanceEventDao;
	
	public List<ChanceEvent> getChanceEvents(Chance chance){
		return chanceEventDao.getcChanceEvents(chance);
	}
	
	public void add(ChanceEvent chanceEvent){
		chanceEventDao.save(chanceEvent);
	}
	
	public ChanceEvent findById(String id){
		return chanceEventDao.findById(id);
	}
	
	public void delete(String id){
		chanceEventDao.delete(id);
	}
	
}
