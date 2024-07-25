package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectMariaDB.connectDB;
import model.Cart;
import model.CartDetail;
import model.Order;

public class OrderDAO {
	public static void createOrder(Order order, Cart cart) throws SQLException {
		Connection connect = connectDB.getConnection();
		
        String insertOrderSQL = "INSERT INTO Orders (UserID, OrderDate, TotalAmount, Status,PayMethod) VALUES (?, ?, ?, ?,?)";
        String insertOrderDetailSQL = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitPrice, TotalPrice) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement orderStatement = connect.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS)) {
            orderStatement.setInt(1, order.getUserId());
            orderStatement.setTimestamp(2, java.sql.Timestamp.valueOf(order.getOderDate()));
            orderStatement.setDouble(3, order.getTotalAmount());
            orderStatement.setString(4, order.getStatus());
            orderStatement.setString(5, order.getPayMethod());
            int affectedRows = orderStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Tạo đơn hàng thất bại, không có hàng nào bị ảnh hưởng.");
            }

            try (ResultSet generatedKeys = orderStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long orderId = generatedKeys.getLong(1);

                    try (PreparedStatement orderDetailStatement = connect.prepareStatement(insertOrderDetailSQL)) {
                        for (CartDetail detail : cart.getCartDetails()) {
                            orderDetailStatement.setLong(1, orderId);
                            orderDetailStatement.setInt(2, detail.getProductId());
                            orderDetailStatement.setInt(3, detail.getQuantity());
                            orderDetailStatement.setDouble(4, detail.getUnitPrice());
                            orderDetailStatement.setDouble(5, detail.getTotalPrice());
                            orderDetailStatement.addBatch();
                        }

                        orderDetailStatement.executeBatch();
                    }
                } else {
                    throw new SQLException("Tạo đơn hàng thất bại, không có ID nào được lấy.");
                }
            }
        }
    }
	
	public static List<Order> getOrdersByUserId(int userId) throws SQLException{
		List<Order> orders = new ArrayList<Order>();
		Connection connection = connectDB.getConnection();
		String sql ="select * from Orders where UserID=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			 Order order = new Order(
		               rs.getInt("OrderID"),
		               rs.getInt("UserID"),
		               rs.getTimestamp("OrderDate").toLocalDateTime(),
		               rs.getFloat("TotalAmount"),
		               rs.getString("Status"),
		               rs.getString("PayMethod")
		            );
		            orders.add(order);
			
		}
		 rs.close();
	     stmt.close();
	     connection.close();

	     return orders;
		
	}

}
