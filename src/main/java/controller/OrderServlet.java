package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.OrderDAO;
import model.Cart;
import model.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		String paymentMethod = request.getParameter("paymentMethod");
		String pay = null;
		if(paymentMethod.equals("CashOnDelivery")) {
			pay = "CashOnDelivery";
		}else if(paymentMethod.equals("CreditCard")) {
			pay="CreditCard";
		}
		Cart cart =null;
		try {
			cart = CartDAO.getCartByUserId(userId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(cart!=null && !cart.getCartDetails().isEmpty()) {
			Order order = new Order();
			order.setUserId(userId);
			order.setOderDate(LocalDateTime.now());
			order.setTotalAmount(cart.getTotalAll());
			order.setStatus("Pending");
			order.setPayMethod(pay);
			
			try {
				OrderDAO.createOrder(order, cart);
				//remove cart
				response.sendRedirect("orderSuccess.jsp");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("/20096651_DinhNguyetQuynh_Project31/CartController?userId="+userId);
		}
		
	}

}
