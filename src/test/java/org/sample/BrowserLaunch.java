package org.sample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utilities.HelperClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends HelperClass {
	public static void main(String[] args) throws IOException {
		launchChrome();
		loadUrl("https://www.facebook.com");
		winMax();
		printTitle();
		printCurrentUrl();
		WebElement txtUser = driver.findElement(By.id("email"));
		fill(txtUser,getData(2,1 ));
		WebElement txtPass = driver.findElement(By.id("pass"));
		fill(txtPass,getData(3,2));
		WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
		
	}
	

}
