package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Session;
import model.User;
import model.UserDAO;

@WebServlet("/AppelServlet")
public class AppelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AppelServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if (request.getSession().getAttribute("user") != null) {		
			UserDAO userDAO = new UserDAO();
			ArrayList<User> usersList = null;
			try {
				usersList = userDAO.getGroups();

			} catch (InstantiationException | IllegalAccessException e) {			
				e.printStackTrace();
			}
			request.setAttribute("usersList",usersList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Prof/listGroups.jsp");
			dispatcher.include(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}		
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Session mySession= new Session();
		mySession.setIdsession(Integer.parseInt(request.getParameter("id")));;
		mySession.setModuleName(request.getParameter("module"));
        mySession.setGroupName(request.getParameter("group"));
        mySession.setDate(request.getParameter("date"));
		try {
			UserDAO myUserDAO = new UserDAO();
			myUserDAO.addSession(mySession);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/updateTeacher.jsp");
		dispatcher.include(request, response);
		out.print("<center><h2> User added successfully <h2>");
	}

}
