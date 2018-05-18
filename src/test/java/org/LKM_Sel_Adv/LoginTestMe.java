package org.LKM_Sel_Adv;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelUtility;

public class LoginTestMe {
	private WebDriver driver;
	private static int rownum=0;
	private int colnum=2;

	@Test(dataProvider = "logindata", priority = 1)
	public void test_me_login(String uname,String pass) throws Exception {
		// ExcelUtility.setExcelpath("Sheet1", "C:\\Users\\A06438_P5.Training\\Desktop\\Selenium_Software\\Test Data.xlsx");
		try {
			driver.findElement(By.id("userName")).clear();
			driver.findElement(By.id("userName")).sendKeys(uname);
			driver.findElement(By.cssSelector("#password")).clear();
			driver.findElement(By.cssSelector("#password")).sendKeys(pass);
			driver.findElement(By.cssSelector("input.btn:nth-child(1)")).click();
			String title = driver.getTitle();
			Assert.assertEquals(title, "Home");



			// Assert.assertEquals(driver.getTitle(), "Home");
			ExcelUtility.SetExcelCell(rownum, colnum, "Pass");
		}
		catch (AssertionError e) {
			ExcelUtility.SetExcelCell(rownum, colnum, "Fail");
		}
		finally {
			rownum++;
			//driver.navigate().to("http://localhost:8083/TestMeApp/login.htm");
		}

	}
	
	@Test(priority=2)
	public void select_category() {
		WebElement category = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/a/span"));
				Actions act = new Actions(driver);
		act.moveToElement(category).click().build().perform();
		WebElement electronics = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[1]/a/span"));
		act.moveToElement(electronics).click().build().perform();
		WebElement headfons = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[1]/ul/li[1]/a/span"));
		act.moveToElement(headfons).click().build().perform();
		
		WebElement button = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a"));
		act.moveToElement(button).click().build().perform();
		
		WebElement cart = driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]"));
		act.moveToElement(cart).click().build().perform();
		
		WebElement checkout = driver.findElement(By.xpath("/html/body/main/section/div[3]/table/tfoot/tr[2]/td[5]/a"));
		act.moveToElement(checkout).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"add1\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"add1\"]")).sendKeys("Pune");
		
		WebElement pay = driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input"));
		act.moveToElement(pay).click().build().perform();
		
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div[1]/div[1]/div/label/i")).click();
		
		WebElement button1 =driver.findElement(By.xpath("//*[@id=\"btn\"]"));
		act.moveToElement(button1).click().build().perform();
		
		
		
		
		
		
		
		
	}

	@DataProvider(name="logindata")
	public String[][] login_data() throws Exception {
		ExcelUtility.setExcelpath("Sheet1", "C:\\Users\\A06438_P5.Training\\Desktop\\Selenium_Software\\Test Data.xlsx");
		String[][] tabledata = ExcelUtility.getExcelTable();
		return tabledata;
	}


	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Selenium_Software\\selenium_new1\\Driver\\geckodriver-v0.20.1-win64 (1)\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8083/TestMeApp/login.htm");
		driver.navigate().back();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
