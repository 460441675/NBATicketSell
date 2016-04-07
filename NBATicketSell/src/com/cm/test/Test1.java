package com.cm.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cm.service.OrderService;
import com.cm.service.TicketService;
import com.cm.service.UserService;
import com.cm.vo.Order;
import com.cm.vo.Ticket;
import com.cm.vo.User;

public class  Test1{
//	@Test
//	public void main() {
//	
//	
//	BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
//	 
//	 //TicketService ticketService = (TicketService)beanFactory.getBean("ts");
//	// Ticket ticket1 = ticketService.findTicketById(1);
//	// UserService userService =(UserService)beanFactory.getBean("userService");
//	// User user = userService.findUserById(2);
//		
//		//Order order = new Order(1, "123", "123", "123", "123", "123", "123", "123", "123", "123", user, ticket1);
//		//OrderService orderService = (OrderService)beanFactory.getBean("orderService");
//		//orderService.saveOrder(order);
//		
//		
//	}
//	
//	@Test
//	public void updateOrder() {
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
//		OrderService orderService = (OrderService)beanFactory.getBean("orderService");
//		Order order=orderService.findOrderById(24);
//		order.setConsignee("cm");
//		orderService.updateOrder(order);
//	}
	
	@Test
	public void updateUser() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService)beanFactory.getBean("userService");
		User user = userService.findUserById(2);
		user.setBankCard("010101010");
		userService.updateUserInfo(user);
	}
//	
//	@Test
//	public void deleteOrder() {
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
//		OrderService orderService = (OrderService)beanFactory.getBean("orderService");
//		orderService.deleteOrder(2);
//	}
//	
//	@Test
//	public void queryAllTicket() {
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
//		TicketService ticketService = (TicketService)beanFactory.getBean("ts");
//		List<Ticket> list = ticketService.queryAllTicket();
//		System.out.println(list);
//	}
//	
//	@Test
//	public void queryTicketByUserId() {
//		
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
//		OrderService orderService = (OrderService)beanFactory.getBean("orderService");
////		UserService userService = (UserService)beanFactory.getBean("userService");
////		User user = userService.findUserById(2);
////		System.out.println(user);
//		List<Order> list = orderService.queryOrderByUser(2);
//		System.out.println(list);
//	}
//	
//	@Test
//	public void addTicketTest() {
//		
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
//		TicketService ticketService = (TicketService)beanFactory.getBean("ts");
//		//Set<Order> order  = null;
////		Ticket ticket = new Ticket(2, "123", "123", "123", 123, 100, 99, 100, 100, 100, 0, 10, 20, "2016-04-04", "1", "123");
////		ticketService.saveTicket(ticket);
//	}
//	
//	@Test
//	public void addUser() {
//	Set<Order> ticket = null;
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
//		UserService userService = (UserService)beanFactory.getBean("userService");
////		User user = new User();
////		user.setUserId(3);
////		user.setUsername("qwe");
////		user.setPassword("123");
////		user.setRight(0);
////		user.setNickname("qwe");
//		User user = new User(2, "123", "123", "123", "123", "123", 0, "123", "123", ticket);
//		userService.saveUser(user);
//	}
}
