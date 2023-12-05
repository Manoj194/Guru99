package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class TopScl_Page {
	
	WebDriver driver;
	
	public TopScl_Page(WebDriver driver) {
		driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@name=\"userName\"]")
	private WebElement UserNameTxtFld;
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement PasswordTxtFld;
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	private WebElement CHeckBoxBtn;
	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement LoginBtn;
	
	public void TopSclAdminLogin(String Admin_US_NAME, String Admin_US_PWD) {
		this.UserNameTxtFld.click();
		this.UserNameTxtFld.sendKeys(Admin_US_NAME);
		this.PasswordTxtFld.click();
		this.PasswordTxtFld.sendKeys(Admin_US_PWD);
		this.CHeckBoxBtn.click();
		this.LoginBtn.click();
	}

}
