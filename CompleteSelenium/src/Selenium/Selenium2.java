package Selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RR System\\Desktop\\chromedriver_win32\\chromedriver.exe");

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver .get("http://www.leafground.com/pages/Window.html");
		//Click button to open home page in New Window
		
		String oldWindow=Driver.getWindowHandle();

	

		WebElement FirstButton =Driver.findElement(By.id("home"));
		FirstButton .click();
		Set<String>handles= Driver.getWindowHandles();

		
		for (String newwindow : handles) {
			Driver.switchTo().window(newwindow);

		}
		WebElement editbox=Driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a/h5"));
		editbox.click();
		Driver.close();
		Driver.switchTo().window(oldWindow);

		//Find the number of opened windows

		WebElement OpenMultiple=Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		OpenMultiple.click();
		int NumberOfWindows =  Driver.getWindowHandles().size();

		System.out.println("NumberOfWindowsOpened:"+NumberOfWindows);

		//Close all except this window
		WebElement DontCloseMe=Driver.findElement(By.id("color"));
		DontCloseMe.click();
		Set<String> NewWindowsHandles=Driver.getWindowHandles();

		for (String allwindows : NewWindowsHandles) {
			if (!allwindows.equals(oldWindow)) {	
			}
		}
		Driver.switchTo().window(oldWindow);
		Driver.close();
	
		
		/* Driver.switchTo().window = To Move To New/Old Window
		   getWindowHandle() =will get you current windows handle
		   getWindowHandles() =will gives you all windows data
		   getWindowHandles().size() = no.of windows opened     */

		Driver.quit();

		
		
		

		
	}

}
