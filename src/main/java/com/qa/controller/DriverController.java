package com.qa.controller;

	import java.util.List;

import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

	import com.qa.utility.*;
	
	import com.qa.dao.DriverDAO;
	import com.qa.domain.Driver;


public class DriverController {
	
		public static final Logger LOGGER = LogManager.getLogger();

		DriverDAO DriverDAO = new DriverDAO();
		Utils utils = new Utils();



		public DriverController(DriverDAO driverDAO) {
			super();
			this.DriverDAO = driverDAO;
			
		}

		public List<Driver> read() {
			LOGGER.info("Please enter your Driver ID");
			Long driverID = utils.getLong();
			List<Driver> driver = DriverDAO.read(driverID);
			return driver;
		}

		public void update() {
			LOGGER.info("Please enter your Driver ID");
			Long driverID = utils.getLong();	
			DriverDAO.update(driverID);

		}

}
