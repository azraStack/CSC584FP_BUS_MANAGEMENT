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
@WebServlet("/RegisterUserController")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
    public RegisterUserController() {
        super();
        dao = new UserDAO();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		u.setName(request.getParameter("name"));
		u.setPhoneno(request.getParameter("phoneno"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		
		dao.registerUser(u);
		//request.setAttribute(getServletName(), session);
		RequestDispatcher view = request.getRequestDispatcher("LoginUserController");
		view.forward(request, response);
	}

}
