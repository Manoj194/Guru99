package BankProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BankingAppLoginPage;
import PageObject.NewCustomerPage;
import Utilities.BaseClass;
import Utilities.ExcelUtility;
import Utilities.PropertyFile;

public class Get_data_from_excel extends BaseClass {
	
	@Test(groups = { "reg"})
	public void Fetch_Required_Data_From_Excel() throws IOException, InterruptedException {
		ExcelUtility excel = new ExcelUtility();
		BankingAppLoginPage Login = new BankingAppLoginPage(driver);
		NewCustomerPage Cust = new NewCustomerPage(driver);
		PropertyFile p = new PropertyFile();
		String title = driver.getTitle();
		Assert.assertEquals(title, p.PropertyFile("BankHomePageTitle"));
		FileInputStream fis = new FileInputStream("C://EclipseIDE//Guru99//Files//TopSclData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("LogData");
		Row r = sh.getRow(0);
		Cell c = r.getCell(1);
		Row r1 = sh.getRow(1);
		Cell c1 = r1.getCell(1);
		String UserName = c.getStringCellValue();
		String Password = c1.getStringCellValue();
		Login.SetUserName(UserName);
		Login.SetUserPWD(Password);
		Login.LoginBtn();
		Thread.sleep(1000);
	}

}
