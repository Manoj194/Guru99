package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	WebDriver Ldriver;
	public NewCustomerPage(WebDriver Rdriver) {
		Ldriver=Rdriver;
		PageFactory.initElements(Rdriver, this);
	}
	
	@FindBy(xpath = "//a[text()='New Customer']")
	private WebElement NewCustLink;
	@FindBy(xpath = "//input[@onkeyup=\"validatecustomername();\"]")
	private WebElement CustnameTxtFld;
	
	public void NewCustomer_Tab() {
		NewCustLink.click();
	}
	public void Cust_name_TxtField(String UserName) {
		CustnameTxtFld.click();
		CustnameTxtFld.sendKeys(UserName);
	}


}
