package com.cm.vo;

import java.io.Serializable;

public class Order implements Serializable {

	//订单ID
	private int orderId;
	
	//下单日期
	private String orderDate;
	
	//收货人
	private String consignee;
	
	//收货地址
	private String address;
	
	//收货人电话
	private String phone;
	
	//订单总价
	private String orderPrice;
	
	private int highOrder;
	
	private int middleOrder;
	
	private int lowOrder;
	
	private String isPay;
	
	private User user;
	
	private Ticket ticket;

	public Order() {
		super();
	}

	public Order(int orderId, String orderDate, String consignee,
			String address, String phone, String orderPrice, int highOrder,
			int middleOrder, int lowOrder, String isPay, User user,
			Ticket ticket) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.consignee = consignee;
		this.address = address;
		this.phone = phone;
		this.orderPrice = orderPrice;
		this.highOrder = highOrder;
		this.middleOrder = middleOrder;
		this.lowOrder = lowOrder;
		this.isPay = isPay;
		this.user = user;
		this.ticket = ticket;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getHighOrder() {
		return highOrder;
	}

	public void setHighOrder(int highOrder) {
		this.highOrder = highOrder;
	}

	public int getMiddleOrder() {
		return middleOrder;
	}

	public void setMiddleOrder(int middleOrder) {
		this.middleOrder = middleOrder;
	}

	public int getLowOrder() {
		return lowOrder;
	}

	public void setLowOrder(int lowOrder) {
		this.lowOrder = lowOrder;
	}

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
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


}
