package busmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import busmanagement.dao.*;
import busmanagement.model.*;
import user.dao.UserDAO;
@WebServlet("/SearchTripController")
public class SearchTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusManagementDAO dao;
    public SearchTripController() {
        super();
        dao = new BusManagementDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("user/search_trip.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departure = request.getParameter("departure");
		String destination = request.getParameter("destination");
		
		request.setAttribute("trip", BusManagementDAO.searchTrip(departure, destination));
		
		RequestDispatcher view = request.getRequestDispatcher("user/list_all_trip2.jsp");
		view.forward(request, response);
	}

}
