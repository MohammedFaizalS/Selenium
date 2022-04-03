package Selenium;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Selenium1 {




	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RR System\\Desktop\\chromedriver_win32\\chromedriver.exe");

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
	
		Driver .get("http://www.leafground.com/home.html");
		
		Driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")).click();

		Thread.sleep(1000);
		//MAIL
		WebElement emailBox=Driver.findElement(By.id("email"));
		emailBox.sendKeys("Test@gmail.com");
		Thread.sleep(1000);

		//APPEND
		WebElement appendBox=	Driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input"));
		appendBox.sendKeys("amazon");
		Thread.sleep(1000);


		//TESTLEAF
		WebElement getTextBox= Driver.findElement(By.name("username"));
		String value=getTextBox.getAttribute("value");
		System.out.println(value);
		Thread.sleep(1000);

		//clear me
		WebElement clearme =Driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/section[1]/div[4]/div[1]/div[1]/input[1]"));
		clearme.clear();
		Thread.sleep(1000);

		//disabled box
		WebElement disabledbox=Driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/section[1]/div[5]/div[1]/div[1]/input[1]"));
		boolean   enabled =disabledbox.isEnabled();
		System.out.println(enabled);

		Thread.sleep(1000);

		Driver .get("http://www.leafground.com/home.html");
		Thread.sleep(1000);
		Driver .get("http://www.leafground.com/pages/Button.html");
		Thread.sleep(1000);
		//GetPosition
		WebElement GetPosition=Driver.findElement(By.id("position"));

		org.openqa.selenium.Point xypoint = GetPosition. getLocation();
		int xValue=(int) xypoint.getX();
		int yValue=(int) xypoint.getY();

		System.out.println("x Value is:"+xValue+"Y Value"+yValue);
		Thread.sleep(1000);
		//find colour

		WebElement ColourButton=Driver.findElement(By.id("color"));
		String Colour=ColourButton.getCssValue("background-color");
		Thread.sleep(1000);
		System.out.println("ColourButton:"+Colour);


		//FIND SIZE

		WebElement SizeButton=Driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/section[1]/div[4]/div[1]/div[1]/button[1]"));
		int Heidht=SizeButton.getSize().getHeight();
		int Width=SizeButton.getSize().getWidth();
		System.out.println("ButtonHeight :"+ Heidht +  "ButtonWidth :"+ Width);

		Thread.sleep(1000);

		Thread.sleep(1000);
		//home Button
		Driver.findElement(By.id("home")).click();

		Thread.sleep(1000);

		Driver.get("http://www.leafground.com/pages/Dropdown.html");



		//dropdown1

		WebElement  dropdown1=Driver.findElement(By.id("dropdown1"));
		Select select=new Select(dropdown1);
		select.selectByIndex(4);
		Thread.sleep(1000);

		//dropdown2
		WebElement  dropdown2=Driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/div[3]/section[1]/div[2]/select[1]"));
		Select select1=new Select(dropdown2);
		select1.selectByVisibleText("UFT/QTP");

		Thread.sleep(1000);

		//dropdown3

		WebElement  dropdown3=Driver.findElement(By.id("dropdown3"));
		Select Select2=new Select(dropdown3);
		Select2.selectByValue("2");

		Thread.sleep(1000);
		//dropdown4


		@SuppressWarnings("unused")
		WebElement dropdown4=Driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/div[3]/section[1]/div[4]/select[1]"));
		List<WebElement> ListOfOption= 	select .getOptions();
		int size= ListOfOption.size();
		System.out.println("No.ofElement:"+size);
		Thread.sleep(1000);

		//dropdown5
		Driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/section[1]/div[5]/select[1]")).sendKeys("Loadrunner");
		Thread.sleep(1000);

		//dropdown6		
		/*
			WebElement MultiSelect =Driver.findElement(By.xpath("//option[contains(text(),'Select your programs')]"));		
			Thread.sleep(1000);
		    Select MultiSelectBox =new Select(MultiSelect);		
			MultiSelectBox.selectByVisibleText("Selenium");		
			MultiSelectBox .selectByVisibleText("Appium");
			MultiSelectBox .selectByVisibleText("UFT/QTP");

		 */

		Driver .get("http://www.leafground.com/pages/Alert.html");


		//AlertBox
		WebElement AlertBox=Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div/div/button"));
		AlertBox.click();
		Alert alert=Driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);
		//confirmbox
		WebElement confirmAlert =Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		confirmAlert.click();
		Alert confirm=Driver.switchTo().alert();
		confirm.dismiss();
		Thread.sleep(1000);
		//Prompt Box
		WebElement PromptBox=Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div/div/button"));
		PromptBox.click();
		Alert prompt=Driver.switchTo().alert();
		prompt.sendKeys("amazon");
		prompt.accept();
		Thread.sleep(1000);


		Driver.get("http://www.leafground.com/pages/radio.html");


		//Are you enjoying the classes?

		Driver.findElement(By.xpath("//*[@id=\'first\']/label[1]")).click();


		//Unchecked
		WebElement Unchecked=Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/label[2]/input"));
		//Checked
		WebElement Checked=Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/label[3]/input"));

		boolean status1=Unchecked.isSelected();
		boolean status2=Checked.isSelected();
		System.out.println("Unchecked:"+status1);
		System.out.println("checked:"+status2);
		Thread.sleep(1000);

		//AGE GROUP

		WebElement below20=Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div/div/input[1]"));
		below20.click();

		Thread.sleep(1000);

		Driver.get("http://www.leafground.com/pages/checkbox.html");

		//java
		Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		//Confirm Selenium is checked
		WebElement selenium=Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/input"));        
		boolean seleniumselected=selenium.isSelected();
		System.out.println("selenium is selected:"+seleniumselected);
		Thread.sleep(1000);
		//DeSelect only checked

		WebElement firstelement =Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div[1]/input"));

		if (firstelement.isSelected()) {
			firstelement.click();

		}


		WebElement secondelement=Driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[2]/input"));

		if (secondelement.isSelected()) {
			secondelement.click();

		}
		Thread.sleep(1000);
		//select all

		Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/div[1]/input")).click();
		Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/div[5]/input")).click();
		Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/div[2]/input")).click();
		Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/div[4]/input")).click();
		Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/div[3]/input")).click();


		Thread.sleep(5000);







		
Driver.quit();
	}





}




	


