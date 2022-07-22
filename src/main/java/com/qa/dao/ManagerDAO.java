package com.qa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.domain.Driver;
import com.qa.domain.Orders;
import com.qa.utility.DBUtils;

public class ManagerDAO {
	
	DriverDAO driverDAO = new DriverDAO();
	OrdersDAO orderDAO = new OrdersDAO();
	Driver driver = new Driver();
	public static final Logger LOGGER = LogManager.getLogger();

	public void assignDriver() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO Delivery_Orders (order_id, driver_id) " );) {	
			statement.executeUpdate();
		
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
	
	}
	
	
	public List<Driver> availableDrivers() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Drivers WHERE driver_busy = false");){
			List<Driver> available = new ArrayList<>();
			while (resultSet.next()) {
				available.add(driverDAO.modelFromResultSet(resultSet));
			}
			return available;		
			
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public List<Driver> busyDrivers() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Drivers WHERE driver_busy = true");){
			List<Driver> available = new ArrayList<>();
			while (resultSet.next()) {
				available.add(driverDAO.modelFromResultSet(resultSet));
			}
			return available;		
			
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public List<Orders> openOrders(){
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE order_picked = false");){
			List<Orders> noDriver = new ArrayList<>();
			while(resultSet.next()) {
				noDriver.add(orderDAO.modelFromResultSet(resultSet));
			}
			return noDriver;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public List<Orders> ClosedOrders(){
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE order_picked = True");){
			List<Orders> noDriver = new ArrayList<>();
			while(resultSet.next()) {
				noDriver.add(orderDAO.modelFromResultSet(resultSet));
			}
			return noDriver;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
}
