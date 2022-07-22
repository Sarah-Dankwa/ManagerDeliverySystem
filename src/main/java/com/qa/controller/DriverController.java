package com.qa.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.utility.*;

import com.qa.dao.DriverDAO;


public class DriverController {

	public static final Logger LOGGER = LogManager.getLogger();

	DriverDAO DriverDAO = new DriverDAO();
	Utils utils = new Utils();



	public DriverController(DriverDAO driverDAO) {
		super();
		this.DriverDAO = driverDAO;
		
	}

	public void read() {
		LOGGER.info("Please enter your Driver ID");
		Long driverID = utils.getLong();
		DriverDAO.read(driverID);
	}

	public void update() {
		LOGGER.info("Please enter your Driver ID");
		Long driverID = utils.getLong();	
		DriverDAO.update(driverID);

	}

}

