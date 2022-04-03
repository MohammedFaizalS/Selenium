package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationExample {
	
	
	//HPALM() in which Actual test cases are stored in a software has an unique id numeric no.
	//after finishing testcase we identify wheather it passed in ALM
	/*  TO UPDATE IN ALM
	 TEST SUITE ID->1234
	 TEST ID->12
	 TEST ID
	 TEST ID
	 TEST ID 
	 */
 @Test
 @Parameters("Name")
	public void printname(String name) {
		System.out.println("Name is"+name);
		
	}
	
	
}
