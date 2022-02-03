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

@WebServlet("/groupList")
public class groupList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public groupList() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if (request.getSession().getAttribute("user") != null) {
			UserDAO userDAO = new UserDAO();
			ArrayList<User> usersList = null;
			PrintWriter out = response.getWriter();			
			try {				
				usersList = userDAO.getGroups();				
			} catch (InstantiationException | IllegalAccessException e) {				
				e.printStackTrace();
			}		         
			if (usersList.size()!=0) {	             					 
	               request.setAttribute("usersList",usersList);	   			
	   			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/listGroups.jsp");
	   			dispatcher.include(request, response);	               
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AdminHeader.jsp");
					dispatcher.include(request, response);
					out.print("<center><h2> there is no group yet <h2>");
					out.print("<a href=\"http://localhost:8080/DaawMiniProject/CreateGroup\"><button> create group </button> </a>");
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