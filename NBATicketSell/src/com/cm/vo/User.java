package com.cm.vo;

import java.util.Set;

public class User {

	private int userId;

	private String username;

	private String password;

	private String nickname;

	private String tel;

	private String address;

	private int right;
	
	private String idCard;
	
	private String bankCard;
	
	private Set<Order> orders;

	public User() {
		super();
	}

	public User(int userId, String username, String password, String nickname,
			String tel, String address, int right, String idCard,
			String bankCard, Set<Order> orders) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.tel = tel;
		this.address = address;
		this.right = right;
		this.idCard = idCard;
		this.bankCard = bankCard;
		this.orders = orders;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
