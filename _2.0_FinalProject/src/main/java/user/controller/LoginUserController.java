package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
//import busmanagement.dao.BusManagementDAO;
import user.dao.UserDAO;
import user.model.User;
/**
 * Servlet implementation class LoginUserController
 */
@WebServlet("/LoginUserController")
public class LoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginUserController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	RequestDispatcher view = request.getRequestDispatcher("user/sign_user.jsp");
		view.forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN DO POST");
		User u = new User();
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("password"));
		u = UserDAO.loginUser(u);
		if (u.isValid())
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", u.getId());
			request.setAttribute("user", UserDAO.getUserById(u.getId()));
			//request.setAttribute("collegeApplication", HostelManagementDAO.getCollegeApplicationByStu_no(s.getStu_no()));
			
			RequestDispatcher view = request.getRequestDispatcher("user/menu_user.jsp");
			view.forward(request, response);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please Enter A Valid User ID & Password", "Error Occurred", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("user/signin_user.jsp");
		}
	}

}
