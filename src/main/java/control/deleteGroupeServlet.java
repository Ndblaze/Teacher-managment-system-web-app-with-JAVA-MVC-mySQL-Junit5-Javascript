package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDAO;

@WebServlet("/deleteGroupeServlet")
public class deleteGroupeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    public deleteGroupeServlet() {
        super();       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {			
			UserDAO userDAO = new UserDAO();
			User user = null;
			String id = request.getParameter("userid");
			try {
				user = userDAO.getGroup(id);
				request.setAttribute("user",user);				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/deleteGroupe.jsp");
				dispatcher.include(request, response);				
			} catch (InstantiationException | IllegalAccessException e) {				
				e.printStackTrace();
			}						
		} else {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id") ;
		String group = request.getParameter("group");
		UserDAO myUserDAO = new UserDAO();
		UserDAO userDAO = new UserDAO();
		try {
			myUserDAO.deleteGroup(id);
			userDAO.deleteStudents(group);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AdminHeader.jsp");
		dispatcher.include(request, response);
		PrintWriter out = response.getWriter();
		out.print("<center><h2> Group deleted successfully <h2>");
	}
}