package com.qa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import com.qa.domain.Orders;

import com.qa.utility.DBUtils;

public class DriverOrderDAO {
	
	OrdersDAO ordersDAO = new OrdersDAO();
	Orders order = new Orders();
	public static final Logger LOGGER = LogManager.getLogger();
	
	public void update(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE Delivery_Orders SET deliveryDate = GETDATE, item_delivered = true WHERE id =" + orderID);) {	
			statement.executeUpdate();
			System.out.println("Delivery has been updated!");
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
	}
	
	public List<Orders> currentDelivery(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Delivery_Orders WHERE Driver_id = ?");) {	
			List<Orders> current = new ArrayList<>();
			while (resultSet.next()) {
				current.add(ordersDAO.modelFromResultSet(resultSet));
			}
			return current;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

}
