package crmtests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import crmbase.TestBase;
import crmpages.HomePage;
import crmpages.LoginPage;

public class HomePageTest extends TestBase
{
	int lp;
	LoginPage loginPage; // null 
	HomePage homePage; // null
	
	@BeforeMethod
	public void init()
	{
		TestBase.initilization();
		 loginPage = new LoginPage();// null pointer exception
		lp = 10;
		homePage = loginPage.login();
		System.out.println(lp);
	}
	

	
	@Test
	public void validateLogoutTest()
	{
		homePage.logout();
		Assert.assertTrue(loginPage.signUplinkStatus());
	}
	
	
	@Test
	public void validateRedirectionOfCreateNewCompanyLinkTest()
	{
		homePage.createNewCompany();
		String actualTxt = driver.findElement(By.xpath("//*[text()='Create New  Company']")).getText();
			Assert.assertEquals(actualTxt,"Create New Company");	
	}
	
	
	@Test
	public void validateRedirectionOfcreateNewContactLinkTest()
	{
		homePage.createNewContact();
		String actualTxt = driver.findElement(By.xpath("//*[text()='Contact Information']")).getText();
		Assert.assertEquals(actualTxt, "Contact Information");
	}

	
	
	@Test
	public void validateRedirectionOfCreateNewTaskLinkTest()
	{
		homePage.createNewTask();
		String actualTxt = driver.findElement(By.xpath("//*[text()='Task Information']")).getText();
		Assert.assertEquals(actualTxt, "Task Information");
	}
	
	
	@Test
	public void validateRedirectionOfCreateNewDealTest()
	{
		homePage.createNewDeal();
		String actualTxt = driver.findElement(By.xpath("//*[text()='Deal']")).getText();
		Assert.assertEquals(actualTxt, "Deal");
	}
	
	
	@Test
	public void valdiateHomePageTitleTest()
	{
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
