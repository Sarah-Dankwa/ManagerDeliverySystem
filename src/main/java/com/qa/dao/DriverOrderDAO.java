
public class DriverOrderDAO {
	
	public DriverOrder update(Driver driver) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE Delivery_Orders SET deliveryDate = GETDATE, item_delivered = true WHERE id = ?");) {	
			statement.setLong(1, Orders.getId());
			statement.executeUpdate();
			return read(Orders.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public DriverOrder currentDelivery(Driver driver) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Delivery_Orders WHERE item_delivered = false");) {	
			statement.executeUpdate();
			return read(Orders.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

}
