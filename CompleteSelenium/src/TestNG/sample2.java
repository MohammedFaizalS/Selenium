package TestNG;

import org.testng.annotations.Test;
//(priority = 0)     -IS USED TO Arrange in order
public class sample2 { 
	@Test(enabled = true)
	public void Highschool() {
		System.out.println("Highschool");
	}
	@Test(dependsOnMethods = "Highschool")
	public void Highseconsdary() {
		System.out.println("HigherSec");
	}
	@Test(dependsOnMethods ="Highseconsdary" )
	public void Engineering() {
		System.out.println("collage");
	}

}
