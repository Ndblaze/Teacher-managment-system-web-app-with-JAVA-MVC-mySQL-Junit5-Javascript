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


@WebServlet("/updateTeacher")
public class updateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;     
    public updateTeacher() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		if (request.getSession().getAttribute("user") != null) {				
			String id =request.getParameter("userid" );			
			UserDAO userDAO = new UserDAO();
			User TheUser = null;			
			try {
				TheUser = userDAO.getTeacher(id);				
			} catch (InstantiationException | IllegalAccessException e) {				
				e.printStackTrace();
			}			
			request.setAttribute("TheUser",TheUser); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/updateTeacher.jsp");
			dispatcher.include(request, response);						
		} else {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				User myUser = new User();										
				myUser.setId(Integer.parseInt(request.getParameter("id")));
				myUser.setFirstname(request.getParameter("fname"));
				myUser.setLastname(request.getParameter("lname"));
				myUser.setAdress(request.getParameter("adress"));
				myUser.setPhone(request.getParameter("phone"));
				myUser.setUsername(request.getParameter("username"));
				myUser.setPassword(request.getParameter("password"));
				myUser.setType(request.getParameter("type"));
				myUser.setModule(request.getParameter("module"));
				try {			
					UserDAO myUserDAO = new UserDAO();
					myUserDAO.updateTeacher(myUser);					   					
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