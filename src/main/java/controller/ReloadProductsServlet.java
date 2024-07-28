package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectMariaDB.connectDB;
import model.Product;

/**
 * Servlet implementation class ReloadProductsServlet
 */
@WebServlet("/reloadProducts")
public class ReloadProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    private static final String DB_URL = "jdbc:mariadb://localhost:3306/db_perfume?useUnicode=true&characterEncoding=utf8mb4";
//    private static final String DB_USER = "username";
//    private static final String DB_PASSWORD = "password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ngăn trình duyệt lưu trữ bộ nhớ cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0); // Proxies

        List<Product> products = new ArrayList<>();
        try (Connection conn = connectDB.getConnection()) {
            String sql = "select Product_ID,Name,Description,Price, Stock, imgURL from Products";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                	int id= rs.getInt("Product_ID");
    				String name = rs.getString("Name");
    				String description = rs.getString("Description");
    				float price = rs.getFloat("Price");
    				int stock = rs.getInt("Stock");
    				String imgURL = rs.getString("imgURL");
    				//Định dạng price
    				
    				
    				Product product = new Product(id, name, description, price, stock, imgURL);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("ds", products);
        request.getRequestDispatcher("QuanLySanPham.jsp").forward(request, response);
    }
}
