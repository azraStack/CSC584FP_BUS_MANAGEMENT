package busmanagement.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import busmanagement.dao.*;
import busmanagement.model.*;

/**
 * Servlet implementation class UpdateTripController
 */
@WebServlet("/UpdateTripController")
public class UpdateTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusManagementDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTripController() {
        super();
        dao = new BusManagementDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tripid = Integer.parseInt(request.getParameter("tripid"));
		request.setAttribute("trip", BusManagementDAO.getTripByTripId(tripid));
		RequestDispatcher view = request.getRequestDispatcher("admin/update_trip.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Trip trip = new Trip();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("hh:mm");
		
		try {
			Date parsedDate = format.parse(request.getParameter("date"));
			trip.setDate(parsedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			Date parsedTime = format2.parse(request.getParameter("time"));
			trip.setTime(parsedTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		trip.setTripid(Integer.parseInt(request.getParameter("tripid")));
		trip.setAdminid((int) request.getSession().getAttribute("currentSessionUser"));
		trip.setBusid(Integer.parseInt(request.getParameter("busid")));;
		trip.setDeparture(request.getParameter("departure"));
		trip.setDestination(request.getParameter("destination"));
		trip.setPrice(Double.parseDouble(request.getParameter("price")));
		
		dao.UpdateTrip(trip);
		
		RequestDispatcher view = request.getRequestDispatcher("ListAllTripController");
		view.forward(request, response);
		
	}

}
