package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import model.User;
import model.UserDAO;

class checkAdminTest {
 
	UserDAO user ;
	static User userInfo ;

	@Test
	void checkLogin() throws InstantiationException, IllegalAccessException {
		
		//given
		   user = new UserDAO();
		   
		   String username = "sola";
		   String password = "123456";
		   String type = "Administrateur";
		   
		//when
		  User expected = user.checkLogin(username, password, type);
		  userInfo = expected ;
		//then
		  assertNotNull(expected);
	}
	
	@Test
	void checkLoginUserDoesNotExist() throws InstantiationException, IllegalAccessException {
		
		//given
		   user = new UserDAO();
		   
		   String username = "sola";
		   String password = "123";
		   String type = "Admin";
		   
		//when
		  User expected = user.checkLogin(username, password, type);
		  userInfo = expected ;
		//then
		  assertNull(expected);
	}
	
	
	
	@AfterAll
	static void checkAdminInfoExits(){
		
		//given
		   
		//when
		   String expected[] = {"slimane", "ibrahim", "salou7a", "0665022588", "sola", "123456", "Administrateur"};
		   String actual[] = {userInfo.getFirstname(), userInfo.getLastname(), userInfo.getAdress(), userInfo.getPhone(),
				                         userInfo.getUsername(), userInfo.getPassword(), userInfo.getType()};   
		//then
		  assertArrayEquals(expected, actual);
	}

}
