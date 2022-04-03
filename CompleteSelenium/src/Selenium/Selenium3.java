package Selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Selenium3 {

	@Test
	public static void main(String[] args) throws InterruptedException, Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RR System\\Desktop\\chromedriver_win32\\chromedriver.exe");

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();

		Driver.get("http://www.leafground.com/pages/frame.html");

		//I am inside a frame
		Driver.switchTo().frame(0);
		WebElement button1=Driver.findElement(By.id("Click"));
		button1.click();

		//I am inside a nested frame
		String  text=Driver.findElement(By.id("Click")).getText();
		System.out.println(text);
		Driver.switchTo().defaultContent();

		Driver.switchTo().frame(1);
		Driver.switchTo().frame("frame2");
		WebElement button2=Driver.findElement(By.id("Click1"));
		button2.click();

		//Find total number of frames.

		Driver.switchTo().defaultContent();
		List<WebElement> totalFrames= Driver.findElements(By.tagName("iframe"));
		int size =totalFrames.size();
		System.out.println(size);



		//Play with Droppable


		Driver.get("http://www.leafground.com/pages/drop.html");

		WebElement From=Driver.findElement(By.id("draggable"));
		WebElement To=Driver.findElement(By.id("droppable"));

		Actions actions =new Actions(Driver);

		actions.clickAndHold(From).moveToElement(To).release(To).build().perform(); 
		//            (or)
		//actions.dragAndDrop(From, To).build().perform();
		Thread.sleep(2000);

		//Interact with Tool Tip

		Driver.get("http://www.leafground.com/pages/tooltip.html");

		WebElement name=Driver.findElement(By.id("age"));
		String toolTipText= name.getAttribute("title");
		System.out.println("toolTipText:"+toolTipText);

		//Play with Selectable
		Driver.get("http://www.leafground.com/pages/selectable.html");

		List<WebElement> selectable=Driver.findElements(By.xpath("//*[@id=\'selectable\']/li"));
		int listsize=selectable.size();
		System.out.println(listsize);
		/*
		Actions actions1=new Actions(Driver);
		actions1.keyDown(Keys.CONTROL)
		.click(selectable.get(0))
		.click(selectable.get(1))
		.click(selectable.get(2)).build().perform(); */
		//(OR)

		@SuppressWarnings("unused")
		Actions actions1=new Actions(Driver);
		actions.clickAndHold(selectable.get(0));
		actions.clickAndHold(selectable.get(1));
		actions.clickAndHold(selectable.get(2));
		actions.build().perform();		
		Thread.sleep(2000);


		//Interact with Auto Complete
		Driver.get("http://www.leafground.com/pages/autoComplete.html");

		WebElement input =Driver.findElement(By.id("tags"));
		input.sendKeys("s");
		Thread.sleep(4000);
		List<WebElement> optionlist=Driver.findElements(By.xpath("//*[@id=\'ui-id-1\']/li"));

		System.out.println(optionlist.size());
		for (WebElement webElement : optionlist) {
			if (webElement.getText().equals("Selenium")) {
				webElement.click();						
				System.out.println("selecting"+webElement.getText());
				break;
			}

		}

		//DOWNLOAD FILES
		Driver.get("http://www.leafground.com/pages/download.html");

		WebElement Downloadlink =Driver.findElement(By.linkText("Download Excel"));
		Downloadlink.click();
		Thread.sleep(3000);

		//check Downloaded file

		File filelocation =new File("C:\\Users\\RR System\\Downloads");
		File[] totalfiles=filelocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("testleaf.xlsx")) {
				System.out.println("File Is Downloaded");
				break;
			}
		}

		//Upload File

		//Upload File
		Driver.get("http://www.leafground.com/pages/upload.html");
		Driver.findElement(By.name("filename"))
		.sendKeys("C:\\Users\\RR System\\Downloads\\testleaf.xlsx");

		//      (NOTWORKING)	
		/*	Driver.get("http://www.leafground.com/pages/upload.html");
		WebElement UploadFiles =Driver.findElement(By.name("filename"));
		UploadFiles.click();
		//Windows

		StringSelection Selection=new StringSelection("C:\\Users\\RR System\\Downloads\\testleaf.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Selection, null);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		 */

		//Interact with Images

		//Click on this image to go home page

		Driver.get("http://www.leafground.com/pages/Image.html");
		WebElement firstimage=Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div/div/img"));
		firstimage.click();

		//Am I Broken Image?
		Driver.get("http://www.leafground.com/pages/Image.html");
		WebElement Brokenimage =Driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/img"));
		//"naturalWidth" = 0 then it is brokenimage else its not A BROKEN IMAGE

		if (Brokenimage.getAttribute("naturalWidth").equals("0")) {
			System.out.println("The Image Is Broken");
		}else {
			System.out.println("The Image Is Not Broken");
		}


		//		Play with HyperLinks

		//navigate().to =we can able to do refresh,forward,backward
		//Get() = we cannot able to do refresh,forward,backward
		Driver.navigate().to("http://www.leafground.com/pages/Link.html");

		WebElement homepagelink = Driver.findElement(By.linkText("Go to Home Page"));
		homepagelink.click();
		Driver.navigate().back();

		//Find where am supposed to go without clicking me?
		WebElement wheretogo =Driver.findElement(By.partialLinkText("Find where"));
		String where = wheretogo.getAttribute("href");
		System.out.println("This Link Is Going To:"+where);

		//Verify am I broken?
		WebElement brokenLink =Driver.findElement(By.linkText("Verify am I broken?"));
		brokenLink.click();
		String title =Driver.getTitle();
		if (title.contains("404")) {
			System.out.println("Link Is Broken");
		}
		Driver.navigate().back();

		//Go to Home Page (Interact with same link name)
		WebElement homepagelink1 = Driver.findElement(By.linkText("Go to Home Page"));
		homepagelink1.click();

		Driver.navigate().back();

		//how many links available in this page??

		//to find link we should use "a"tag ;for image we should use"img"
		List<WebElement> totallinks=Driver.findElements(By.tagName("a"));
		int linkcount =	totallinks.size();
		System.out.println("Total links:"+linkcount);


		//                Toy with Tables
		//Get the count of number of columns
		Driver.navigate().to("http://www.leafground.com/pages/table.html");
		List<WebElement> colums=Driver.findElements(By.tagName("th"));
		int ColumnCount=colums.size();
		System.out.println("Number Of Columns:"+ColumnCount);

		//Get the count of number of columns
		List<WebElement> rows=Driver.findElements(By.tagName("tr"));
		int RowCount=rows.size();
		System.out.println("Number Of Rows:"+RowCount);

		//Get the progress value of 'Learn to interact with Elements

		WebElement getpercent =Driver.findElement(By.xpath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]"));
		String percent= getpercent.getText();
		System.out.println("percentage is"+percent);

		//Check the vital task for the least completed progress.
		//replace("%", "") =is used to convert individual to percentage 
		List<WebElement> allprogress=Driver.findElements(By.xpath("//td[2]"));
		List<Integer> numberlist=new ArrayList<>();

		for (WebElement webElement : allprogress) {
			String individualvalue=webElement.getText().replace("%", "");
			numberlist.add(Integer.parseInt(individualvalue));
		}
		System.out.println("final list"+numberlist);

		int smallvalue=Collections.min(numberlist);
		System.out.println(smallvalue);
		String smallvaluestring= Integer.toString(smallvalue)+"%";
		String finalxpath ="//td[normalize-space()="+"\""+ smallvaluestring +"\""+"]"+"//following::td[1]"; 

		System.out.println(finalxpath);

		WebElement check =Driver.findElement(By.xpath("//td[normalize-space()=\"30%\"]//following::td[1]"));
		check.click();


		WebElement click2=Driver.findElement(By.xpath("//*[@id=\'table_id\']/tbody/tr[4]/td[3]/input"));
		click2.click();



		//Play with Sortable
		Driver.navigate().to("http://www.leafground.com/pages/sortable.html");
		List<WebElement> elements  =Driver.findElements(By.xpath("//*[@id='sortable']/li"));


		WebElement fromeElement=elements.get(6);
		WebElement toElement=elements.get(0);
		Actions actions11=new Actions(Driver);

		actions11.clickAndHold(fromeElement);
		actions11.clickAndHold(toElement);
		actions11.release(toElement);
		actions11.build().perform();



		Thread.sleep(3000);
		Driver.quit();
	}




}


