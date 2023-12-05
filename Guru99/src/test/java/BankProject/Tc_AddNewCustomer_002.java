package BankProject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BankingAppLoginPage;
import PageObject.NewCustomerPage;
import Utilities.BaseClass;
import Utilities.PropertyFile;

public class Tc_AddNewCustomer_002 extends BaseClass {
	@Test
	public void Add_Cust_details() throws IOException, InterruptedException, ParseException {
		String rand = RandomStringUtils.randomAlphabetic(5);
		BankingAppLoginPage Login = new BankingAppLoginPage(driver);
		NewCustomerPage Cust = new NewCustomerPage(driver);
		PropertyFile p = new PropertyFile();
		String title = driver.getTitle();
		Assert.assertEquals(title, p.PropertyFile("BankHomePageTitle"));
		Login.SetUserName(UsName);
		Login.SetUserPWD(Pwd);
		Login.LoginBtn();
		Thread.sleep(1000);
		Cust.NewCustomer_Tab();
		Cust.Cust_name_TxtField("Manoj"+rand+"BH");
		driver.findElement(By.xpath("//input[@checked]")).click();
		Thread.sleep(11000);
		driver.findElement(By.xpath("//textarea[@name=\"addr\"]")).sendKeys("Bg palya");
		driver.findElement(By.xpath("//input[@name=\"city\"]")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@name=\"state\"]")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@name=\"pinno\"]")).sendKeys("561101");
		driver.findElement(By.xpath("//input[@name=\"telephoneno\"]")).sendKeys("9996999998");
		driver.findElement(By.xpath("//input[@name=\"emailid\"]")).sendKeys(rand+"772@gmail.com");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        Alert ale = driver.switchTo().alert();
        String txt = ale.getText();
        if(txt.equals(txt)) {
        	System.out.println("Alert is accepted");
            ale.accept();

        }
        else {
        	System.out.println("Alert not accepted");
        }
		Thread.sleep(6000);
	}
	
}
