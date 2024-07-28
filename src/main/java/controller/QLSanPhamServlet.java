package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class QLSanPhamServlet
 */
@WebServlet("/QLSanPhamServlet")
public class QLSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QLSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		 List<Product> list = ProductDAO.queryProducts();
//		 request.setAttribute("ds", list);
//		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/QuanLySanPham.jsp");
//		 dispatcher.forward(request, response);
//		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.removeAttribute("ds");
		String strAction = request.getParameter("action");
		
		 if(strAction.equals("Edit")) {
			updateQuantity(request);
			response.sendRedirect("/20096651_DinhNguyetQuynh_Project31/reloadProducts");
		}else if(strAction.equals("Add")) {
			response.sendRedirect("ThemSanPham.jsp");
		}else if(strAction.equals("Delete")) {
			deleteProduct(request);
			response.sendRedirect("/20096651_DinhNguyetQuynh_Project31/reloadProducts");
		}
		 
		
	}

	private void deleteProduct(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("productId"));
		ProductDAO.deleteProduct(productId);
	}

	private void updateQuantity(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		ProductDAO.updateProductStock(productId,quantity);	
	}

}
