package com.cm.service;

import java.util.List;

import com.cm.bean.PageBean;
import com.cm.vo.Ticket;

public interface TicketService {

	boolean saveTicket(Ticket ticket);
	
	List<Ticket> queryAllTicket();
	
	PageBean getPageBean(int pageSize, int page);
	
	boolean deleteTicketById(int ticketId);
	
	boolean updateTicket(Ticket ticket, int ticketId);
	
	Ticket findTicketById(int ticketId);
}
