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

/**
 * Servlet implementation class AddBusController
 */
@WebServlet("/AddBusController")
public class AddBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BusManagementDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBusController() {
        super();
        dao = new BusManagementDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("admin/add_bus.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Bus bus = new Bus();
		
		bus.setBusid(Integer.parseInt(request.getParameter("busid")));
		bus.setBuscompany(request.getParameter("buscompany"));
		bus.setDrivername(request.getParameter("drivername"));
		
		dao.addBus(bus);
		
		request.setAttribute("bus", BusManagementDAO.getAllBus());
		RequestDispatcher view = request.getRequestDispatcher("admin/list_all_bus.jsp");
		view.forward(request,response);
	}

}
