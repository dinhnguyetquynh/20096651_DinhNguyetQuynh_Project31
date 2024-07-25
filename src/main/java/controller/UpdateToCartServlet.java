package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import model.Cart;

/**
 * Servlet implementation class UpdateToCartServlet
 */
@WebServlet("/UpdateToCartServlet")
public class UpdateToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			if(action.equals("Edit")) {
				int cartDetailId = Integer.parseInt(request.getParameter("cd_id"));
				int newQty = Integer.parseInt(request.getParameter("quantity"));
				
				//cập nhật CartDetail
				CartDAO.updateCartDetail(cartDetailId, newQty);
				
			}else if(action.equals("Delete")) {
				int cartDetailId = Integer.parseInt(request.getParameter("cd_id"));
				
				CartDAO.deleteCartDetail(cartDetailId);
				
			}
			
			//Lấy lại giỏ hàng sau khi update hoặc xóa
			HttpSession session = request.getSession();
			int userId = (Integer)session.getAttribute("userId");
			Cart cart = CartDAO.getCartByUserId(userId);
			request.setAttribute("cart", cart);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.getRequestDispatcher("TrangGioHang.jsp").forward(request, response);
		
	}

}
