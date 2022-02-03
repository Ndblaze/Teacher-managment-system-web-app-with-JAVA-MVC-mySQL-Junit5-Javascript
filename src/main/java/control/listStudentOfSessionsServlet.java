package control;

import java.io.IOException;
//import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Session;
//import model.User;
import model.UserDAO;

@WebServlet("/listStudentOfSessionsServlet")
public class listStudentOfSessionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public listStudentOfSessionsServlet() {
        super(); 
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		String group = request.getParameter("group");
		String module = request.getParameter("module");		
	 	
		ArrayList<Session> sessionStudent = null;	 
	 	UserDAO sessionDAO = new UserDAO(); 
		try {
			sessionStudent = sessionDAO.getIdStudent(date, group,module) ;			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		request.setAttribute("sessionStudent",sessionStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Prof/listStudentOfSessions.jsp");
		dispatcher.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}