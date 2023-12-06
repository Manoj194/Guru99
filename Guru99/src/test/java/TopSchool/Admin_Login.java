package TopSchool;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.TopScl_Page;
import Utilities.BaseClass;
import Utilities.PropertyFile;
import Utilities.WebdriverUtility;

public class Admin_Login extends BaseClass{
	
	@Test
	@SuppressWarnings("static-access")
	public void AdminLogin() throws IOException, InterruptedException {
		TopScl_Page TopScl = new TopScl_Page(driver);
		WebdriverUtility web = new WebdriverUtility();
		PropertyFile p = new PropertyFile();
		 WebElement wclTxt = driver.findElement(By.xpath("//h4[@class=\"text-left font-weight-bold text-left w-100\"]"));
		if(wclTxt.getText().equalsIgnoreCase("Welcome!")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.xpath("(//div[@class=\"loginRoleSectImg\"])[1]")).click();
		TopScl.TopSclAdminLogin(p.PropertyFile("TopUs"), p.PropertyFile("TopSclPwd"));
		 WebElement ell = driver.findElement(By.xpath("//div[@class=\"MuiAlert-message css-1xsto0d\"]"));
		 Thread.sleep(1000);
		if(ell.getText().equals(ell.getText()) && ell.isDisplayed()) {
		System.out.println("Logged succesfully");
		}
		else {
			System.out.println("Logged succesfully Failed");
		}
		WebElement SideBar = driver.findElement(By.xpath("//div[@class=\"side-nav-content \"]"));
		web.MouceHover(driver, SideBar);
		 Thread.sleep(4000);
		 // Script is completed
		 // hii
		 
	}

}
