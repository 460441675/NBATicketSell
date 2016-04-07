package com.cm.service.impl;

import java.util.List;

import com.cm.bean.PageBean;
import com.cm.dao.ServiceDao;
import com.cm.dao.TicketDao;
import com.cm.service.TicketService;
import com.cm.vo.Ticket;

public class TicketServiceImpl implements TicketService {

	
	private TicketDao ticketDao;
	
	private ServiceDao serviceDao;
	
	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	@Override
	public boolean saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		if(ticketDao.addTicket(ticket)) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Ticket> queryAllTicket() {
		// TODO Auto-generated method stub
		List<Ticket> list = ticketDao.queryAllTicket();
		return list;
	}

	@Override
	public PageBean getPageBean(int pageSize, int page) {
		// TODO Auto-generated method stub
		
		PageBean pageBean = new PageBean();
		
		String hql = "from Ticket";
		
		int allRows = serviceDao.getAllRowCount(hql);
		
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		
		int currentPage = pageBean.getCurrentPage(page);
		
		int offSet = pageBean.getCurrentPageOffset(pageSize, currentPage);
		
		List<Ticket> list = serviceDao.queryTicketByPage(hql, offSet, pageSize);
		
		pageBean.setList(list);
		
		pageBean.setAllRows(allRows);
		
		pageBean.setCurrentPage(currentPage);
		
		pageBean.setTotalPage(totalPage);
		
		return pageBean;
	}

	@Override
	public boolean deleteTicketById(int ticketId) {
		// TODO Auto-generated method stub
		if(ticketDao.deleteTicketById(ticketId)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateTicket(Ticket ticket, int ticketId) {
		// TODO Auto-generated method stub
		if(ticketDao.updateTicket(ticket,ticketId)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Ticket findTicketById(int ticketId) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketDao.findTicketById(ticketId);
		
		return ticket;
	}

}
