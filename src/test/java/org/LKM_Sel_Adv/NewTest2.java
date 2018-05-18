package org.LKM_Sel_Adv;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest2 {
  @Test(dataProvider = "Logindata")
  public void f(String uname, String pass) {
	  System.out.println(uname+""+pass);
  }
  

  @DataProvider
  public String[][] Logindata() {
    return new String[][] {
      new String[] { "user1", "pass1" },
      new String[] { "user2", "pass2" },
      new String[] { "user3", "pass3" },
    };

  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("this is before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("this is after method");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("this is beofre test ");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("this is after test ");
  }

}
