package crmtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crmbase.TestBase;
import crmpages.HomePage;
import crmpages.LoginPage;
import crmpages.NewContactsPage;
import crmutil.ReadTestData;
import crmutil.Utility;

public class NewContactsPageTest extends TestBase
{
	HomePage homePage;
	NewContactsPage contactPage;

	@BeforeMethod
	public void init()
	{
		TestBase.initilization();
		LoginPage loginPage = new LoginPage();
		homePage = loginPage.login();
		contactPage = homePage.createNewContact();
	}
	
	
	@DataProvider(name = "contactData")
	public String [][] passData()
	{
		return ReadTestData.getData();
	}
		
	@Test (dataProvider = "contactData")
	public void valdiateCreateNewContactTest1(String title, String fn, String ln,String mobile, String email, String address)
	{
		contactPage.newContact(title,fn,ln,mobile,email,address);
		WebElement createdAt = driver.findElement(By.xpath("//*[text()='Created at']"));
		Utility.explicitWait(50, createdAt);
		String actualTxt = createdAt.getText();
		Assert.assertEquals(actualTxt, "Created at");
		driver.switchTo().defaultContent();
		homePage.logout();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	
}
