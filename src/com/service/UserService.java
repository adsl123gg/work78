package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.pojo.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user){
		userDao.save(user);
	}
	
	public User login(User user){
		List<User> users=userDao.getUsers();
		for (User u : users) {
			if (u.getName().equals(user.getName())&&u.getPassword().equals(user.getPassword())) {
				return u;
			}
		}
		return null;
	}

	public List<User> getColleague() {
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<User> lists=userDao.findAll();
		for (int i=0;i<lists.size();i++) {
			if (lists.get(i).getName().equals(user.getName())) {
				lists.remove(lists.get(i));
			}
		}
		return lists;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> getuOtherUsers(){
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<User> users=userDao.findAll();
		for (User u : users) {
			if (u.getName().equals(user.getName())&&u.getPassword().equals(user.getPassword())) {
				users.remove(u);
				break;
			}
		}
		return users;
	}
	
	
}
