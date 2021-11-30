package org.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.HelperClass;

public class Annotations extends HelperClass {

	@BeforeClass
	private void launchingChrome() {
		launchChrome();

	}

	@AfterClass
	private void closingChrome() {
		closeWindow();
	}
	
	
	@BeforeMethod
	private void startTime() {
		System.out.println("start");

	}
	@AfterMethod
	private void endTime() {
		System.out.println("end");

	}
	@Test
	
	private void testCase1() {
		System.out.println("Test1");
	}
	@Test
	private void testCase2() {
		System.out.println("Test2");

	}
}
