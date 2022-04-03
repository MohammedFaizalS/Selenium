package TestNG;

import org.testng.annotations.Test;

public class GroupingExample {

	@Test(groups = {"Apple"})
	public void Apple1() {
		System.out.println("Apple Testing");	
	}
	@Test(groups = {"Apple"})	
	public void Apple2() {
		System.out.println("Apple Testing");	
	}
	@Test(groups = {"Moto"})
	public void Moto1() {
		System.out.println("Moto Testing");
	}
	@Test(groups = {"Moto"})
	public void Moto2() {
		System.out.println("Moto Testing");
	}
	@Test(groups = {"Vivo"})
	public void Vivo1() {
		System.out.println("Vivo Testing");
	}
	@Test(groups = {"Vivo"})
	public void Vivo2() {
		System.out.println("Vivo Testing");
	}
	@Test(groups = {"lenovo"})
	public void lenovo1() {
		System.out.println("lenovo Testing");
	}
	@Test(groups = {"lenovo"})
	public void lenovo2() {
		System.out.println("lenovo Testing");
	}







}
