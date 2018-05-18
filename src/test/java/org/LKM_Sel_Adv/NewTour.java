package org.LKM_Sel_Adv;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class NewTour {
	private WebDriver driver;
	
	
  @Test
  public void register() {
	  	  
	  driver.findElement(By.linkText("REGISTER")).click();
	  driver.findElement(By.name("firstName")).sendKeys("Pranav");
	  driver.findElement(By.name("lastName")).sendKeys("Gupta");
	  driver.findElement(By.id("userName")).sendKeys("er.pranavgupta13@gmail.com");
	  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")).sendKeys("Magarpatta Pune");
	  driver.findElement(By.name("city")).sendKeys("Pune");
	  
	  Select country = new Select(driver.findElement(By.name("country")));
	  country.selectByVisibleText("INDIA");

	  driver.findElement(By.cssSelector("input[name='email']")).sendKeys("mercury");
	  
  }
  
  @Test
  public void login() {
	  LoginPageObject.uname.sendKeys("selenium");
	  LoginPageObject.pass.sendKeys("selenium");
	  LoginPageObject.Submit.click();
	  
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Selenium_Software\\selenium_new1\\Driver\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com");
	  PageFactory.initElements(driver,LoginPageObject.class);
	  
  }
  

  @AfterTest 
  public void afterTest() {
	  
	  driver.close();
  }

}
