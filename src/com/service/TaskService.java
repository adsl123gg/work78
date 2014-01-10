package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TaskDao;
import com.pojo.Task;
import com.pojo.User;

@Service
@Transactional
public class TaskService {

	@Autowired
	private TaskDao taskDao;

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
	
	public void add(Task task){
		taskDao.save(task);
	}
	
	public List<Task> getTasks(User user){
		return  taskDao.getTasks(user);
	}
	
	public List<Task> getCompletedTasks(User user){
		return taskDao.getCompletedTasks(user);
	}
	
	public Task findById(String id){
		return taskDao.findById(id);
	}
	
	public void delete(String id){
		taskDao.delete(id);
	}
	
}
