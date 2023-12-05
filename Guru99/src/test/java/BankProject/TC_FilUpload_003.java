package BankProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BankingAppLoginPage;
import Utilities.BaseClass;
import Utilities.PropertyFile;
import Utilities.WebdriverUtility;

public class TC_FilUpload_003 extends BaseClass {
	
	@Test
	public void UpLoadFile() throws IOException, InterruptedException {
		WebdriverUtility web = new WebdriverUtility();
		BankingAppLoginPage Login = new BankingAppLoginPage(driver);
		PropertyFile p = new PropertyFile();
		String title = driver.getTitle();
		Assert.assertEquals(title, p.PropertyFile("BankHomePageTitle"));
        driver.findElement(By.xpath("(//a[contains(.,'Selenium')])[2]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//ul[@class=\"dropdown-menu\"])[1]//a[text()='File Upload']")).click();
		String projectPath = System.getProperty("user.dir");
        driver.findElement(By.xpath("//input[@class=\"upload_txt\"]")).sendKeys(projectPath+"\\Files\\TopSclData.xlsx");
        Thread.sleep(4000);
int a=1;
	}

}
