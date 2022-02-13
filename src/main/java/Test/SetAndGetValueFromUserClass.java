package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import model.User;

@DisplayName("Testing user class in the model")
class SetAndGetValueFromUserClass{
	
	static User new_user ;

	@BeforeAll
	static void initializeUser() {
		new_user = new User();
	}
	
	
	@Nested
	@DisplayName("Set and Get Test")
	class GetAndSet{
		
		@Test 
		@DisplayName("Set and Get firstname")
		void Firstname() {
			//given
			   String firstName = "James";
			   
			//when
			    new_user.setFirstname(firstName);
			    String actual = new_user.getFirstname();
			    
			// then
			  assertEquals("James", actual);       
		}
		
		@Test 
		@DisplayName("Set and Get lastname")
		void Lastname() {
			//given
			   String lastName = "Slimane";
			   
			//when
			    new_user.setLastname(lastName);
			    String actual = new_user.getLastname();
			    
			// then
			  assertEquals("Slimane", actual);       
		}
		
		@Test 
		@DisplayName("Set and Get Username")
		void Username(){
			//given
			   String UserName = "Blaze";
			   
			//when
			    new_user.setUsername(UserName);
			    String actual = new_user.getUsername();
			    
			// then
			  assertEquals("Blaze", actual);       
		}
		
		@Test 
		@DisplayName("Set and Get Password")
		void Password(){
			//given
			   String PassWord = "123456789";
			   
			//when
			    new_user.setPassword(PassWord);
			    String actual = new_user.getPassword();
			    
			// then
			  assertEquals("123456789", actual);       
		}
		
		@Test 
		@DisplayName("Set and Get Adress")
		void Adress(){
			//given
			   String adress = "Uv18 Constantine";
			   
			//when
			    new_user.setAdress(adress);
			    String actual = new_user.getAdress();
			    
			// then
			  assertEquals("Uv18 Constantine", actual);       
		}
		
		@Test 
		@DisplayName("Set and Get Phone number")
		void Phone(){
			//given
			   String phone = "+213798961871";
			   
			//when
			    new_user.setPhone(phone);
			    String actual = new_user.getPhone();
			    
			// then
			  assertEquals("+213798961871", actual);       
		}
		
		@Test 
		@DisplayName("Set and Get Group")
		void Group(){
			//given
			   String group = "AB";
			   
			//when
			    new_user.setGroup(group);
			    String actual = new_user.getGroup();
			    
			// then
			  assertEquals("AB", actual);       
		}
		
		@Test 
		@DisplayName("Set and Get Type")
		void Type(){
			//given
			   String type = "Administrator";
			   
			//when
			    new_user.setType(type);
			    String actual = new_user.getType();
			    
			// then
			  assertEquals("Administrator", actual);       
		}
		
		@Test 
		@DisplayName("Set and Get Type")
		void Module(){
			//given
			   String module = "TQL";
			   
			//when
			    new_user.setModule(module);
			    String actual = new_user.getModule();
			    
			// then
			  assertEquals("TQL", actual);       
		}
		
	}
	

}
