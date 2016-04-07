package com.cm.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Ticket implements Serializable{

	//票的ID
	private int ticketId;
	
	//票名
	private String ticketName;
	
	//比赛时间
	private String fixture;
	
	//比赛地点
	private String venue;
	
	//一等座票价
	private double highPrice;
	
	//二等座票价
	private double middlePrice;
	
	//三等座票价
	private double lowPrice;
	
	//一等座库存
	private int highStorage;
	
	//二等座库存
	private int middleStorage;
	
	//三等座库存
	private int lowStorage;
	
	//一等座已售数量
	private int highSoldNum;
	
	//二等座已售数量
	private int middleSoldNum;
	
	//三等座已售数量
	private int lowSoldNum;
	
	//上架时间
	private String onSaleTime;
	
	//票的详情介绍
	private String details;
	
	public Ticket() {
		super();
	}

	public Ticket(int ticketId, String ticketName, String fixture,
			String venue, double highPrice, double middlePrice,
			double lowPrice, int highStorage, int middleStorage,
			int lowStorage, int highSoldNum, int middleSoldNum, int lowSoldNum,
			String onSaleTime, String details) {
		super();
		this.ticketId = ticketId;
		this.ticketName = ticketName;
		this.fixture = fixture;
		this.venue = venue;
		this.highPrice = highPrice;
		this.middlePrice = middlePrice;
		this.lowPrice = lowPrice;
		this.highStorage = highStorage;
		this.middleStorage = middleStorage;
		this.lowStorage = lowStorage;
		this.highSoldNum = highSoldNum;
		this.middleSoldNum = middleSoldNum;
		this.lowSoldNum = lowSoldNum;
		this.onSaleTime = onSaleTime;
		this.details = details;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public String getFixture() {
		return fixture;
	}

	public void setFixture(String fixture) {
		this.fixture = fixture;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public double getMiddlePrice() {
		return middlePrice;
	}

	public void setMiddlePrice(double middlePrice) {
		this.middlePrice = middlePrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public int getHighStorage() {
		return highStorage;
	}

	public void setHighStorage(int highStorage) {
		this.highStorage = highStorage;
	}

	public int getMiddleStorage() {
		return middleStorage;
	}

	public void setMiddleStorage(int middleStorage) {
		this.middleStorage = middleStorage;
	}

	public int getLowStorage() {
		return lowStorage;
	}

	public void setLowStorage(int lowStorage) {
		this.lowStorage = lowStorage;
	}

	public int getHighSoldNum() {
		return highSoldNum;
	}

	public void setHighSoldNum(int highSoldNum) {
		this.highSoldNum = highSoldNum;
	}

	public int getMiddleSoldNum() {
		return middleSoldNum;
	}

	public void setMiddleSoldNum(int middleSoldNum) {
		this.middleSoldNum = middleSoldNum;
	}

	public int getLowSoldNum() {
		return lowSoldNum;
	}

	public void setLowSoldNum(int lowSoldNum) {
		this.lowSoldNum = lowSoldNum;
	}

	public String getOnSaleTime() {
		return onSaleTime;
	}

	public void setOnSaleTime(String onSaleTime) {
		this.onSaleTime = onSaleTime;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
