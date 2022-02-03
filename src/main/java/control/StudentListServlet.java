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

import model.User;
import model.UserDAO;

@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;         
    public StudentListServlet() {
        super();       
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {			
			RequestDispatcher dispatcher;
			UserDAO userDAO = new UserDAO();
			ArrayList<User> usersList = null;
			String group = request.getParameter("group");
			try {				
				UserDAO myUserDAO = new UserDAO();
				 User  user =  myUserDAO.checkStudentGroup(group);
				if ( user != null ) {
					usersList = userDAO.getStudents(group);
					request.setAttribute("usersList",usersList);
				    dispatcher = request.getRequestDispatcher("/Admin/listStudent.jsp");
				    dispatcher.include(request, response);				
				}else {										
					 dispatcher = request.getRequestDispatcher("/Admin/AdminHeader.jsp");
					dispatcher.include(request, response);				     	
					PrintWriter out = response.getWriter();
					out.print("<center><h2> this group is empty <br>add a student to this groupe   <h2>");									
				}				   
			} catch (InstantiationException | IllegalAccessException e) {				
				e.printStackTrace();
			}			
		} else {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
