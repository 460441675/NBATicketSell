package com.cm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.cm.bean.PageBean;
import com.cm.service.UserService;
import com.cm.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware{
	
	
	private User user;
	
	private UserService userService;
	
	private PageBean pageBean;
	
	private int page;
	
	private HttpServletRequest request;
	
	private HttpSession session;
	
	private String result;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public HttpSession getSession() {
		return session;
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String login() {
		if(userService.findUser(user.getUsername(), user.getPassword()) == null){
			String tip = "用户名或密码有误";
			request.setAttribute("tip", tip);
			return "wrongUser";
		}else{
			session.setAttribute("user", userService.findUser(user.getUsername(), user.getPassword()));
			return "judge";
		}
	}
	
	public String judge() {
		result = userService.findUser(user.getUsername(), user.getPassword()).getRight()==1?"queryAllTicket":"userWelcome";
		return result;
	}
	
	public String reg() {
		user.setRight(0);
		user.setAddress("");
		user.setBankCard("");
		user.setIdCard("");
		if(userService.saveUser(user)){
			return SUCCESS;
		}else{
			String tip = "用户名已存在！";
			request.setAttribute("tip", tip);
			return "usernameIsExit";
		}
	}

	public String userInfo() {
		int userId = user.getUserId();
		session.removeAttribute("user");
		request.setAttribute("user", userService.findUserById(userId));
		session.setAttribute("user", userService.findUserById(userId));
		return SUCCESS;
	}
	
	public String updateUserInfo() {
		result = userService.updateUserInfo(user)?SUCCESS:ERROR;
		String tip = "密码修改成功！";
		request.setAttribute("tip", tip);
		return result;
	}
	
	public String updateUserInfoByAdmin() {
		result = userService.updateUserInfo(user)?"queryAllUser":ERROR;
		return result;
	}
	
	public String logout() {
		session.removeAttribute("user");
		return SUCCESS;
	}
	
	public String queryAllUser() {
		pageBean = userService.getPageBean(5, page);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	public String deleteUserById() {
		result = userService.deleteUserById(user.getUserId())?"queryAllUser":ERROR;
		return result;
	}
	
	public String findUserById() {
		request.setAttribute("user", userService.findUserById(user.getUserId()));
		return SUCCESS;
	}
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = request.getSession();
	}
}
