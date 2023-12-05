package BankProject;

import static org.testng.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import PageObject.BankingAppLoginPage;
import Utilities.BaseClass;
import Utilities.PropertyFile;

public class TC_Login_001 extends BaseClass {


	@Test
	public void BankApp_Login() throws Exception {
		BankingAppLoginPage Login = new BankingAppLoginPage(driver);
		PropertyFile p = new PropertyFile();
		String title = driver.getTitle();
		Assert.assertEquals(title, p.PropertyFile("BankHomePageTitle"));
		Login.AdminLogin(UsName, Pwd);
		Thread.sleep(1000);
       if(driver.getTitle().equals(p.PropertyFile("ExpTitle"))) {
    	   Assert.assertTrue(true);
       }
       else {
    	   Assert.assertFalse(false);
       }
		
	}

}
