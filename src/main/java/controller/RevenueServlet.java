package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;

/**
 * Servlet implementation class RevenueServlet
 */
@WebServlet("/revenue")
public class RevenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevenueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	      
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dateStr = request.getParameter("date");
        LocalDate date;
        double totalRevenue;
        try {
            date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ngày không hợp lệ");
            return;
        }
        
        try {
           totalRevenue = OrderDAO.getTotalRevenueInDay(date);
            
        } catch (SQLException e) {
            throw new ServletException("Lỗi khi tính doanh thu", e);
        }
        request.setAttribute("tong",totalRevenue );
        request.getRequestDispatcher("/DoanhThu.jsp").forward(request, response);
	}

}
