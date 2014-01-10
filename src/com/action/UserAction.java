package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.pojo.RandomValidateCode;
import com.pojo.User;
import com.service.MessageService;
import com.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.UUID;

@ParentPackage("mypackage")
public class UserAction implements Action,SessionAware{

	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	
	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";
	
	private User user;
	private Map<String, Object> session;
	private String newPwd;
	private String newPwd2;
	private File avatar;
	private String avatarFileName;
	private String avatarContentType;
	private String[] avatars={"image/gif"," image/jpeg","image/gif","image/png"};
	private List<User> colleagues;
	private String rember;
	private InputStream inputStream;
	private String result;
	
	@org.apache.struts2.convention.annotation.Action(value="index",results={@Result(type="redirectAction",name="go",params={"actionName","message"})})
	public String execute() throws Exception {
		
	    Cookie[] cookies = ServletActionContext.getRequest().getCookies(); 
	    String userName = null; 
	    String userPwd = null; 
	    if(cookies != null && cookies.length > 0){ 
		for(Cookie cookie : cookies) { 
			if("www.kaishengit.com-userName".equals(cookie.getName())) 
			  { 
			    userName = cookie.getValue(); 
			  } 
		  if("www.kaishengit.com-userPwd".equals(cookie.getName())) 
			  { 
			    userPwd = cookie.getValue(); 
			  } 
		  } 
	  } 
	    
	  user=new User();
	  user.setName(userName);
	  user.setPassword(userPwd);
	  User u=userService.login(user);
	  if (u!=null) {
		  session.put("user",u);
		  return "go";
	  }else {
		  return SUCCESS;
	  }
	}
	
	@org.apache.struts2.convention.annotation.Action(value="person")
	public String person() throws Exception {
		return SUCCESS;
	}
	
	@org.apache.struts2.convention.annotation.Action(value="error")
	public String error() throws Exception {
		return SUCCESS;
	}
	
	@org.apache.struts2.convention.annotation.Action(value="login",results={@Result(type="redirectAction",name="success",params={"actionName","message"}),@Result(type="redirectAction",name="error",params={"actionName","error"})})
	public String login(){
		
		int i=(Integer) session.get(RANDOMCODEKEY);
		String rs=i+"";
		if (rs.equals(result)) {
			User u=userService.login(user);
			if (u!=null) {
				session.put("user",u);
				
				if (rember!=null) {
					Cookie nameCookie = new Cookie("www.kaishengit.com-userName",u.getName()); 
					Cookie pwdCookie = new Cookie("www.kaishengit.com-userPwd",u.getPassword()); 
					 
					nameCookie.setMaxAge(60 * 60 * 24 * 7); 
					pwdCookie.setMaxAge(60 * 60 * 24 * 7); 
					 
					ServletActionContext.getResponse().addCookie(nameCookie); 
					ServletActionContext.getResponse().addCookie(pwdCookie); 
				}
				
				return SUCCESS;
			}else {
				return ERROR;
			}
		}else {
			return ERROR;
		}
		
		
	}
	
	@org.apache.struts2.convention.annotation.Action(value="updateUserName",results={@Result(type="redirectAction",name="success",params={"actionName","person"}),@Result(type="redirectAction",name="error",params={"actionName","error"})})
	public String updateName(){
		
		User user=(User) session.get("user");
		user.setName(this.user.getName());
		user.setEmail(this.user.getEmail());
		
		userService.save(user);
		
		messageService.add(user, user.getName()+"修改了个人信息","个人信息" );
		
		return SUCCESS;
	}
	
	@org.apache.struts2.convention.annotation.Action(value="updateUserPwd",results={@Result(type="redirectAction",name="success",params={"actionName","person"}),@Result(type="redirectAction",name="error",params={"actionName","error"})})
	public String updatePwd(){
		User user=(User) session.get("user");
		if (user.getPassword().equals(this.user.getPassword())) {
			if (newPwd.equals(newPwd2)) {
				user.setPassword(newPwd);
				userService.save(user);
				
				messageService.add(user, user.getName()+"修改了个人信息","个人信息" );
				
				return SUCCESS;
			}else {
				return ERROR;
			}
		}else{
			return ERROR;
		}
		
	}
	
	@org.apache.struts2.convention.annotation.Action(value="updateUserAvatar",results={@Result(type="redirectAction",name="success",params={"actionName","person"}),@Result(type="redirectAction",name="error",params={"actionName","error"})})
	public String updateAvatar() throws Exception{
		System.out.println(avatar.length());
		if (avatar.length()>2*1024*1024) {
			return ERROR;
		}else {
			if (has(avatarContentType)) {
				String savePath = ServletActionContext.getServletContext().getRealPath("/") + "img/";
				avatarFileName=UUID.getUUID()+avatarFileName.substring(avatarFileName.indexOf("."));
				
				InputStream inputStream = new FileInputStream(avatar);
				OutputStream outputStream = new FileOutputStream(new File(savePath+avatarFileName));
				
				byte[] buffer = new byte[1024];
				int len = -1;
				while((len = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, len);
				}
				
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				
				User user=(User) session.get("user");
				user.setAvatar(avatarFileName);
				userService.save(user);
				
				messageService.add(user, user.getName()+"上传了新头像","个人信息" );
				
				return SUCCESS;
			}else {
				return ERROR;
			}
			
		}
		
	}
	
	@org.apache.struts2.convention.annotation.Action("colleague")
	public String getColleague(){
		//colleagues=new ArrayList<User>();
		colleagues=userService.getColleague();
		return SUCCESS;
	}
	
	@org.apache.struts2.convention.annotation.Action("group")
	public String group(){
		
		return SUCCESS;
	}
	
	@org.apache.struts2.convention.annotation.Action(value="exit",results={@Result(type="redirectAction",name="success",params={"actionName","index"})})
	public String exit(){
		session.clear();
		
		Cookie[] cookies = ServletActionContext.getRequest().getCookies(); 
		for (Cookie cookie : cookies) {
			if("www.kaishengit.com-userName".equals(cookie.getName())) { 
				cookie.setValue("invalidate");
				ServletActionContext.getResponse().addCookie(cookie);
			  } 
		   if("www.kaishengit.com-userPwd".equals(cookie.getName())){ 
			   cookie.setValue("invalidate");
			   ServletActionContext.getResponse().addCookie(cookie);
			  } 
		}
		
		
		
		return "success";
	}
	
	@org.apache.struts2.convention.annotation.Action(value="image",results={@Result(type="stream",name="success",params={"contentType","image/jpeg","inputName","inputStream"})})
	public String image() throws IOException{
		new RandomValidateCode().getRandcode(session);
		
		inputStream=new FileInputStream(new File("c:/image/a.jpeg"));
		
		return "success";
	}
	
	
	public boolean has(String type){
		for (int i = 0; i < avatars.length; i++) {
			if (type.equals(avatars[i])) {
				return true;
			}
		}
		return false;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getNewPwd2() {
		return newPwd2;
	}

	public void setNewPwd2(String newPwd2) {
		this.newPwd2 = newPwd2;
	}

	public File getAvatar() {
		return avatar;
	}

	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public String getAvatarContentType() {
		return avatarContentType;
	}

	public void setAvatarContentType(String avatarContentType) {
		this.avatarContentType = avatarContentType;
	}

	public List<User> getColleagues() {
		return colleagues;
	}

	public void setColleagues(List<User> colleagues) {
		this.colleagues = colleagues;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getRember() {
		return rember;
	}

	public void setRember(String rember) {
		this.rember = rember;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
