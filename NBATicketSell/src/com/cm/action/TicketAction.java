package com.cm.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.cm.bean.PageBean;
import com.cm.service.TicketService;
import com.cm.vo.Ticket;
import com.opensymphony.xwork2.ActionSupport;

public class TicketAction extends ActionSupport implements ServletRequestAware{
	
	private Ticket ticket;
	
	private PageBean pageBean;
	
	private TicketService ts;
	
	private int page;
	
	private String result;
	
	private HttpServletRequest request;
	
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public TicketService getTs() {
		return ts;
	}

	public void setTs(TicketService ts) {
		this.ts = ts;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String execute(){
		// TODO Auto-generated method stub
		//表示每页显示5条记录，page表示当前网页
		pageBean = ts.getPageBean(5, page);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	public String addTicket(){
		ticket.setTicketId(1);
		result = ts.saveTicket(ticket)?SUCCESS:ERROR;
		return result;
	}
	
	public String delete(){
		result = ts.deleteTicketById(ticket.getTicketId())?"queryAllTicket":ERROR;
		return result;
	}
	
	public String updateTicket(){
		result = ts.updateTicket(ticket, ticket.getTicketId())?"queryAllTicket":ERROR;
		return result;
	}
	
	public String queryAllTicket(){
		pageBean = ts.getPageBean(5, page);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}

	public String findTicketById(){
		Ticket ticket1 = ts.findTicketById(ticket.getTicketId());
		request.setAttribute("ticket", ticket1);
		
		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
