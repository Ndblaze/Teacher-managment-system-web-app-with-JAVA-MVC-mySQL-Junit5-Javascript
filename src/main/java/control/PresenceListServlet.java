package control;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Session;
//import model.User;
import model.UserDAO;

@WebServlet("/PresenceListServlet")
public class PresenceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public PresenceListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if (request.getSession().getAttribute("user") != null) {
			RequestDispatcher dispatcher;			
			ArrayList<Session> sessionList = null;
			String group = request.getParameter("group");
			String module = request.getParameter("module");			
			try {
				  UserDAO uSerDAO = new UserDAO();
				if (uSerDAO.checkDateOfGroup(group, module)==null) {
					PrintWriter out = response.getWriter() ;				
					    dispatcher = request.getRequestDispatcher("/Prof/ProfHeader.jsp");
						dispatcher.include(request, response);
					out.print("<center><h2> this group had no session yet<h2>");					
				}else {				
					UserDAO userDAO = new UserDAO();
					sessionList = userDAO.getDistinctDates(group , module);
					request.setAttribute("sessionList",sessionList);			
					 dispatcher = request.getRequestDispatcher("/Prof/DateList.jsp");
					dispatcher.include(request, response);
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