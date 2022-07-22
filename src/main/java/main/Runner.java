package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		MDS mds - new MDS();
		mds.mdsSystem();
		LOGGER.info("PIss off");

	}

}
