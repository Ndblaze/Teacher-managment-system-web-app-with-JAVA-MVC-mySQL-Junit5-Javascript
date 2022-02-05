package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.User;

class gettersSettersTest {
	
	static User new_user ;

	@BeforeAll
	static void initializeUser() {
		
		new_user = new User();
	}
	
	@Test 
	void checkFirstname() {
		//given
		   String firstName = "james";
		   
		//when
		    new_user.setFirstname(firstName);
		    String actual = new_user.getFirstname();
		    
		// then
		   
		    assertEquals("james", actual);
		       
	}

}
