package Utilities;

import java.time.Duration;

import org.apache.logging.log4j.core.config.builder.api.PropertyComponentBuilder;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PageObject.BankingAppLoginPage;
import PageObject.TopScl_Page;
import io.opentelemetry.api.logs.Logger;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class BaseClass {
	public static String UsName="mngr541318";
	public static String Pwd="UqEmUqU";
	public static WebDriver driver;
	public static String browser="firefox";
	public static String Url="https://jerry.staging.topschool.co.i/";
			//"https://portal.zinghr.com/2015/pages/authentication/zing.aspx?ccode=testyantra";
			//"https://jerry.staging.topschool.co.i/";

	@BeforeClass
	public void setup() {
		switch (browser) {
		case "chrome" : driver=new ChromeDriver();	
			break;
			
		case "firefox" : FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
			driver=new FirefoxDriver();	
			break;
			
			case "ie":driver=new InternetExplorerDriver();
		}
		
	}
	
	@BeforeMethod
	public void App_Login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        if(Url.equalsIgnoreCase("https://portal.zinghr.com/2015/pages/authentication/zing.aspx?ccode=testyantra")) {
        	driver.get(Url);
        }
        else{
        	driver.get("https://demo.guru99.com/V1/index.php");
        }
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
    
}
