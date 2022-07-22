package com.qa.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManagerDAO {

	public void assignDriver() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO Delivery_Orders (order_id, driver_id) " ;) {	
			statement.setLong(1, Orders.getId());
			statement.executeUpdate();
			return read(driver.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Driver modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("driver_id");
		String firstName = resultSet.getString("first_name");
		String surname = resultSet.getString("surname");
		return new Customer(id, firstName, surname);
	}
	
	public List<Driver> availableDrivers() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Drivers WHERE driver_busy = false");){
			List<Driver> available = new ArrayList<>();
			while (resultSet.next()) {
				available.add(modelFromResultSet(resultSet));
			}
			return available;		
			
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public List<Orders> openOrders(){
		try (Connection connection = DBUtils.getInstance().getCnnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE order_picked = false");){
			List<Orders> noDriver = new ArrayList<>();
			while(resultSet.next()) {
				noDriver.add(modelFromResultSet(resultSet));
			}
			return noDriver
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
}
