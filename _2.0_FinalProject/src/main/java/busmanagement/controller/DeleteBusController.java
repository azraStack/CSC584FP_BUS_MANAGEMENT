package busmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import busmanagement.dao.*;

/**
 * Servlet implementation class DeleteBusController
 */
@WebServlet("/DeleteBusController")
public class DeleteBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private BusManagementDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBusController() {
        super();
        dao = new BusManagementDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//SET VARIABLE
		int busid = Integer.parseInt(request.getParameter("busid"));
		
		//DAO
		dao.deleteBusByBusId(busid);

		//FORWARD 
		RequestDispatcher view = request.getRequestDispatcher("ListAllBusController");
		view.forward(request, response);
	}

}
