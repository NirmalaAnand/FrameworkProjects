package org.testNG;

import java.io.IOException;
import java.util.Date;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utilities.FBLoginPojo;
import org.utilities.HelperClass;

public class Para extends HelperClass {
	@BeforeClass
	private void launchingChrome() {
		launchChrome();
		loadUrl("https://www.facebook.com");
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
 @Parameters({"user","pass"})

  @Test
  private void tc1(@Optional("sele")String s1,@Optional("sele@123")String s2) throws IOException, InterruptedException {
	  FBLoginPojo f=new FBLoginPojo();
	  fill(f.getTxtUser(),s1 );
	  fill(f.getTxtPass(),s2);
	  btnClick(f.getBtnLogin());
	  
		
}

  
 

}
