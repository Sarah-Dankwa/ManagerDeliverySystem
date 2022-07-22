package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.controller.ManagerController;
import com.qa.dao.DriverDAO;
import com.qa.dao.ManagerDAO;
import com.qa.utility.DBUtils;
import com.qa.utility.Utils;

public class MDS {

	public static final Logger LOGGER = LogManager.getLogger();

	private final DriverController drivers;
	private final ManagerController managers;
	private final Utils utils;

	public MDS() {
		this.utils = new Utils();
		final DriverDAO drivDAO = new DriverDAO();
		this.drivers = new DriverController(drivDAO, utils);
		final ManagerDAO manaDAO = new ManagerDAO();
		this.managers = new ManagerController(manaDAO, utils);

	}

	public void mdsSystem() {
		LOGGER.info("Welcome to the delivery management system");
		DBUtils.connect();
		
		Domain domain = null;
		do {
			LOGGER.info("Are you a manager or driver?");
			Domain.printDomains();
			
			domain = Domain.getDomain(utils);
			
			domainAction(domain);
			
		} while (domain =/= Domain.STOP);
	}

	private void domainAction(Domain domain) {
		boolean changeDomain = false;
		do {
			
			Crud
		}
	}

}
