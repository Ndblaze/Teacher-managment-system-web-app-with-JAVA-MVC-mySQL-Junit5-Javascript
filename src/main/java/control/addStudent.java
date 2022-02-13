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

@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public addStudent() {
       super();
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("user") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/addStudent.jsp");
			dispatcher.include(request, response);
		} else {		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		} 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User myUser = new User();		
		myUser.setFirstname(request.getParameter("fname"));
		myUser.setLastname(request.getParameter("lname"));
		myUser.setAdress(request.getParameter("adress"));
		myUser.setPhone(request.getParameter("phone"));
		myUser.setUsername(request.getParameter("username"));
		myUser.setPassword(request.getParameter("password"));
		myUser.setType(request.getParameter("type"));
		myUser.setGroup(request.getParameter("group"));
		
		RequestDispatcher dispatcher;
		UserDAO UserDAO = new UserDAO();
		try {
			User user = UserDAO.checkGroup(myUser.getGroup());
			if (user == null) {
				User NewGroup = new User() ;
				NewGroup.setGroup(request.getParameter("group"));
				UserDAO MyUserDAO = new UserDAO();
			    MyUserDAO.createGroup(myUser);				
			}

		} catch (InstantiationException | IllegalAccessException e1) {			
			e1.printStackTrace();
		}	
		
		try {
			UserDAO myUserDAO = new UserDAO();
			myUserDAO.addStudent(myUser);			    			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		dispatcher = request.getRequestDispatcher("Admin/addStudent.jsp");
		dispatcher.include(request, response);
		out.print("<center><h2> User added successfully <h2>");
	}
}
