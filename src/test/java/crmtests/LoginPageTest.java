package crmtests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmbase.TestBase;
import crmpages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage ;
	
@BeforeMethod
public void init()
{
	TestBase.initilization();
	loginPage = new LoginPage();
}
	
	@Test
	public void valditeLoginTest()
	{
		loginPage.login();
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
		
	}
	
	@Test
	public void validateLogoTest()
	{
		boolean status = loginPage.logoStatus();
		Assert.assertTrue(status);
	}
	@Test
	public void validateLinksTest()
	{
		boolean lnk = loginPage.signUplinkStatus();
		Assert.assertTrue(lnk);		
	}
	@Test
	public void validateForgotPasswordLinkRedirectionTest()
	{
		loginPage.clickOnForgotPasswordLink();
		String attVal = driver.findElement(By.xpath("//input[@value='Get Password']")).getAttribute("value");
		Assert.assertEquals(attVal, "Get Password");
	}
	
@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
