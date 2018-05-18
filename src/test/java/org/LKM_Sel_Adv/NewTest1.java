package org.LKM_Sel_Adv;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest1 {
  @Test
  public void z() {
	  System.out.println("this is a new test");
  }
  @Test
  public void failtest() {
	  try {
		  
		  int a,b=10,c=0;
		  a=b/c;
		  System.out.println("Result" +a);
		 	  } catch(Exception e) {
		 		  throw e;
		 	  }
  } 
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("this is before test ");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("this is after test");
  }

}
