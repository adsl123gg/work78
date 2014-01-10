package com.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.pojo.User;

@Component
public class MyInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User) session.getAttribute("user");
		
		ActionProxy proxy=invocation.getProxy();
		String name=proxy.getActionName();
		
		if("index".equals(name)||"login".equals(name)||"image".equals(name)){
			String result=invocation.invoke();
			return result;
		}else {
			if (user!=null) {
				String result=invocation.invoke();
				return result;
			}else {
				return "relogin";
			}
		}
		
		//return invocation.invoke();
	}

}
