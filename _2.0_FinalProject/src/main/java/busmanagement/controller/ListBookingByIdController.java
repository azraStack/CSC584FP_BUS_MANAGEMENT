package busmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import busmanagement.dao.*;
@WebServlet("/ListBookingByIdController")
public class ListBookingByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusManagementDAO dao;
    public ListBookingByIdController() {
        super();
        dao = new BusManagementDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) request.getSession().getAttribute("currentSessionUser");
		
		
		request.setAttribute("booking", BusManagementDAO.listBookingById(id));
		RequestDispatcher view = request.getRequestDispatcher("user/view_booking.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
