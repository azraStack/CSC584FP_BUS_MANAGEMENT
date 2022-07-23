package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;

@WebServlet("/UserMenuController")
public class UserMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserMenuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("user", UserDAO.getUserById(id));
		RequestDispatcher view = request.getRequestDispatcher("user/menu_user.jsp");
		view.forward(request, response);
	}
}
