package com.qa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.domain.Driver;
import com.qa.utility.DBUtils;


public class DriverDAO {

	public static final Logger LOGGER = LogManager.getLogger();
	
	public Driver modelFromResultSet(ResultSet resultSet) throws SQLException {
		String firstName = resultSet.getString("first_name");
		String surname = resultSet.getString("surname");
		return new Driver(firstName, surname);
	}
	
	public Driver read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public void update(Long driverID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE Delivery_Orders SET deliveryDate = GETDATE, item_delivered = true WHERE id = " + driverID);) {	
			statement.executeUpdate();
			System.out.println("Delivery has been updated!");
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
	}
	
	
}
