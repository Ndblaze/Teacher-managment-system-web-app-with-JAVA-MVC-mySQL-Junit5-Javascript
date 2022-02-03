package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProjectTest {
	
	calculator cal = new calculator();

	@Test
	void getANumber() {
		//given
		int num1 = 20;
		int num2 = 30;
		
		//when
		int result = cal.add(num1, num2);
		
		//then
		assertEquals( 50 ,result, "the test if true");
			
	}
	
	class calculator {
		int add(int a, int b){
			return a+b;	
		}
	}

}
