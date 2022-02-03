package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.UserDAO;

class DatabaseConnection {
	
	UserDAO user ;

	@Test
	void checkDatabaseConnection() throws InstantiationException, IllegalAccessException{
		
		//given
		   user = new UserDAO();
		   
		//when
		  boolean expected = user.connectDB();
		  
		//then
		  
		  assertTrue(expected, "Database connected succefully!!");
	}

}
