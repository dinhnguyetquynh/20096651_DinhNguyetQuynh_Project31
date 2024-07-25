package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class ProductFilterServlet
 */
@WebServlet("/ProductFilterServlet")
public class ProductFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strBrand = request.getParameter("brand");
		String strPrice = request.getParameter("price");
		try {
			List<Product> list =ProductDAO.filterProducts(strBrand, strPrice);
			request.setAttribute("ds", list);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Trangchu.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			System.out.println("Loi khong filter duoc"+e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
