package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAO();  
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		User user = userDAO.validateUser(phone, password);
		
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserID());
			session.setAttribute("user", user);
			if(user.isUserRole()==true) {
				response.sendRedirect("/20096651_DinhNguyetQuynh_Project31/ProductListController");
				
			}else {
				response.sendRedirect("QuanLySanPham.jsp");
			}
		}else {
			request.setAttribute("error", "số điện thoại hoặc mật khẩu không dung");
			request.getRequestDispatcher("Dangnhap.jsp").forward(request, response);
			
		}
	}

}
