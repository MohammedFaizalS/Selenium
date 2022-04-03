package TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

@Test
public class AssertionsExample {

	String name ="Agni";
	Boolean value =false;

	public void checkequal() {
		/*if (name.equals("Agni")) {
			System.out.println("Name is equal");
		}else {
			System.out.println("Name is not equal");
		}*/      //(OR)

		assertEquals(name, "Agni");

		//Assert.assertfalse(value,"this should not be false");
		
		
		//assartion is used in unit testing





	}



}
