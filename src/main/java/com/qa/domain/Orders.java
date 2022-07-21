package com.qa.domain;

import java.sql.Date;

public class Orders {

	private int orderID;
	private Date date;
	private String address;

	public Orders(int orderID, Date date, String address) {
		this.orderID = orderID;
		this.date = date;
		this.address = address;
	}

	public Orders(Date date, String address) {
		this.date = date;
		this.address = address;
	}

	public Orders(int orderID, Date date) {
		this.orderID = orderID;
		this.date = date;
	}

	public Orders(int orderID, String address) {
		this.orderID = orderID;
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderID=" + orderID + ", Date=" + date + ", Address=" + address;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
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
