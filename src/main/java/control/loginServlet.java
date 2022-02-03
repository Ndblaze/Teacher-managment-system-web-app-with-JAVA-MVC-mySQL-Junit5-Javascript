package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDAO;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AdminHome.jsp");
			dispatcher.include(request, response);			
		} else {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}		
	}  
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		System.out.println( type);
		UserDAO userDAO = new UserDAO();
		try {
			User user ;
			if (type.contains("Enseignant") ) {
				 user = userDAO.checkLoginP(username, password, type);
		  	}else {
				 user = userDAO.checkLogin(username, password, type);
			}
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);			
				if (type.contains("Enseignant") ) {
					System.out.println("I'm a teacher ");
					dispatcher = request.getRequestDispatcher("/Prof/ProfHome.jsp");
					dispatcher.forward(request, response);
				}
				else if (type.contains("Administrateur")) {	
					System.out.println("I'm an Admin ");
					dispatcher = request.getRequestDispatcher("/Admin/AdminHome.jsp");
					dispatcher.forward(request, response);				
				}			
			} else {
				PrintWriter out = response.getWriter();
				dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.include(request, response);
				out.print("<center><h2> This user doesnt't exist !!<h2>");
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
