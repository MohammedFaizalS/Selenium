package stepDefinations;


import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class MyStepDefinitions {


    @Given("^validate the browser$")
    public void validate_the_browser(){
    	System.out.println("browser get started");
    }
   
    @When("Browser is Triggered")
    public void browser_is_triggered() {
        
    	System.out.println("opening  chrome browser");
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chr\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Edit.html");
		}

    @Then("Check if the browser is started")
    public void check_if_the_browser_is_started() {
    	System.out.println("browser Navigated to page");
     
    }
   
    @Given("^User is on Net bank landing page1$")
    public void user_is_on_net_bank_landing_page1(){
    	System.err.println("user is on login page");    	
    }   
    
    @When("User login into application with {string} and {string}")
    public void user_login_into_application_with_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
       System.out.println(string);
       System.out.println(string2);
    }
    @When("^User sign with following detail$")
    public void user_sign_with_following_detail(DataTable data){
    	List<List<String>> obj = data.asLists();
    	System.out.println(obj.get(0).get(0));
        System.out.println(obj.get(0).get(1));

        System.out.println(obj.get(0).get(2));

        System.out.println(obj.get(0).get(3));
    }
    

    @Then("^Home page is populated$")
    public void home_page_is_populated(){
    	System.out.println("login succesfully");
        }
    @Then("Card are displayed {string}")
    public void card_are_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(string);
    }
    

    @When("^user sign in to following detail(.+) and(.+)$")
    public void user_sign_in_to_following_detail_and(String username, String password) throws Throwable {
       System.out.println(username);
       System.out.println(password);
    }
}