package TestNG;
                                      
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Sample3 {
	private static final long StartTime = 0;
	WebDriver driver;
	@BeforeSuite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RR System\\Desktop\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
				
	}
	//OPEN Google
	@Test
	public void openGoogle() {
		long StartTime=System. currentTimeMillis();
	driver.get("http://www.gooogle.co.in");
	}
 
	//OPEN BING
	@Test
	public void openBing() {
		driver.get("http://www.bing.com");
	}

	//OPEN YAHOO
	@Test
	public void openYahoo() {
		driver.get("http://www.yahoo.com.");
	}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		long EndTime = System.currentTimeMillis();
		long TotalTime=EndTime-StartTime;
		System.out.println("TotalTimeTaken:"+TotalTime);

	}
} 

 
              //anotation 
             // @Test
            //@BeforeSuite
           //@AfterSuite

