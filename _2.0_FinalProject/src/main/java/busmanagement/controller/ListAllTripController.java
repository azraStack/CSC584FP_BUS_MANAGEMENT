package busmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import busmanagement.dao.BusManagementDAO;

/**
 * Servlet implementation class ListAllTripController
 */
@WebServlet("/ListAllTripController")
public class ListAllTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllTripController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("trip", BusManagementDAO.getAllTrip());
		RequestDispatcher view = request.getRequestDispatcher("admin/list_all_trip.jsp");
		view.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("trip", BusManagementDAO.getAllTrip());
		RequestDispatcher view = request.getRequestDispatcher("admin/list_all_trip.jsp");
		view.forward(request,response);
	}

}
