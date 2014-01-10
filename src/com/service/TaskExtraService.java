package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TaskExtraDao;
import com.pojo.TaskExtra;
import com.pojo.User;

@Service
@Transactional
public class TaskExtraService {

	@Autowired
	private TaskExtraDao taskExtraDao;

	public void setTaskExtraDao(TaskExtraDao taskExtraDao) {
		this.taskExtraDao = taskExtraDao;
	}
	
	public void add(TaskExtra taskExtra){
		taskExtraDao.save(taskExtra);
	}
	
	public List<TaskExtra> getTaskExtras(User user){
		return taskExtraDao.getTaskExtras(user);
	}
	
}
