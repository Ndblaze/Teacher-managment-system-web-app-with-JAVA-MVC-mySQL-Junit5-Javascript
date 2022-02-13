package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.UserDAO;

@DisplayName("Test for database connection")
class DatabaseConnection {
	
	UserDAO user ;

	@Test
	@DisplayName("connection")
	void checkDatabaseConnection() throws InstantiationException, IllegalAccessException{
		
		//given
		   user = new UserDAO();
		   
		//when
		  boolean expected = user.connectDB();
		  
		//then
		  
		  assertTrue(expected, "Database connected succefully!!");
	}

}
