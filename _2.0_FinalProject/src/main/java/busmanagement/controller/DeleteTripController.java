package busmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import busmanagement.dao.BusManagementDAO;


@WebServlet("/DeleteTripController")
public class DeleteTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private BusManagementDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTripController() {
        super();
        dao = new BusManagementDAO();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tripid = Integer.parseInt(request.getParameter("tripid"));
		dao.deleteTripByTripId(tripid);
		
		RequestDispatcher view = request.getRequestDispatcher("ListAllTripController");
		view.forward(request,response);
	}


}
