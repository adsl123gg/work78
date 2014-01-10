package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.pojo.Message;
import com.pojo.User;
import com.service.MessageService;

@ParentPackage("mypackage")
public class MessageAction implements Action,SessionAware{

	@Autowired
	private MessageService messageService;
	
	private Map<String, Object> session;
	private List<Message> messages;
	private int no=0;
	
	private String p;
	private String nowpage;
	
	@org.apache.struts2.convention.annotation.Action("message")
	public String execute() throws Exception {
		User user=(User) session.get("user");
		no=0;
		messages=messageService.getMessages(user,no);

		return SUCCESS;
	}
	
	@org.apache.struts2.convention.annotation.Action("getMsg")
	public String getMsg() throws Exception {
		User user=(User) session.get("user");
		
		int n=Integer.parseInt(nowpage);
		System.out.println(p);
		
		if ("prev".equals(p)) {
			if (n==0) {
				no=0;
			}else {
				no=Integer.parseInt(nowpage)-1;
				
			}
		}else {
			if (n==getNum()-1) {
				no=getNum()-1;
			}else {
				no=Integer.parseInt(nowpage)+1;
				System.out.println(n);
			}
		}
		
		messages=messageService.getMessages(user,no);

		return "success";
	}
	
	public int getNum(){
		User user=(User) session.get("user");
		int num=Integer.parseInt(messageService.getNum(user));
		if (num/10!=0) {
			num=num/10+1;
		}else {
			num/=10;
		}
		return num;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getNowpage() {
		return nowpage;
	}

	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	

	
}
