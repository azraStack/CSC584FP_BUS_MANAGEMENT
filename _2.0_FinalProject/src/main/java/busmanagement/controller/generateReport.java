package busmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import busmanagement.model.*;
import user.model.*;
import busmanagement.dao.BusManagementDAO;
import user.dao.*;
/**
 * Servlet implementation class generateReport
 */
@WebServlet("/generateReport")
public class generateReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generateReport() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tripid = Integer.parseInt(request.getParameter("tripid")) ;
	    

	    List<Trip> tripList = new BusManagementDAO().GenerateReport(tripid);
	    if (tripList.size() > 0) {
	      List<User> usersList = new BusManagementDAO().GetBookings(tripid);
	      request.setAttribute("userList", usersList);
	      request.setAttribute("tripList", tripList);
	      RequestDispatcher view = request.getRequestDispatcher("admin/report_trip.jsp");
	      view.forward(request, response);
	    }
	}
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tripid = Integer.parseInt(request.getParameter("tripid")) ;
	    

	    List<Trip> tripList = new BusManagementDAO().GenerateReport(tripid);
	    if (tripList.size() > 0) {
	      List<User> usersList = new BusManagementDAO().GetBookings(tripid);
	      request.setAttribute("userList", usersList);
	      request.setAttribute("tripList", tripList);
	      RequestDispatcher view = request.getRequestDispatcher("admin/report_trip.jsp");
	      view.forward(request, response);
	    }
	}
	
}
