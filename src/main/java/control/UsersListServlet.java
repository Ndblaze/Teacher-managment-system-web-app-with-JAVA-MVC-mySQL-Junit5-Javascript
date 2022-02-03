package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDAO;

@WebServlet("/UsersListServlet")
public class UsersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
    public UsersListServlet() {
        super();       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {			
			UserDAO userDAO = new UserDAO();
			ArrayList<User> usersList = null;			
			try {				
				usersList = userDAO.getUsers();				
			} catch (InstantiationException | IllegalAccessException e) {				
				e.printStackTrace();
			}			
			request.setAttribute("usersList",usersList);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listUsers.jsp");
			dispatcher.include(request, response);			
		} else {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}			
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
}
