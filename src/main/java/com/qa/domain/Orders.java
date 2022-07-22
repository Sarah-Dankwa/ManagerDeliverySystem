package com.qa.domain;

import java.sql.Date;

public class Orders {
	
	private Long orderID;
	private Date date;
	private String address;
	
	
		
	public Orders() {
		super();
	}


	public Orders(Long orderID, Date date, String address) {
		super();
		this.orderID = orderID;
		this.date = date;
		this.address = address;
	}
	
		
	public Orders(Date date, String address) {
		super();
		this.date = date;
		this.address = address;
	}


	
	@Override
	public String toString() {
		return "OrderID=" + orderID + ", date=" + date + ", address=" + address;
		
		
		
	}
	public Long getOrderID() {
		return orderID;
	}
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
