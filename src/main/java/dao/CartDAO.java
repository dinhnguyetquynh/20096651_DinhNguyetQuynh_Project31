package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectMariaDB.connectDB;
import model.Cart;
import model.CartDetail;

public class CartDAO {
	public static void addToCart(int userId, int productId, int quantity) throws SQLException {
        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connect = connectDB.getConnection();

            // Kiểm tra xem người dùng đã có giỏ hàng chưa
            String checkCartQuery = "SELECT CartID FROM Cart WHERE UserID = ?";
            ps = connect.prepareStatement(checkCartQuery);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            int cartId;
            if (rs.next()) {
                cartId = rs.getInt("CartID");
            } else {
                // Nếu chưa có giỏ hàng, tạo giỏ hàng mới
                String createCartQuery = "INSERT INTO Cart (UserID, totalAll) VALUES (?, 0)";
                ps = connect.prepareStatement(createCartQuery, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
                rs.next();
                cartId = rs.getInt(1);
            }

            // Lấy giá sản phẩm từ bảng Products
            String getPriceQuery = "SELECT Price FROM Products WHERE Product_ID = ?";
            ps = connect.prepareStatement(getPriceQuery);
            ps.setInt(1, productId);
            rs = ps.executeQuery();

            float unitPrice = 0;
            if (rs.next()) {
                unitPrice = rs.getFloat("Price");
            }

            // Thêm sản phẩm vào chi tiết giỏ hàng
            String addProductQuery = "INSERT INTO CartDetail (CartID, productID, quantity, unitPrice, totalPrice) VALUES (?, ?, ?, ?, ?)";
            ps = connect.prepareStatement(addProductQuery);
            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            ps.setFloat(4, unitPrice);
            ps.setFloat(5, unitPrice * quantity);
            ps.executeUpdate();

            // Cập nhật tổng tiền trong giỏ hàng
            String updateTotalQuery = "UPDATE Cart SET totalAll = (SELECT SUM(totalPrice) FROM CartDetail WHERE CartID = ?) WHERE CartID = ?";
            ps = connect.prepareStatement(updateTotalQuery);
            ps.setInt(1, cartId);
            ps.setInt(2, cartId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }
    }
	
	public static Cart getCartByUserId(int userId) throws SQLException {
        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cart cart = null;

        try {
            connect = connectDB.getConnection();

            // Lấy thông tin giỏ hàng
            String cartQuery = "SELECT CartID, totalAll FROM Cart WHERE UserID = ?";
            ps = connect.prepareStatement(cartQuery);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            if (rs.next()) {
                int cartId = rs.getInt("CartID");
                float totalAll = rs.getFloat("totalAll");
                cart = new Cart(cartId, userId, totalAll);

                // Lấy thông tin chi tiết giỏ hàng //moi sua
                String cartDetailQuery = "SELECT cd.cartDetail_ID, cd.productID, cd.quantity, cd.unitPrice, cd.totalPrice, p.Name, p.imgURL " +
                                         "FROM CartDetail cd JOIN Products p ON cd.productID = p.Product_ID " +
                                         "WHERE cd.CartID = ?";
                ps = connect.prepareStatement(cartDetailQuery);
                ps.setInt(1, cartId);
                ResultSet rsDetail = ps.executeQuery();

                while (rsDetail.next()) { 
                    int cartDetailId = rsDetail.getInt("cartDetail_ID");
                    int productId = rsDetail.getInt("productID");
                    int quantity = rsDetail.getInt("quantity");
                    float unitPrice = rsDetail.getFloat("unitPrice");
                    float totalPrice = rsDetail.getFloat("totalPrice");
                    String productName = rsDetail.getString("Name");
                    String imgURL = rsDetail.getString("imgURL");

                    CartDetail cartDetail = new CartDetail(cartDetailId, cartId, productId, quantity, unitPrice, totalPrice, productName, imgURL);
                    cart.addCartDetail(cartDetail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }

        return cart;
    }
	
	public static void updateCartDetail(int cartDetailId, int newQuantity) throws SQLException {
        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
			connect = connectDB.getConnection();
			//cập nhật số lượng và thành tiền cho CartDetail
			String updateCartDetailQuery ="UPDATE cartdetail set quantity =?, totalPrice = unitPrice*? where cartDetail_ID =?";
			ps = connect.prepareStatement(updateCartDetailQuery);
			ps.setInt(1, newQuantity);
			ps.setInt(2, newQuantity);
			ps.setInt(3,cartDetailId);
			ps.executeUpdate();
			
			// Lấy CartID từ CartDetail
			String getCartIdQuery ="Select CartID from cartdetail where cartDetail_ID =?";
			ps = connect.prepareStatement(getCartIdQuery);
			ps.setInt(1, cartDetailId);
			rs = ps.executeQuery();
			int cartId = 0;
			if(rs.next()) {
				cartId = rs.getInt("CartID");
				
			}
			
			// Cập nhật tổng tiền trong Cart
			String updateTotalQuery = "UPDATE cart SET totalAll = (SELECT SUM(totalPrice) from cartdetail where CartID =?) where CartID=?";
			ps = connect.prepareStatement(updateTotalQuery);
			ps.setInt(1, cartId);
			ps.setInt(2, cartId);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps!=null) ps.close();
			if(connect !=null) connect.close();
		}
    }
	
	public static void deleteCartDetail(int cartDetailId) throws SQLException {
        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connect = connectDB.getConnection();

            // Lấy CartID từ CartDetail
            String getCartIdQuery = "SELECT CartID FROM CartDetail WHERE cartDetail_ID = ?";
            ps = connect.prepareStatement(getCartIdQuery);
            ps.setInt(1, cartDetailId);
            rs = ps.executeQuery();
            int cartId = 0;
            if (rs.next()) {
                cartId = rs.getInt("CartID");
            }

            // Xóa CartDetail
            String deleteCartDetailQuery = "DELETE FROM CartDetail WHERE cartDetail_ID = ?";
            ps = connect.prepareStatement(deleteCartDetailQuery);
            ps.setInt(1, cartDetailId);
            ps.executeUpdate();

            // Cập nhật tổng tiền trong Cart
            String updateTotalQuery = "UPDATE Cart SET totalAll = (SELECT SUM(totalPrice) FROM CartDetail WHERE CartID = ?) WHERE CartID = ?";
            ps = connect.prepareStatement(updateTotalQuery);
            ps.setInt(1, cartId);
            ps.setInt(2, cartId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) ps.close();
            if (connect != null) connect.close();
        }
    }

}
