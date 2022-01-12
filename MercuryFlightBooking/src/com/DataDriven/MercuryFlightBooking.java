package com.DataDriven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Test.Utility.TestUtility;

public class MercuryFlightBooking {
	
	
WebDriver driver;
	
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Installers\\WebDrivers\\chromedriver_win32_2\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = TestUtility.getTestDataFromExcel();
		return testData.iterator();
	}
	
	
	@Test(dataProvider = "getTestData")
	public void FlighBookingReg(String firstName, String lastName, String phone, String email, String address, String city, String state, String p_code, String u_name, String country, String password, String c_password)
	{
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		
		driver.findElement(By.xpath("//input[@name='firstName']")).clear();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//input[@name='lastName']")).clear();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='phone']")).clear();
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
		
		driver.findElement(By.xpath("//input[@name='userName' and @id='userName']")).clear();
		driver.findElement(By.xpath("//input[@name='userName' and @id='userName']")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@name='address1']")).clear();
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
		
		
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		
		driver.findElement(By.xpath("//input[@name='state']")).clear();
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		
		driver.findElement(By.xpath("//input[@name='postalCode']")).clear();
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(p_code);
		
		driver.findElement(By.xpath("//input[@name='postalCode']")).clear();
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(p_code);
		
		Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		select.selectByVisibleText(country);
		
		driver.findElement(By.xpath("//input[@name='email' and @id='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email' and @id='email']")).sendKeys(u_name);
		
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).clear();
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(c_password);
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	}
	
	@Test(dataProvider = "getTestData")
	public void FlighBookingSignOn(String firstName, String lastName, String phone, String email, String address, String city, String state, String p_code, String u_name, String country, String password, String c_password)
	{
		driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).click();
		
		
		driver.findElement(By.xpath("//input[@name='userName']")).clear();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(u_name);
		
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		
		
		WebElement ele = driver.findElement(By.xpath("//input[@name='submit']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
		
		if (driver.findElement(By.xpath("//h3[text()='Login Successfully']")).isDisplayed()) 
		{
			System.out.println("Login Successful");
		}
		
		else {
			System.out.println("Login Failure");
		}
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
