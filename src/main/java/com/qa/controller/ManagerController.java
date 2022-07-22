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

	ManagerDAO managerDAO = new ManagerDAO();
	private Utils utils;

	public ManagerController(ManagerDAO managerDAO, Utils utils) {
		super();
		this.managerDAO = managerDAO;
		this.utils = utils;
	}

	public void assignDriver() {
		LOGGER.info("Please enter Order ID:");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter Driver ID:");
		Long driver_id = utils.getLong();
		managerDAO.assignDriver(order_id, driver_id);
		LOGGER.info("Driver assigned to delivery");
	}

	public List<Driver> availableDrivers() {
		List<Driver> drivers = managerDAO.availableDrivers();
		for (Driver driver : drivers) {
			LOGGER.info(driver);
		}
		return drivers;

	}

	public List<Driver> busyDrivers() {
		List<Driver> drivers = managerDAO.busyDrivers();
		for (Driver driver : drivers) {
			LOGGER.info(driver);
		}
		return drivers;

	}

	public List<Orders> openOrders() {
		List<Orders> orders = managerDAO.openOrders();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;

	}

	public List<Orders> closedOrders() {
		List<Orders> orders = managerDAO.ClosedOrders();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	public void updateDriver() {
		LOGGER.info("Please enter the delivery ID:");
		Long delivery_id = utils.getLong();
		LOGGER.info("Please enter a driver ID:");
		Long driver_id = utils.getLong();
		managerDAO.updateDriver(delivery_id, driver_id);
		LOGGER.info("Delivery updated");

	}

	public void deleteOrder() {
		LOGGER.info("Please enter delivery ID:");
		Long delivery_id = utils.getLong();
		managerDAO.deleteOrder(delivery_id);
		LOGGER.info("Delivery deleted");
	}

}
