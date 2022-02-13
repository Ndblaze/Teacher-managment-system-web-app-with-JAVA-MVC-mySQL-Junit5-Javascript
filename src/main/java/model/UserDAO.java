package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	private Connection connection;
	public UserDAO() {
		this.connection = null;
	}
	
public boolean connectDB() throws InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3", "root", "Algorithme500");
			System.out.println("Connection avec succes a la base de donnees !");
			return true;
		} catch (ClassNotFoundException cnf) {
			System.out.print("Driver non chargé...");
			return false;
		} catch (SQLException sqlex) {
			System.out.println("Incapable de connecter a la base de donnees...");
			return false;
		}
	}

	
public User checkLogin(String username, String password, String type)
			throws InstantiationException, IllegalAccessException {		
		String requete;
		PreparedStatement statement;
		User user = null;
		try {			
			connectDB();
			requete = "SELECT * FROM tp3  WHERE username = ? and password = ? and type = ?" ;
			statement = connection.prepareStatement(requete);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, type);
			
			ResultSet result = statement.executeQuery();	
	        if (result.next()) {
	            user = new User();
	            System.out.println(user+ "1");
	            user.setFirstname(result.getString("firstname"));
	            user.setLastname(result.getString("lastname"));
	            user.setAdress(result.getString("adress"));
	            user.setPhone(result.getString("phone"));
	            user.setUsername(result.getString("username"));
	            user.setPassword(result.getString("password"));
	            user.setType(result.getString("type"));
	            user.setGroup(result.getString("group"));
	        }
			statement.close();
			System.out.println("succed !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return user;
	}
	
public User checkLoginP(String username, String password, String type)
			throws InstantiationException, IllegalAccessException {		
		String requete;
		PreparedStatement statement;
		User user = null;
		try {			
			connectDB();
			requete = "SELECT * FROM prof  WHERE username = ? and password = ? and type = ?" ;
			statement = connection.prepareStatement(requete);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, type);
			
			ResultSet result = statement.executeQuery();			
	        if (result.next()) {
	            user = new User();
	            user.setId(result.getInt("id"));
	            user.setFirstname(result.getString("firstname"));
	            user.setLastname(result.getString("lastname"));
	            user.setAdress(result.getString("adress"));
	            user.setPhone(result.getString("phone"));
	            user.setUsername(result.getString("username"));
	            user.setPassword(result.getString("password"));
	            user.setType(result.getString("type"));
	            user.setModule(result.getString("module"));
	        }        
			statement.close();
			System.out.println("succed !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return user;
	}

public User checkGroup( String group)
		throws InstantiationException, IllegalAccessException {	
	String requete;
	PreparedStatement statement;
	User user = null;	
	try {
		connectDB();
		requete = "SELECT * FROM tp3.groups  WHERE (`group` = ? )" ;
		statement = connection.prepareStatement(requete);
		statement.setString(1, group);
		
		ResultSet result = statement.executeQuery();					
        if (result.next()) {
            user = new User();
            user.setGroup(result.getString("group"));
        }        
		statement.close();
		System.out.println("succed !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return user;
}

public Session checkDate( String date, String module, String group)
		throws InstantiationException, IllegalAccessException {	
	String requete;
	PreparedStatement statement;
	Session session = null;
	try {		
		connectDB();
		requete = "SELECT * FROM tp3.session  WHERE (`date` = ? AND `moduleName` = ? AND `groupName` = ?)" ;
		statement = connection.prepareStatement(requete);
		statement.setString(1, date);
		statement.setString(2, module);
		statement.setString(3, group);
		
		ResultSet result = statement.executeQuery();					
        if (result.next()) {
            session = new Session();
            session.setDate(result.getString("date"));
            session.setModuleName(result.getString("moduleName"));
            session.setGroupName(result.getString("groupName"));
        }
		statement.close();
		System.out.println("succed !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return session;
}

public Session checkDateOfGroup( String group, String module)
		throws InstantiationException, IllegalAccessException {	
	String requete;
	PreparedStatement statement;
	Session session = null;
	try {		
		 connectDB();
		requete = "SELECT * FROM tp3.session  WHERE (`groupName` = ? AND `moduleName` = ?)" ;
		statement = connection.prepareStatement(requete);
		statement.setString(1, group);
		statement.setString(2, module);
		
		ResultSet result = statement.executeQuery();					
        if (result.next()) {
            session = new Session();
            session.setGroupName(result.getString("groupName"));
            session.setModuleName(result.getString("moduleName"));
        }
		statement.close();
		System.out.println("succed !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return session;
}

public User checkStudentGroup( String group)
		throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;
	User user = null;
	
	try {	
		connectDB();
		requete = "SELECT `group` FROM tp3.student  WHERE (`group` = ? )" ;
		statement = connection.prepareStatement(requete);
		statement.setString(1, group);
		
		ResultSet result = statement.executeQuery();			
		
        if (result.next()) {
            user = new User();
            user.setGroup(result.getString("group"));
        }
		statement.close();
		System.out.println("succed !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return user;
}


	
public void addUser(User user) throws InstantiationException, IllegalAccessException {

		String requete;
		PreparedStatement stmt;
		connectDB();
		try {
			requete = "INSERT INTO tp3 (firstname, lastname, adress, phone, username, password, type, `group`) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";			
			stmt = connection.prepareStatement(requete);

			stmt.setString(1,user.getFirstname());
			stmt.setString(2,user.getLastname());
			stmt.setString(3,user.getAdress());
			stmt.setString(4,user.getPhone());
			stmt.setString(5,user.getUsername());
			stmt.setString(6,user.getPassword());
			stmt.setString(7,user.getType());
			stmt.setString(8,user.getGroup());
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Inserted !");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	 
public boolean addTeacher(User user) throws InstantiationException, IllegalAccessException {
		String requete;
		PreparedStatement stmt;
		connectDB();
		
		try {
			requete = "INSERT INTO prof (firstname, lastname, adress, phone, username, password, type, `module`) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";			
			stmt = connection.prepareStatement(requete);
			
			stmt.setString(1,user.getFirstname());
			stmt.setString(2,user.getLastname());
			stmt.setString(3,user.getAdress());
			stmt.setString(4,user.getPhone());
			stmt.setString(5,user.getUsername());
			stmt.setString(6,user.getPassword());
			stmt.setString(7,user.getType());
			stmt.setString(8,user.getModule());			
			stmt.executeUpdate();
			stmt.close();
			
			System.out.println("Inserted !");
			
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		
		return true ;
	}
	
public void addStudent(User user) throws InstantiationException, IllegalAccessException {
		String requete;
		PreparedStatement stmt;
		connectDB();

		try {
			requete = "INSERT INTO student (firstname, lastname, adress, phone, username, password, type, `group`) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";			
			stmt = connection.prepareStatement(requete);
			
			stmt.setString(1,user.getFirstname());
			stmt.setString(2,user.getLastname());
			stmt.setString(3,user.getAdress());
			stmt.setString(4,user.getPhone());
			stmt.setString(5,user.getUsername());
			stmt.setString(6,user.getPassword());
			stmt.setString(7,user.getType());
			stmt.setString(8,user.getGroup());
			stmt.executeUpdate();
			stmt.close();
			
			System.out.println("Inserted !");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

public void  addSession(Session session) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	try {
		requete = "INSERT INTO session (student, moduleName, groupName, present, `date`, `firstname`, `lastname`) " + "VALUES(?, ?, ?, ?, ?, ?, ?)";			
		stmt = connection.prepareStatement(requete);
		
		String present = session.getPresent(); 
		if (present == null) {
			present = "absent";
		}
		stmt.setString(1, String.valueOf(session.getStudent()));
		stmt.setString(2, session.getModuleName());
		stmt.setString(3, session.getGroupName());
		stmt.setString(4, present);
		stmt.setString(5, session.getDate());
		stmt.setString(6, session.getFirstname());
		stmt.setString(7, session.getLastname());
		stmt.executeUpdate();
		stmt.close();
		
		System.out.println("Inserted !");
	} catch (SQLException e) {
		System.out.println(e);
	}
}

	
public ArrayList<User> getUsers() throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement statement;
		User user = null;
		ArrayList<User> usersList = new ArrayList<User>();
		
		try {
			connectDB();
			requete = "SELECT * FROM tp3";
			statement = connection.prepareStatement(requete);
			ResultSet result = statement.executeQuery();			
			
	        while (result.next()) {	
	            user = new User();
	            user.setFirstname(result.getString("firstname"));
	            user.setLastname(result.getString("lastname"));
	            user.setAdress(result.getString("adress"));
	            user.setPhone(result.getString("phone"));
	            user.setUsername(result.getString("username"));
	            user.setPassword(result.getString("password"));
	            user.setType(result.getString("type"));
	            user.setGroup(result.getString("group"));
	            usersList.add(user);
	        }
	        
			statement.close();
			System.out.println("Users --- succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}	
		return usersList;
	}
	
public ArrayList<User> getTeachers() throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement statement;
		User user = null;
		ArrayList<User> usersList = new ArrayList<User>();
		
		try {
			connectDB();		
			requete = "SELECT * FROM prof WHERE type ='Enseignant' ";
			statement = connection.prepareStatement(requete);
			ResultSet result = statement.executeQuery();			
			
	        while (result.next()) {	
	            user = new User();
	            user.setId( Integer.parseInt(result.getString("id")));
	            user.setFirstname(result.getString("firstname"));
	            user.setLastname(result.getString("lastname"));
	            user.setAdress(result.getString("adress"));
	            user.setPhone(result.getString("phone"));
	            user.setUsername(result.getString("username"));
	            user.setPassword(result.getString("password"));
	            user.setType(result.getString("type"));
	            user.setModule(result.getString("module"));
	            usersList.add(user);
	        }
			statement.close();

			System.out.println("list of teachers");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return usersList;
	}
	
public ArrayList<User> getStudents(String group) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;
	User user = null;
	ArrayList<User> usersList = new ArrayList<User>();
	
	try {	
		connectDB();
		requete = "SELECT * FROM student WHERE `group` = ? ";
		statement = connection.prepareStatement(requete);
		statement.setString(1, group);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {	
            user = new User();
            user.setId( Integer.parseInt(result.getString("id")));
            user.setFirstname(result.getString("firstname"));
            user.setLastname(result.getString("lastname"));
            user.setAdress(result.getString("adress"));
            user.setPhone(result.getString("phone"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setType(result.getString("type"));
            user.setGroup(result.getString("group"));         
            usersList.add(user);
        }        
		statement.close();

		System.out.println("list of student");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return usersList;
}

public ArrayList<User> getPresentStudents(int id) throws InstantiationException, IllegalAccessException {
	

	String requete;
	PreparedStatement statement;
	
	User user = null;
	ArrayList<User> usersList = new ArrayList<User>();
	
	try {
		
		connectDB();
		
		requete = "SELECT * FROM student WHERE `id` = ? ";
		statement = connection.prepareStatement(requete);
		statement.setString(1, String.valueOf(id));
		
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
            user = new User();
            user.setId( Integer.parseInt(result.getString("id")));
            user.setFirstname(result.getString("firstname"));
            user.setLastname(result.getString("lastname"));
            user.setAdress(result.getString("adress"));
            user.setPhone(result.getString("phone"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setType(result.getString("type"));
            user.setGroup(result.getString("group"));
   
            
            usersList.add(user);
        }
        
		statement.close();

		System.out.println("list of student");
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	return usersList;
}

public ArrayList<Session> getDates(String group, String module) throws InstantiationException, IllegalAccessException {
	

	String requete;
	PreparedStatement statement;
	
	Session session = null;
	ArrayList<Session> sessionList = new ArrayList<Session>();
	
	try {
		
		connectDB();
		
		requete = "SELECT *  FROM session WHERE `groupName` = ? AND `moduleName` = ?";
		statement = connection.prepareStatement(requete);
		statement.setString(1, group);
		statement.setString(2, module);
		
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
        	session = new Session();
        	session.setIdsession( Integer.parseInt(result.getString("idsession")));
        	session.setStudent(Integer.parseInt(result.getString("student")));
        	session.setModuleName(result.getString("moduleName"));
        	session.setGroupName(result.getString("groupName"));
        	session.setPresent(result.getString("present"));
        	session.setDate(result.getString("date"));
            
            sessionList.add(session);
        }
        
		statement.close();

		System.out.println("list of dates");
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	return sessionList;
}

public ArrayList<Session> getDistinctDates(String group, String module) throws InstantiationException, IllegalAccessException {
	

	String requete;
	PreparedStatement statement;
	
	Session session = null;
	ArrayList<Session> sessionList = new ArrayList<Session>();
	
	try {
		
		connectDB();
		
		requete = "SELECT * FROM `session`  WHERE `groupName` = ? AND `moduleName` = ?  GROUP BY (`date`)";
		statement = connection.prepareStatement(requete);
		statement.setString(1, group);
		statement.setString(2, module);
		
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
        	session = new Session();
        	session.setIdsession( Integer.parseInt(result.getString("idsession")));
        	session.setStudent(Integer.parseInt(result.getString("student")));
        	session.setModuleName(result.getString("moduleName"));
        	session.setGroupName(result.getString("groupName"));
        	session.setPresent(result.getString("present"));
        	session.setDate(result.getString("date"));
            
            sessionList.add(session);
        }
        
		statement.close();

		System.out.println("list of dates");
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	return sessionList;
}

public ArrayList<Session> getIdStudent( String date, String groupName, String moduleName) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;
	Session session = null;
	ArrayList<Session> sessionList = new ArrayList<Session>();
	
	try {	
		connectDB();
		requete = "SELECT * FROM session WHERE `date` = ? AND `groupName`= ?  AND `moduleName`= ? ";
		statement = connection.prepareStatement(requete);
		statement.setString(1, date);
		statement.setString(2, groupName);
		statement.setString(3, moduleName);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {	
        	session = new Session();
        	session.setIdsession( Integer.parseInt(result.getString("idsession")));
        	session.setStudent(Integer.parseInt(result.getString("student")));
        	session.setFirstname(result.getString("firstname"));
        	session.setLastname(result.getString("lastname"));
        	session.setModuleName(result.getString("moduleName"));
        	session.setGroupName(result.getString("groupName"));
        	session.setPresent(result.getString("present"));
        	session.setDate(result.getString("date"));    
            sessionList.add(session);
        }
		statement.close();

		System.out.println("list of dates");
	} catch (SQLException e) {
		System.out.println(e);
	}	
	return sessionList;
}	

public User getUser(String id) throws InstantiationException, IllegalAccessException {
	
		String requete;
		PreparedStatement statement;	
		User user = null;
	
		try {
			connectDB();
			requete = "SELECT * FROM tp3 WHERE id = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();			
			
	      while(result.next()){	
                user = new User();
	            user.setId(result.getInt("id"));
	            user.setFirstname(result.getString("firstname"));
	            user.setLastname(result.getString("lastname"));
	            user.setAdress(result.getString("adress"));
	            user.setPhone(result.getString("phone"));
	            user.setUsername(result.getString("username"));
	            user.setPassword(result.getString("password"));
	            user.setType(result.getString("type"));
	            user.setGroup(result.getString("group"));
	        }	        
			statement.close();

			System.out.println("got User done");
		} catch (SQLException e) {
			System.out.println(e);
		}		
		return user;
	}

public User getTeacher(String id) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;
	
	User user = null;
	
	try {
		
		connectDB();
		
		requete = "SELECT * FROM prof WHERE id = ?";
		statement = connection.prepareStatement(requete);
		statement.setString(1, id);

		ResultSet result = statement.executeQuery();			
		
      while(result.next()){
        	
            user = new User();
            user.setId(result.getInt("id"));
            user.setFirstname(result.getString("firstname"));
            user.setLastname(result.getString("lastname"));
            user.setAdress(result.getString("adress"));
            user.setPhone(result.getString("phone"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setType(result.getString("type"));
            user.setModule(result.getString("module"));

        }
        
		statement.close();

		System.out.println("got teacher done !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	return user;
}

public User getStudent(String id) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;
	User user = null;

	try {		
		connectDB();		
		requete = "SELECT * FROM student WHERE id = ?";
		statement = connection.prepareStatement(requete);
		statement.setString(1, id);
		ResultSet result = statement.executeQuery();			
		
      while(result.next()){       	
            user = new User();
            user.setId(result.getInt("id"));
            user.setFirstname(result.getString("firstname"));
            user.setLastname(result.getString("lastname"));
            user.setAdress(result.getString("adress"));
            user.setPhone(result.getString("phone"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setType(result.getString("type"));
            user.setGroup(result.getString("group"));
        }       
		statement.close();

		System.out.println("got student done !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return user;
}

public ArrayList<User> getGroupList(String group) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;	
	User user = null;
	ArrayList<User> usersList = new ArrayList<User>();

	try {		
		connectDB();		
		requete = "SELECT * FROM tp3 WHERE `group` = ?";
		statement = connection.prepareStatement(requete);
		statement.setString(1, group);				
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {        	
            user = new User();
            user.setFirstname(result.getString("firstname"));
            user.setLastname(result.getString("lastname"));
            user.setAdress(result.getString("adress"));
            user.setPhone(result.getString("phone"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setType(result.getString("type"));
            user.setGroup(result.getString("group"));                                 
            usersList.add(user);
        }       
		statement.close();

		System.out.println("succed");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return usersList;
}	

public ArrayList<User> getGroups() throws InstantiationException, IllegalAccessException {

	String requete;
	PreparedStatement statement;	
	User user = null;
	ArrayList<User> usersList = new ArrayList<User>();
	
	try {	
		connectDB();	
		requete = "SELECT * FROM `tp3`.`groups` ";
		statement = connection.prepareStatement(requete);	
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {     	
            user = new User();
            user.setId( Integer.parseInt(result.getString("idGroups")));
            user.setGroup(result.getString("group"));        
            usersList.add(user);
        }  
		statement.close();

		System.out.println("list of groups");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return usersList;
}

public User getGroup(String id) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;	
	User user = null;
	
	try {		
		connectDB();		
		requete = "SELECT * FROM `groups` WHERE `idGroups` = ?";
		statement = connection.prepareStatement(requete);
		statement.setString(1, id);
		ResultSet result = statement.executeQuery();			
		
      while(result.next()){     	
            user = new User();
            user.setId(result.getInt("idGroups"));
            user.setGroup(result.getString("group"));
        }    
		statement.close();

		System.out.println("got group done !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return user;
}



public void updateTeacher(User user) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;
	connectDB();

	try {
			requete = "UPDATE `prof` SET `firstname` = ? , `lastname` = ? , `adress` = ? , `phone` = ? , `username` = ? , `password` = ?,`type` = ? , `module` = ? WHERE (`id` = ?)";
			stmt = connection.prepareStatement(requete);		
		stmt.setString(1,user.getFirstname());
		stmt.setString(2,user.getLastname());
		stmt.setString(3,user.getAdress());
		stmt.setString(4,user.getPhone());
		stmt.setString(5,user.getUsername());
		stmt.setString(6,user.getPassword());
		stmt.setString(7,user.getType());
		stmt.setString(8,user.getModule());
		stmt.setString(9,String.valueOf(user.getId()));			
		stmt.executeUpdate();
		stmt.close();
		
		System.out.println("Inserted !");
		} catch (SQLException e) {
			System.out.println(e);
		}	
}	

public void updateUser(User user) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;
	connectDB();

	try {
			requete = "UPDATE `tp3` SET `firstname` = ? , `lastname` = ? , `adress` = ? , `phone` = ? , `username` = ? , `password` = ?,`type` = ? , `group` = ? WHERE (`id` = ?)";
			stmt = connection.prepareStatement(requete);								
		stmt.setString(1,user.getFirstname());
		stmt.setString(2,user.getLastname());
		stmt.setString(3,user.getAdress());
		stmt.setString(4,user.getPhone());
		stmt.setString(5,user.getUsername());
		stmt.setString(6,user.getPassword());
		stmt.setString(7,user.getType());
		stmt.setString(8,user.getModule());
		stmt.setString(9,String.valueOf(user.getId()));			
		stmt.executeUpdate();
		stmt.close();

		System.out.println("Inserted !");
		
		} catch (SQLException e) {
			System.out.println(e);
		}
}	

public void updateStudent(User user) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;	
	connectDB();

	try {
			requete = "UPDATE `student` SET `firstname` = ? , `lastname` = ? , `adress` = ? , `phone` = ? , `username` = ? , `password` = ?,`type` = ? , `group` = ? WHERE (`id` = ?)";
			stmt = connection.prepareStatement(requete);
		stmt.setString(1,user.getFirstname());
		stmt.setString(2,user.getLastname());
		stmt.setString(3,user.getAdress());
		stmt.setString(4,user.getPhone());
		stmt.setString(5,user.getUsername());
		stmt.setString(6,user.getPassword());
		stmt.setString(7,user.getType());
		stmt.setString(8,user.getGroup());
		stmt.setString(9,String.valueOf(user.getId()));	
		stmt.executeUpdate();
		stmt.close();

		System.out.println("Inserted !");

		} catch (SQLException e) {
			System.out.println(e);
		}
}		

public void  updateSession(Session session) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	try {
		requete = "UPDATE `session` SET `student` = ? , `moduleName` = ? , `groupName` = ? , `present` = ? , `date` = ? , `firstname` = ?,`lastname` = ?  WHERE (`idsession` = ?)";
//		requete = "UPDATE  session (student, moduleName, groupName, present, `date`, `firstname`, `lastname`) " + "VALUES(?, ?, ?, ?, ?, ?, ?)";			
		stmt = connection.prepareStatement(requete);
		
		String present = session.getPresent(); 
		if (present == null) {
			present = "absent";
		}
		stmt.setString(1, String.valueOf(session.getStudent()));
		stmt.setString(2, session.getModuleName());
		stmt.setString(3, session.getGroupName());
		stmt.setString(4, present);
		stmt.setString(5, session.getDate());
		stmt.setString(6, session.getFirstname());
		stmt.setString(7, session.getLastname());
		stmt.setString(8, String.valueOf(session.getIdsession()));
		stmt.executeUpdate();
		stmt.close();
		
		System.out.println("Inserted !");
	} catch (SQLException e) {
		System.out.println(e);
	}
}



public User deleteStudent(String id) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;	
	User user = null;

	try {		
		connectDB();		
		requete = "DELETE FROM `tp3`.`student` WHERE (`id` = ?);"; 
		statement = connection.prepareStatement(requete);
		statement.setString(1, id);
	   statement.executeUpdate();			
	   statement.close();

		System.out.println("student deleted");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return user;
}

public User deleteStudents(String group) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;	
	User user = null;

	try {		
		connectDB();		
		requete = "DELETE FROM `tp3`.`student` WHERE (`group` = ?);"; 
		statement = connection.prepareStatement(requete);
		statement.setString(1, group);
	   statement.executeUpdate();			
	   statement.close();

		System.out.println("students are deleted");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return user;
}

public User deleteTeacher(String id) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;
	User user = null;

	try {	
		connectDB();	
		requete = "DELETE FROM `tp3`.`prof` WHERE (`id` = ?);"; 
		statement = connection.prepareStatement(requete);
		statement.setString(1, id);
	   statement.executeUpdate();			
	   statement.close();

		System.out.println("teacher deleted");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return user;
}

public User deleteGroup(String id) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;
	User user = null;

	try {	
		connectDB();
		requete = "DELETE FROM `tp3`.`groups` WHERE (`idGroups` = ?);"; 
		statement = connection.prepareStatement(requete);
		statement.setString(1, id);
	   statement.executeUpdate();			
	   statement.close();

		System.out.println("delete group done");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return user;
}


public void createGroup(User user) throws InstantiationException, IllegalAccessException {

	String requete;
	PreparedStatement stmt;	
	connectDB();

	try {
		requete = "INSERT INTO `tp3`.`groups` ( `group`) VALUES (?)";			
		stmt = connection.prepareStatement(requete);	
		stmt.setString(1,user.getGroup());			
		stmt.executeUpdate();
		stmt.close();
		System.out.println("Inserted !");
		
	} catch (SQLException e) {
		System.out.println(e);
	}
}


}
