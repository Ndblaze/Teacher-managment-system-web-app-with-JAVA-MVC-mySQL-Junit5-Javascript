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
import model.UserDAO;


@WebServlet("/insertPresntStudent")
public class insertPresntStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public insertPresntStudent() {
        super();      
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String group =  request.getParameter("groupName");
		String module =  request.getParameter("moduleName");
		String date =  request.getParameter("date");
		
		Session seSsion = new Session();
		seSsion.setIdsession(Integer.valueOf(request.getParameter("idsession")));
		seSsion.setStudent(Integer.valueOf(request.getParameter("student")));
		seSsion.setFirstname(request.getParameter("firstname"));
		seSsion.setLastname(request.getParameter("lastname"));
		seSsion.setGroupName(request.getParameter("groupName"));
		seSsion.setModuleName(request.getParameter("moduleName"));
		seSsion.setDate(request.getParameter("date"));
		seSsion.setPresent(request.getParameter("present"));		
		UserDAO sEssion = new UserDAO();
		try {
			sEssion.updateSession(seSsion);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}		
	
		PrintWriter out = response.getWriter();
 		RequestDispatcher dispatcher;                                 
	        if (date!=null) {	        	        
				try {				
					ArrayList<Session>  sessionStudent = null;
					UserDAO session = new UserDAO();
					sessionStudent = session.getIdStudent(date , group , module );
					
					request.setAttribute("sessionStudent",sessionStudent);
		    	    dispatcher = request.getRequestDispatcher("/Prof/listStudentP.jsp");
		    		dispatcher.include(request, response);				
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
