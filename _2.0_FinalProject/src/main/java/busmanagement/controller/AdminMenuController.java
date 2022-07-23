package busmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.*;
/**
 * Servlet implementation class AdminMenuController
 */
@WebServlet("/AdminMenuController")
public class AdminMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMenuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int adminid = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("admin", UserDAO.getAdminByAdminid(adminid));
		RequestDispatcher view = request.getRequestDispatcher("admin/menu_admin.jsp");
		view.forward(request, response);	}
}
