package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.model.User;

@WebServlet("/UpdateUserController")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
    public UpdateUserController() {
        super();
        dao = new UserDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("user", UserDAO.getUserById(id));
		RequestDispatcher view = request.getRequestDispatcher("user/update_user.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				User u = new User();
				
				u.setId(Integer.parseInt(request.getParameter("id")));
				u.setName(request.getParameter("name"));
				u.setPhoneno(request.getParameter("phoneno"));
				u.setEmail(request.getParameter("email"));
				
				//DAO
				dao.UpdateUser(u);
				
				//forward
				request.setAttribute("user", UserDAO.getUserById(u.getId()));
				RequestDispatcher view = request.getRequestDispatcher("user/menu_user.jsp");
				view.forward(request, response);
	}

}
