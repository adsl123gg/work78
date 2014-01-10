package com.service;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MessageDao;
import com.pojo.Message;
import com.pojo.User;
import com.util.Time;

@Service
@Transactional
public class MessageService {
	

	@Autowired
	private MessageDao messageDao;
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	public void add(User user,String info,String type){
		Message message=new Message();
		message.setCreatetime(Time.getTime());
		message.setUser(user);
		message.setInfo(info);
		message.setType(type);
		
		messageDao.save(message);
	}
	
	public List<Message> getMessages(User user,int i){
		return messageDao.getMessages(user,i);
	}

	public String getNum(User user) {
		return messageDao.getNum(user);
	}
	
}
