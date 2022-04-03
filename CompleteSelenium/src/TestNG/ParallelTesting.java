package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTesting {

	@Test
	public void OpenGoogle() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
		"C:\\Users\\RR System\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		Driver.quit();


	}
	@Test
	public void OpenBing() {
		System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\RR System\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://www.Bing.com");
		Driver.quit();
	}



}

