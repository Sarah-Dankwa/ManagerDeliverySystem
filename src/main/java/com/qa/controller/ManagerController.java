package com.qa.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.dao.ManagerDAO;
import com.qa.domain.Driver;
import com.qa.domain.Orders;
import com.qa.utility.Utils;

public class ManagerController {

	public static final Logger LOGGER = LogManager.getLogger();

	private ManagerDAO managerDAO;
	private Utils utils;

	public ManagerController(ManagerDAO managerDAO, Utils utils) {
		super();
		this.managerDAO = managerDAO;
		this.utils = utils;
	}

	public List<Driver> availableDrivers() {
		List<Driver> drivers = ManagerDAO.availableDrivers();
		for (Driver driver : drivers) {
			LOGGER.info(driver);
		}
		return drivers;

	}

	public List<Driver> busyDrivers() {
		List<Driver> drivers = ManagerDAO.busyDrivers();
		for (Driver driver : drivers) {
			LOGGER.info(driver);
		}
		return drivers;

	}

	public List<Orders> openOrders() {
		List<Orders> orders = ManagerDAO.openOrders();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;

	}
	
	public List<Orders> closedOrders(){
		List<Orders> orders = ManagerDAO.closedOrders();
		for (Orders order : prders) {
			LOGGER.info(order);
		}
		return orders;
	}
	
	
	public 

}
