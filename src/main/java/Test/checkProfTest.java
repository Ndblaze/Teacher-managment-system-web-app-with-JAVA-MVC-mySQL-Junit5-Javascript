package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import model.User;
import model.UserDAO;

class checkProfTest {
	
	UserDAO user ;
	static User userInfo ;


	@Test
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
	

	
	@AfterAll
	static void checkProfInfoExits(){
		
		//given
		   
		//when
		   String expected[] = {"James", "onuorah", "Abuja, nigeria", "0798961871", "sola", "123456", "Enseignant", "TABD"};
		   String actual[] = {userInfo.getFirstname(), userInfo.getLastname(), userInfo.getAdress(), userInfo.getPhone(),
				                         userInfo.getUsername(), userInfo.getPassword(), userInfo.getType(), userInfo.getModule()};   
		//then
		  assertArrayEquals(expected, actual);
	}

}
