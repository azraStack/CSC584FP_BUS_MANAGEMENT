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
import user.model.Admin;
/**
 * Servlet implementation class LoginAdminController
 */
@WebServlet("/LoginAdminController")
public class LoginAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Admin a = new Admin();
		a.setAdminid(Integer.parseInt(request.getParameter("adminid")));
		a.setAdminpassword(request.getParameter("adminpassword"));
		
		a = UserDAO.loginAdmin(a);
		if (a.isValid())
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", a.getAdminid());
			request.setAttribute("admin", UserDAO.getAdminByAdminid(a.getAdminid()));
			
			RequestDispatcher view = request.getRequestDispatcher("admin/menu_admin.jsp");
			view.forward(request, response);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please Enter A Valid Admin ID & Password", "Error Occurred", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("admin/signin_admin");
		}
		
	}

}
