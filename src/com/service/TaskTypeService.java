package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TaskTypeDao;
import com.pojo.TaskType;

@Service
@Transactional
public class TaskTypeService {

	@Autowired
	private TaskTypeDao taskTypeDao;

	public void setTaskTypeDao(TaskTypeDao taskTypeDao) {
		this.taskTypeDao = taskTypeDao;
	}
	
	public List<TaskType> getTaskTypes(){
		return taskTypeDao.findAll();
	}

	public void add(TaskType taskType) {
		taskTypeDao.save(taskType);
	}
	
	public void delete(String id){
		taskTypeDao.delete(id);
	}

	public TaskType find(String task_type_id) {
		return taskTypeDao.findById(task_type_id);
	}
	
}
