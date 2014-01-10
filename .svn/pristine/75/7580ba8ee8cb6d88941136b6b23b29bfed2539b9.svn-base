package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ChanceExtraDao;
import com.pojo.ChanceExtra;
import com.pojo.User;

@Service
@Transactional
public class ChanceExtraService {

	@Autowired
	private ChanceExtraDao chanceExtraDao;
	
	public List<ChanceExtra> getChanceExtras(User user){
		return chanceExtraDao.getChanceExtras(user);
	}

	public void add(ChanceExtra chanceExtra) {
		chanceExtraDao.save(chanceExtra);
	}
}
