package org.pomframework;

import java.io.IOException;

import org.utilities.FBLoginPojo;
import org.utilities.HelperClass;

public class Task1 extends HelperClass {
	public static void main(String[] args) throws IOException {
		launchChrome();
		loadUrl("https://www.facebook.com/");
		winMax();
		printTitle();
		printCurrentUrl();
		
		FBLoginPojo f=new FBLoginPojo();
		fill(f.getTxtUser(), getData(1, 0));
		
		fill(f.getTxtPass(),getData(1, 1));
		btnClick(f.getBtnLogin());
		
		
		
	}
	
	
	

}
