package BankProject;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BankingAppLoginPage;
import Utilities.BaseClass;
import Utilities.PropertyFile;
import Utilities.WebdriverUtility;

public class Dropdownhandle extends BaseClass{
	
	@Test(groups = { "reg"})
	public void DropdownHandle_by_index() throws IOException, InterruptedException {
		WebdriverUtility web = new WebdriverUtility();
		BankingAppLoginPage Login = new BankingAppLoginPage(driver);
		PropertyFile p = new PropertyFile();
		String title = driver.getTitle();
		Assert.assertEquals(title, p.PropertyFile("BankHomePageTitle"));
        driver.findElement(By.xpath("//a[contains(.,'Payment Gateway Project')]")).click();
        WebElement ele = driver.findElement(By.xpath("//select[@name=\"quantity\"]"));
        web.dropdownByIndex(ele, 4);
        Thread.sleep(4000);
	}
	@Test
	public void DropdownHandle_by_text() throws IOException, InterruptedException {
		WebdriverUtility web = new WebdriverUtility();
		BankingAppLoginPage Login = new BankingAppLoginPage(driver);
		PropertyFile p = new PropertyFile();
		String title = driver.getTitle();
		Assert.assertEquals(title, p.PropertyFile("BankHomePageTitle"));
        driver.findElement(By.xpath("//a[contains(.,'Payment Gateway Project')]")).click();
        WebElement ele = driver.findElement(By.xpath("//select[@name=\"quantity\"]"));
        web.dropdownByText(ele, "4");
          ele.isSelected();
        Thread.sleep(4000);
	}
	
	@Test
	public void ScrollIntoView() throws IOException, InterruptedException {
		WebdriverUtility web = new WebdriverUtility();
		BankingAppLoginPage Login = new BankingAppLoginPage(driver);
		PropertyFile p = new PropertyFile();
		String title = driver.getTitle();
		Assert.assertEquals(title, p.PropertyFile("BankHomePageTitle"));
        driver.findElement(By.xpath("//a[contains(.,'Payment Gateway Project')]")).click();
        WebElement ele = driver.findElement(By.xpath("//select[@name=\"quantity\"]"));
        if(ele.isDisplayed()==true) {
        	//Assert.assertTrue(true, "Yes Element is Displayed");
        	System.out.println("Yes Element is Displayed");
        }
        else {
        	Assert.assertTrue(false, " Element is Not Displayed");
        }
        web.ScrollIntoView(driver, ele);
        Thread.sleep(4000);
	}
}

