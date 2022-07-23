package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.*;
import user.dao.*;

/**
 * Servlet implementation class UpdateAdminController
 */
@WebServlet("/UpdateAdminController")
public class UpdateAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminController() {
        super();
        dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int adminid = Integer.parseInt(request.getParameter("adminid"));
		request.setAttribute("admin", UserDAO.getAdminByAdminid(adminid));
		RequestDispatcher view = request.getRequestDispatcher("admin/update_admin.jsp");
		view.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		
		admin.setAdminid(Integer.parseInt(request.getParameter("adminid")));
		admin.setAdminname(request.getParameter("adminname"));
		admin.setAdminphoneno(request.getParameter("adminphoneno"));
		admin.setAdminemail(request.getParameter("adminemail"));
		
		//DAO
		dao.UpdateAdmin(admin);
		
		//forward
		request.setAttribute("admin", UserDAO.getAdminByAdminid(admin.getAdminid()));
		RequestDispatcher view = request.getRequestDispatcher("admin/menu_admin.jsp");
		view.forward(request, response);
	}

}
