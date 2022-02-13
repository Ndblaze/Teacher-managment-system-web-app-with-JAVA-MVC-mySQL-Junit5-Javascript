package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.User;
import model.UserDAO;

@DisplayName("Test for Prof")
class checkProfTest {
	
	UserDAO user ;
    User userInfo ;

	@BeforeEach
	@Test
	@DisplayName("Prof Should Login")
	void checkLogin() throws InstantiationException, IllegalAccessException {
	
		//given
			user = new UserDAO();
			
			String username = "sola";
		    String password = "123456";
		    String type = "Enseignant";
		   
	    //when
		    User expected = user.checkLoginP(username, password, type);
			userInfo = expected ;
			
		//then
		    assertNotNull(expected);
	}
	
	@Test
	@DisplayName("Prof should not Login")
    void checkLoginUserDoesNotExist() throws InstantiationException, IllegalAccessException {
		
		//given
		   user = new UserDAO();
		   
		   String username = "sola";
		   String password = "123";
		   String type = "Ensei";
		   
		//when
		  User expected = user.checkLoginP(username, password, type);
		  userInfo = expected ;
		//then
		  assertNull(expected);
	}
	

	
	@Test
	@DisplayName("Should get prof infotmation After login")
    void checkProfInfoExits(){
		
		//given
		   
		//when
		   String expected[] = {"James", "onuorah", "Abuja, nigeria", "0798961871", "sola", "123456", "Enseignant", "TABD"};
		   String actual[] = {userInfo.getFirstname(), userInfo.getLastname(), userInfo.getAdress(), userInfo.getPhone(),
				                         userInfo.getUsername(), userInfo.getPassword(), userInfo.getType(), userInfo.getModule()};   
		//then
		  assertArrayEquals(expected, actual);
	}

}
