package control;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Session;
import model.User;
import model.UserDAO;

@WebServlet("/addSession")
public class addSession extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    public addSession() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			User user = new User();
			user.setGroup( request.getParameter("group")); 
			request.setAttribute("Theuser",user);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Prof/addsession.jsp");
			dispatcher.include(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String group =  request.getParameter("group");
		String module =  request.getParameter("moduleName");
		String date =  request.getParameter("date");
		PrintWriter out = response.getWriter();
 		RequestDispatcher dispatcher;
 		
 	        UserDAO myUserDAO = new UserDAO();	        
	        if (date!=null) {	        
				try {				
					if (myUserDAO.checkDate(request.getParameter("date"), request.getParameter("moduleName"), request.getParameter("group"))==null){
						try {
							ArrayList<User> groupList = null;
							UserDAO gRoupList = new UserDAO();
							groupList = gRoupList.getStudents(request.getParameter("group"));
					
							for (int i=0; i<(groupList.size()) ; i++) {
								Session mySession= new Session();
								 mySession.setStudent(groupList.get(i).getId());
							        mySession.setFirstname(groupList.get(i).getFirstname());
							        mySession.setLastname(groupList.get(i).getLastname());
							        mySession.setModuleName(request.getParameter("moduleName"));
							        mySession.setGroupName(request.getParameter("group"));
							        mySession.setPresent("absent");
							        mySession.setDate(request.getParameter("date"));				        
							        UserDAO mYUserDAO = new UserDAO();
									mYUserDAO.addSession(mySession);
							}			
						} catch (InstantiationException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
						
						ArrayList<Session>  sessionStudent = null;
						UserDAO session = new UserDAO();
						sessionStudent = session.getIdStudent(date , group , module );				
						request.setAttribute("sessionStudent",sessionStudent);
			    	    dispatcher = request.getRequestDispatcher("/Prof/listStudentP.jsp");
			    		dispatcher.include(request, response);	    		
					}else {
				    	dispatcher = request.getRequestDispatcher("/Prof/ProfHeader.jsp");
				    		dispatcher.include(request, response);
				    		out.print("<center><h2> this session is alredy existing  go to update <h2>");
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}	
			}else{
				dispatcher = request.getRequestDispatcher("/Prof/ProfHeader.jsp");
	    		dispatcher.include(request, response);
	    		out.print("<center><h2> enter a date <h2>");
		   }
	}
	}