package com.cm.dao;

import java.util.List;

import com.cm.vo.Ticket;

public interface TicketDao {

	boolean addTicket(Ticket ticket);
	
	List<Ticket> queryAllTicket();
	
	boolean deleteTicketById(int ticketId);

	boolean updateTicket(Ticket ticket, int ticketId);
	
	Ticket findTicketById(int ticketId);
}
