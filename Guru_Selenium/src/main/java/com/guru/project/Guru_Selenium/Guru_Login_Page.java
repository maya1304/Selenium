package com.guru.project.Guru_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import org.testng.annotations.Test;

@Test
public class Guru_Login_Page {

	
	 WebDriver driver;
	 Alert alert;
	 
	 @Test
	 public void invokeBrowser()
	 {
		 System.setProperty("webdriver.chrome.driver","C:\\selenium-java-3.141.59\\Webdriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
		 driver.get(" http://www.demo.guru99.com/V4/");
		 
	 }
	 @Test
	 public void loginBrowser()
	 {
		 System.out.println("URL is Launching");
		 driver.findElement(By.name("uid")).sendKeys("fsd");
		 driver.findElement(By.name("password")).sendKeys("absdfdAqYhu");
		 driver.findElement(By.name("btnLogin")).click();
		 driver.switchTo().alert().getText();
		 String response = driver.switchTo().alert().getText();
		 System.out.println(response);
		 Assert.assertTrue(response.equalsIgnoreCase("User or Password is not valid"), "Test Passed");
		/* if(response.equalsIgnoreCase("User or Password is not valid"))
		 {
			 System.out.println("Test Case Failed");
		 }
		 else 
		 {
			 System.out.println("Test Case Passed");
		 }*/
		 driver.quit();
	 }

	

/*public static void main(String[] args) 
	{
		Guru_Login_Page obj = new Guru_Login_Page();
		obj.invokeBrowser();
		obj.loginBrowser();
				

	}*/

}

