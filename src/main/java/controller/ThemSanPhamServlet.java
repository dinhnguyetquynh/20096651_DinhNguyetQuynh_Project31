package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class ThemSanPhamServlet
 */
@WebServlet("/ThemSanPhamServlet")
public class ThemSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("Name");
		String des = request.getParameter("Description");
		String strPrice = request.getParameter("Price");
		float price = Float.parseFloat(strPrice);
		String strStock = request.getParameter("Stock");
		int stock = Integer.parseInt(strStock);
		String img = request.getParameter("imgURL");
		String strCate = request.getParameter("strCate");
		String strBrand = request.getParameter("strBrand");
		
		Product product = new Product(name, des, price, stock, img, strCate, strBrand);
		try {
			ProductDAO.addProduct(product);
			System.out.println("Them thanh cong");
			response.sendRedirect("/20096651_DinhNguyetQuynh_Project31/reloadProducts");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong them sp vao db" + e.getMessage());
			e.printStackTrace();
			
		}
	
	}

}
