package com.cm.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cm.dao.TicketDao;
import com.cm.vo.Ticket;

public class TicketDaoImpl extends BaseDao implements TicketDao {

	@Override
	public boolean addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		getSession().save(ticket);
		return true;
	}

	@Override
	public List<Ticket> queryAllTicket() {
		// TODO Auto-generated method stub
		
		String hql = "from Ticket";
		Query query = getSession().createQuery(hql);
		List<Ticket> list = query.list();
		return list;
	}

	@Override
	public boolean deleteTicketById(int ticketId) {
		// TODO Auto-generated method stub
		String hql="delete from Ticket as ticket where ticket.ticketId=:ticketId";
		Query query = getSession().createQuery(hql);
		query.setInteger("ticketId", ticketId);
		if(query.executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateTicket(Ticket ticket, int ticketId) {
		// TODO Auto-generated method stub
		String hql = "update Ticket as ticket set ticket.ticketName=:ticketName,ticket.fixture=:fixture,"
				+ "ticket.venue=:venue, ticket.highPrice=:highPrice, ticket.middlePrice=:middlePrice,"
				+ "ticket.lowPrice=:lowPrice,ticket.highStorage=:highStorage,ticket.middleStorage=:middleStorage,"
				+ "ticket.lowStorage=:lowStorage,ticket.onSaleTime=:onSaleTime,ticket.details=:details,ticket.highSoldNum=:highSoldNum,ticket.middleSoldNum=:middleSoldNum,ticket.lowSoldNum=:lowSoldNum where ticket.ticketId=:ticketId";
		Query query = getSession().createQuery(hql);
		
		query.setString("ticketName", ticket.getTicketName());
		query.setString("fixture", ticket.getFixture());
		query.setString("venue", ticket.getVenue());
		query.setDouble("highPrice", ticket.getHighPrice());
		query.setDouble("middlePrice", ticket.getMiddlePrice());
		query.setDouble("lowPrice", ticket.getLowPrice());
		query.setInteger("highStorage", ticket.getHighStorage());
		query.setInteger("middleStorage", ticket.getMiddleStorage());
		query.setInteger("lowStorage", ticket.getLowStorage());
		query.setString("onSaleTime", ticket.getOnSaleTime());
		query.setString("details", ticket.getDetails());
		query.setInteger("highSoldNum", ticket.getHighSoldNum());
		query.setInteger("middleSoldNum", ticket.getMiddleSoldNum());
		query.setInteger("lowSoldNum", ticket.getLowSoldNum());
		query.setInteger("ticketId", ticket.getTicketId());
		if(query.executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Ticket findTicketById(int ticketId) {
		// TODO Auto-generated method stub
		Ticket ticket = (Ticket)getSession().load(Ticket.class, ticketId);
		
		return ticket;
	}

}
