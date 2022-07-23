package busmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busmanagement.dao.*;
import busmanagement.model.*;
import user.model.*;
import user.dao.*;
@WebServlet("/BookingTripController")
public class BookingTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusManagementDAO dao;  

    public BookingTripController() {
        super();
        dao = new BusManagementDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) request.getSession().getAttribute("currentSessionUser");
		int tripid = Integer.parseInt(request.getParameter("tripid"));
		request.setAttribute("user", UserDAO.getUserById(id));
		request.setAttribute("trip", BusManagementDAO.getTripByTripId(tripid));
		RequestDispatcher view = request.getRequestDispatcher("user/add_booking_trip.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Booking b = new Booking();
		HttpSession session = request.getSession(true);
		b.setId((int)session.getAttribute("currentSessionUser"));
		b.setTripid(Integer.parseInt(request.getParameter("tripid")));
		dao.BookTrip(b);
		
		int id = (int)session.getAttribute("currentSessionUser"); 
		request.setAttribute("booking", BusManagementDAO.listBookingById(id));
		RequestDispatcher view = request.getRequestDispatcher("/user/view_booking.jsp");
		view.forward(request, response);
	}

}
