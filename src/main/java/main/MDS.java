package main;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.controller.DriverController;
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
		this.drivers = new DriverController(drivDAO);
		final ManagerDAO manaDAO = new ManagerDAO();
		this.managers = new ManagerController(manaDAO, utils);

	}

	public void mdsSystem() throws FileNotFoundException, SQLException {
		LOGGER.info("Welcome to the delivery management system");
		DBUtils.connect();
		DBUtils.createTables();

		// do {
		LOGGER.info("Are you a manager or driver?");
		// Uitls.getString()
		if (utils.getString().contentEquals("manager")) {
			LOGGER.info("What would you like to do? \n 1. Assign Driver \n 2. See all available Drivers"
					+ "\n 3. See all busy drivers \n 4. see all open orders /n 5. see all closed orders"
					+ "\n 6. Delete an order \n 7. Change driver on a delivery ");
			if (utils.getLong().equals(1)) {
				managers.assignDriver();
			} else if (utils.getLong().equals(2)) {
				managers.availableDrivers();
			} else if (utils.getLong().equals(3)) {
				managers.busyDrivers();
			} else if (utils.getLong().equals(4)) {
				managers.openOrders();
			} else if (utils.getLong().equals(5)) {
				managers.closedOrders();
			} else if (utils.getLong().equals(6)) {
				managers.deleteOrder();
			} else if (utils.getLong().equals(7)) {
				managers.updateDriver();
			}
		} else if (utils.getString().contentEquals("driver")) {
			System.out.println("goodbye");
		}
		// if driver print their limited ones.

//			// change what is printed edit, domain actions / action.print()
//			Domain.printDomains();
//			
//			domain = Domain.getDomain(utils);
//			
//			domainAction(domain);
////			
////		} while (domain =/= Domain.STOP);
//	}
//
//	private void domainAction(Domain domain) {
//		boolean changeDomain = false;
//		do {
//			
//			Crud
//		}
	}

}
