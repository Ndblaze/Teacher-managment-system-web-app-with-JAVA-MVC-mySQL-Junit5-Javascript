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

@WebServlet("/CreateGroup")
public class CreateGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateGroup() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/CreateGroup.jsp");
			dispatcher.include(request, response);
		} else {		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher dispatcher;
		String group = request.getParameter("nbGroup");		
		try {
			UserDAO myUserDAO = new UserDAO();
			 User  user =  myUserDAO.checkGroup(group);
			if ( user != null ) {	
				dispatcher = request.getRequestDispatcher("/Admin/CreateGroup.jsp");
				dispatcher.include(request, response);				
				PrintWriter out = response.getWriter();
				out.print("<center><h2> this group  is already exucted -- change a name  !!<h2>");				
			}else {				
				 dispatcher = request.getRequestDispatcher("/Admin/CreateGroup.jsp");
				dispatcher.include(request, response);			     	
				User NewGroup = new User() ;
				NewGroup.setGroup(request.getParameter("nbGroup"));				
				UserDAO MyUserDAO = new UserDAO();
			    MyUserDAO.createGroup(NewGroup);				
				PrintWriter out = response.getWriter();
				out.print("<center><h2> the group was created successfully <h2>");				 				
			}			    		
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}	
	}
}
