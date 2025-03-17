package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicDemo {
	public static WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		//open the browser and url
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@AfterTest
	public void afterTest() {
		//close the browser window
		driver.quit();
	}
	
	
	@Test
	public void pageTitleValidation() {
		String expectedResult = "Facebook – log in or sign up";
		String actualResult = driver.getTitle();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);

		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title");
	}
	
	@Test
	public void welcomeMessageValidation() {
		String expectedResult = "Facebook helps you connect and share with the people in your life.";
		
		String actualResult = driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);

		assertTrue(actualResult.equals(expectedResult), "Mismatch in the welcome message");
	}
}














