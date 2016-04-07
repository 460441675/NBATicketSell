package com.cm.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.cm.bean.PageBean;
import com.cm.service.OrderService;
import com.cm.service.TicketService;
import com.cm.service.UserService;
import com.cm.vo.Order;
import com.cm.vo.Ticket;
import com.cm.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport implements ServletRequestAware {

	private OrderService orderService;

	private UserService userService;

	private TicketService ts;

	private User user;

	private Ticket ticket;
	
	private PageBean pageBean;
	
	private int page;

	private Order order;

	private HttpServletRequest request;

	private HttpSession session;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public TicketService getTs() {
		return ts;
	}

	public void setTs(TicketService ts) {
		this.ts = ts;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String ticketDetail() {
		Ticket newticket = ts.findTicketById(ticket.getTicketId());
		request.setAttribute("ticket", newticket);
		return SUCCESS;
	}

	public String addOrder() {
		Ticket newticket = ts.findTicketById(ticket.getTicketId());
		User user = (User) session.getAttribute("user");
		order.setAddress(user.getAddress());
		order.setConsignee(user.getNickname());
		order.setPhone(user.getTel());
		order.setIsPay("未支付");
		order.setTicket(newticket);
		order.setOrderDate(new Date().toString());
		order.setUser(user);
		if (orderService.saveOrder(order)) {
			newticket.setHighSoldNum(newticket.getHighSoldNum()
					+ order.getHighOrder());
			newticket.setMiddleSoldNum(newticket.getMiddleSoldNum()
					+ order.getMiddleOrder());
			newticket.setLowSoldNum(newticket.getLowSoldNum()
					+ order.getLowOrder());
			ts.updateTicket(newticket, newticket.getTicketId());
			List<Order> list = orderService.queryOrderByUser(user.getUserId());
			request.setAttribute("list", list);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String queryOrderByUserId() {
		User user = (User) session.getAttribute("user");
		List<Order> list = orderService.queryOrderByUser(user.getUserId());
		request.setAttribute("list", list);
		return SUCCESS;
	}

	public String deleteOrder() {
		Order neworder = orderService.findOrderById(order.getOrderId());
		Ticket newticket = ts
				.findTicketById(neworder.getTicket().getTicketId());
		User user = (User) session.getAttribute("user");
		newticket.setHighSoldNum(newticket.getHighSoldNum()
				- neworder.getHighOrder());
		newticket.setMiddleSoldNum(newticket.getMiddleSoldNum()
				- neworder.getMiddleOrder());
		newticket.setLowSoldNum(newticket.getLowSoldNum()
				- neworder.getLowOrder());
		if (orderService.deleteOrder(order.getOrderId())) {
			ts.updateTicket(newticket, newticket.getTicketId());
			List<Order> list = orderService.queryOrderByUser(user.getUserId());
			request.setAttribute("list", list);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String deleteOrderByAdmin() {
		Order neworder = orderService.findOrderById(order.getOrderId());
		Ticket newticket = ts
				.findTicketById(neworder.getTicket().getTicketId());
		newticket.setHighSoldNum(newticket.getHighSoldNum()
				- neworder.getHighOrder());
		newticket.setMiddleSoldNum(newticket.getMiddleSoldNum()
				- neworder.getMiddleOrder());
		newticket.setLowSoldNum(newticket.getLowSoldNum()
				- neworder.getLowOrder());
		if (orderService.deleteOrder(order.getOrderId())) {
			ts.updateTicket(newticket, newticket.getTicketId());
			List<Order> list = orderService.queryAllOrder();
			request.setAttribute("list", list);
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}
	
	public String queryAllOrder() {
		pageBean = orderService.getPageBean(5, page);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	public String orderDetail() {
		Order newOrder = orderService.findOrderById(order.getOrderId());
		request.setAttribute("order", newOrder);
		return SUCCESS;
	}
	
	public String updateOrder() {
		Order neworder = orderService.findOrderById(order.getOrderId());
		Ticket newTicket = ts.findTicketById(ticket.getTicketId());
		int highOrder=order.getHighOrder()-neworder.getHighOrder();
		int middleOrder=order.getMiddleOrder()-neworder.getMiddleOrder();
		int lowOrder=order.getLowOrder()-neworder.getLowOrder();

		neworder.setOrderId(neworder.getOrderId());
		neworder.setOrderDate(neworder.getOrderDate());
		neworder.setConsignee(order.getConsignee());
		neworder.setAddress(order.getAddress());
		neworder.setPhone(order.getPhone());
		neworder.setHighOrder(order.getHighOrder());
		neworder.setMiddleOrder(order.getMiddleOrder());
		neworder.setLowOrder(order.getLowOrder());
		neworder.setOrderPrice(order.getOrderPrice());
		neworder.setIsPay(neworder.getIsPay());
		neworder.setUser((User)session.getAttribute("user"));
		neworder.setTicket(ts.findTicketById(ticket.getTicketId()));
		if(orderService.updateOrder(neworder)){
			newTicket.setHighSoldNum(newTicket.getHighSoldNum()+highOrder);
			newTicket.setMiddleSoldNum(newTicket.getMiddleSoldNum()+middleOrder);
			newTicket.setLowSoldNum(newTicket.getLowSoldNum()+lowOrder);
			ts.updateTicket(newTicket, newTicket.getTicketId());

			User user = (User) session.getAttribute("user");
			List<Order> list = orderService.queryOrderByUser(user.getUserId());
			request.setAttribute("list", list);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = request.getSession();
	}
}
