package org.testNG;

import java.io.IOException;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.FBLoginPojo;
import org.utilities.HelperClass;

public class Invocation extends HelperClass {
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
  @Test(invocationCount=4)
  private void tc1() throws IOException, InterruptedException {
	  
	  FBLoginPojo f=new FBLoginPojo();
	  fill(f.getTxtUser(), getData(1,0));
	  fill(f.getTxtPass(),getData(1,1));
	  btnClick(f.getBtnLogin());
	  Thread.sleep(7000);
		
}

}
