package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingAppLoginPage {
	// create webdriver object
	WebDriver Localdriver;
	
	//Create a constructor using class name
	 public BankingAppLoginPage(WebDriver Remotedriver) {
		//initiate the local driver
		 //Specify the pagefactory class
		 Localdriver=Remotedriver;
		 PageFactory.initElements(Remotedriver, this);
	}
       
	 @FindBy(xpath = "//input[@name=\"uid\"]")
	 private  WebElement UserID;
	 @FindBy(xpath = "//input[@name=\"password\"]")
	 private  WebElement Password;
	 @FindBy(xpath = "//input[@name=\"btnLogin\"]")
	 private  WebElement LoginBtn;
	 
	 public void SetUserName(String UsName) {
		 UserID.sendKeys(UsName);
	 }
	 public void SetUserPWD(String PWD) {
		 Password.sendKeys( PWD);
	 }
	 public void LoginBtn() {
		 LoginBtn.click();
	 }
	 
	 public void AdminLogin(String User_Name,String Pwd) {
		 this.UserID.sendKeys(User_Name);
		 this.Password.sendKeys(Pwd);
		 this.LoginBtn.click();
	 }
	 
}
