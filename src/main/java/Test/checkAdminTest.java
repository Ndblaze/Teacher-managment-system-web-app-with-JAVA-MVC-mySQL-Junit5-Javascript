package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import model.User;
import model.UserDAO;

@DisplayName("Test for Admin")
class checkAdminTest {
 
	 UserDAO user ;
	 User userInfo ;

	@BeforeEach
	@RepeatedTest(3)
	@DisplayName("Admin Should Login")
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
	@DisplayName("Admin should not Login")
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
	
	
	
	@Test
	@DisplayName("Should get Admin infotmation After login")
    void checkAdminInfoExits(){
		
		//given
		   
		//when
		   String expected[] = {"slimane", "ibrahim", "salou7a", "0665022588", "sola", "123456", "Administrateur"};
		   String actual[] = {userInfo.getFirstname(), userInfo.getLastname(), userInfo.getAdress(), userInfo.getPhone(),
				                         userInfo.getUsername(), userInfo.getPassword(), userInfo.getType()};   
		//then
		  assertArrayEquals(expected, actual);
	}
	
	
	@Nested
	@DisplayName("check if group exist or not")
	class checkGroup{
		
		@Test 
		@DisplayName("check if group exist")
		void GroupExists() throws InstantiationException, IllegalAccessException {
			//given
			   String Group = "AB";
			   
			//when
			    User expected = user.checkGroup(Group);
			    
			// then
			    assertNotNull(expected);       
		}
		
		@Test 
		@DisplayName("check that group do not exist")
		void GroupDontExists() throws InstantiationException, IllegalAccessException {
			//given
			   String Group = "ABCD";
			   
			//when
			    User expected = user.checkGroup(Group);
			    
			// then
			    assertNull(expected);       
		}
	}
	
	
	//Adds a new teacher 
	@Nested
	@DisplayName("Should add a new Teacher")
	class AddNewTeacher{
		
		 UserDAO newTeacher ;
		 User teacherInfo ;

		@BeforeEach
		void initialize() {
			newTeacher = new UserDAO();
			teacherInfo = new User();	
		}
		
		@Test
		@DisplayName("Should add new user")
	     void addUser() throws InstantiationException, IllegalAccessException {
			
			//given
			   teacherInfo.setFirstname("Miki");
			   teacherInfo.setLastname("Abdul");
			   teacherInfo.setAdress("Algers");
			   teacherInfo.setModule("TQL");
			   teacherInfo.setPassword("blazeMan");
			   teacherInfo.setPhone("0654223445");
			   teacherInfo.setUsername("Miki");
			   teacherInfo.setType("Enseignant");
			   
			   
			//when
			  boolean expected = newTeacher.addTeacher(teacherInfo);
			//then
			  assertTrue(expected);
		}
		
	}

}
