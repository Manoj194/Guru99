package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mongodb.MapReduceCommand.OutputType;

public class WebdriverUtility {
	
WebDriver driver;
	
	// This method is used to maximize the browser
	public void maximizeBrowser() {
		driver.manage().window().maximize();
		
	}
	
	 // This method is used to wait till the browser page is loaded completely
	public void WaitTillLoad( long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	
	//This method is used to navigate to the application using given url
	public void navigateToApplication( String url) {
		driver.get(url);
	}
	
	 // This method is used to open the browser and the application
	public WebDriver openBrowserAndApplication(String browser,long longTimeout,String url) {
		//launchBrowser(browser);
		maximizeBrowser();
		WaitTillLoad(longTimeout);
		navigateToApplication( url);		
		return driver;
	}
	
	 //* This method is used to handle drop down by text
	public void dropdownByText(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByVisibleText(value);
	}
	
	// * This method is used to handle drop down by value
	public void dropdownByValue(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByValue(value);
	}
	
	 //* This method is used to handle drop down by index
	public void dropdownByIndex(WebElement element, int value) {
		Select dd = new Select(element);
		dd.selectByIndex(value);
	}
	
	// * This method is used to wait till the element is available for clicking action
	public void explicitWait(WebElement element, long timeouts) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to perform mouse hovering to given element
	 * @param element
	 */
	public void moveToElementAction(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	 //* This method is used to convert dynamic xpath into Web Element
	public WebElement convertDynamicXpathIntoWebElement(String dynamicPath, String replaceData) {
		String requiredPath = String.format(dynamicPath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredPath));
		return element;
	}
	
	/**
	 * This method is used to close the browser
	 */
	public void closeDriver() {
		driver.quit();
	}
	
	// Method is used to Perform ScrollIntoView
	public void ScrollIntoView(WebDriver driver,WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("arguments[0].scrollIntoView()", ele);
		} catch (Exception e) {
			System.out.println("scrollIntoView is not Not working");
			throw e;
		}
       
	}
	
	// Action class for Handle MOuseHover
	public void MouceHover(WebDriver driver,WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	

}
