package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectMariaDB.connectDB;
import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class ProductListController
 */
@WebServlet("/ProductListController")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//		List<Product> list = (List<Product>) session.getAttribute("productList");
//		if(list==null) {
//			list = ProductDAO.queryProducts();
//			session.setAttribute("productList", list);
//		}
//		
//		request.setAttribute("ds", list);
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Trangchu.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
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
        request.getRequestDispatcher("Trangchu.jsp").forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
