package com.qa.domain;

import java.sql.Date;

public class Orders {

	private Long orderID;
	private Date date;
	private String address;

	public Orders(Long orderID, Date date, String address) {
		this.orderID = orderID;
		this.date = date;
		this.address = address;
	}

	public Orders(Date date, String address) {
		this.date = date;
		this.address = address;
	}

	public Orders(Long orderID, Date date) {
		this.orderID = orderID;
		this.date = date;
	}

	public Orders(Long orderID, String address) {
		this.orderID = orderID;
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderID=" + orderID + ", Date=" + date + ", Address=" + address;
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
