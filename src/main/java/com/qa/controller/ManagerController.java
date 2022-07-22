package com.qa.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.dao.ManagerDAO;
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

	public List<Driver> readAvilableDrivers() {
		List<Driver> drivers = ManagerDAO.availableDrivers();
		for (Driver drivers : drivers) {
			LOGGER.info(drivers);
		}
		return drivers;

	}

	public List<Orders> readBusyDrivers() {

		return null;

	}

	public List<Orders> readAvilableDrivers() {

		return null;

	}

}
