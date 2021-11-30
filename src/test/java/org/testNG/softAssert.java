package org.testNG;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utilities.HelperClass;

public class softAssert extends HelperClass{
	@BeforeClass
	private void launchingChrome() {
		launchChrome();
		
		winMax();
	}
	
	@AfterClass
  private void closingChrome() {
		closeWindow();
	}
	@BeforeMethod
	  private void startTime() {
		Date d= new Date();
		System.out.println(d);
	}
	  @AfterMethod
	  private void endTime() {
		System.out.println(new Date());
	  }
	@Test
	private void tc1() {
		loadUrl("http://www.facebook.com");
		String title = driver.getTitle();
		System.out.println(title);
		SoftAssert s=new SoftAssert();
		s.assertTrue(title.contains("Face"), "Verify the Url");
		System.out.println("Checking");
		String current = driver.getCurrentUrl();
		System.out.println(current);
    	s.assertEquals(current, "https://www.facebook.com/", "verify the Url");
    	System.out.println("Details are valid");
        s.assertAll();
	}
	


}
