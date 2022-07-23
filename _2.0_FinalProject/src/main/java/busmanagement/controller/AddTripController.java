package busmanagement.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import busmanagement.dao.*;
import busmanagement.model.*;
import user.dao.*;
import user.model.*;
/**
 * Servlet implementation class AddTripController
 */
@WebServlet("/AddTripController")
public class AddTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BusManagementDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTripController() {
        super();
        dao = new BusManagementDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int adminid = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("admin", UserDAO.getAdminByAdminid(adminid));
		request.setAttribute("trip", BusManagementDAO.getTripByTripId(adminid));
		request.setAttribute("bus", BusManagementDAO.getBusByBusId(adminid));
		request.setAttribute("bus", BusManagementDAO.getAllBus());
		//booking takda
		RequestDispatcher view = request.getRequestDispatcher("admin/add_trip.jsp");
		view.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Trip trip = new Trip();
		Admin admin = new Admin();
		Bus	bus = new Bus();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parsedDate = format.parse(request.getParameter("date"));
			trip.setDate(parsedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleDateFormat format2 = new SimpleDateFormat("hh:mm");
		try {
			Date parsedTime = format2.parse(request.getParameter("time"));
			trip.setTime(parsedTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//trip.setTrip_session(request.getParameter("trip_session"));
		//trip.setTripid(Integer.parseInt(request.getParameter("tripid")));
		trip.setDeparture(request.getParameter("departure"));
		trip.setDestination(request.getParameter("destination"));
		trip.setPrice(Double.parseDouble(request.getParameter("price")));
		admin.setAdminid((int) request.getSession().getAttribute("currentSessionUser"));
		request.setAttribute("admin", UserDAO.getAdminByAdminid(admin.getAdminid()));
		bus.setBusid(Integer.parseInt(request.getParameter("busid")));
		request.setAttribute("trip", BusManagementDAO.getTripByTripId(bus.getBusid()));
		
		dao.AddTrip(trip, admin, bus);
		
		RequestDispatcher view = request.getRequestDispatcher("admin/menu_admin.jsp");
		view.forward(request, response);
		
	}

}
