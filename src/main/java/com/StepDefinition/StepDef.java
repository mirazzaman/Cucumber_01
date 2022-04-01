package com.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mongodb.assertions.Assertions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	
	@Given("^user is  on homepage$")
	public void user_is_on_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/miraz/Documents/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.demo.iscripts.com/multicart/demo/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	   
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		 driver.findElement(By.xpath("//button[@id='dLabellogin']")).click();
	 
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String uname, String pass) throws Throwable {
	  	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@id='jqLogin']")).click();
	}
   


	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
 Thread.sleep(3000);
    	String name = driver.findElement(By.xpath("//*[@id='dLabel']/span")).getText();
    	System.out.println(name);
      
        driver.quit();
        
      //*[@id="header"]/div[2]/div/div/nav/div[1]/a/span
	
	}

}
//@FindBy(xpath = "//button[@id='dLabellogin']")
//WebElement login_source_button;
//
//@FindBy(xpath = "//input[@id='username']")
//WebElement user_name;
//
//@FindBy(xpath = "//input[@id='password']")
//WebElement pass_word;
//
//@FindBy(xpath = "//button[@id='jqLogin']")
//WebElement login_Button;
//
//@CacheLookup
//@FindBy(xpath = "//*[@id='dLabel']/span")
//WebElement current_User_Name;
//
//@FindBy(xpath = "//img[@class='img-responsive']")
//WebElement login_Image;