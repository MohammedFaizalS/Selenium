package TestNG;

import org.testng.annotations.Test;

public class SampleTestNG {
	
	@Test(priority = 0)
	public void firsTtestCase() {
		System.out.println("This is The first TestCase");
	}
	@Test(priority = 2)
	public void secondTtestCase() {
		System.out.println("This is The 2 TestCase");
	}
	@Test(priority = 3)
	public void thirdTtestCase() {
		System.out.println("This is The 3 TestCase");
	}
	@Test(priority = 4)
	public void fourthTtestCase() {
		System.out.println("This is The 4 TestCase");
	}

}
