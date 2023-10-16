package crmpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmbase.TestBase;
import crmutil.Utility;

public class HomePage extends TestBase
{
	
	// page factory init elements method
	public HomePage()
	{
		PageFactory.initElements(TestBase.driver, this);
	}
	
	
	// webelement repository
	
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a")
	
	WebElement logoutBtn;
	
	
	@FindBy (xpath = "//*[text()='Companies']")
	WebElement companies;
	@FindBy (xpath = "//*[text()='New Company']")
	WebElement newCompany;
	
	@FindBy (xpath = "//*[text()='Contacts']")
	WebElement contacts;
	@FindBy(xpath = "//*[text()='New Contact']")
	WebElement newContact;
	
	@FindBy (xpath = "//*[text()='Deals']")
	WebElement deal;
	@FindBy (xpath = "//*[text()='New Deal']")
	WebElement newDeal;
	
	@FindBy (xpath = "//*[text()='Tasks']")
	WebElement task;
	@FindBy (xpath = "//*[text()='New Task']")
	WebElement newTask;
	
	// actions
	public void logout()
	{
		Utility.switchToMainPanelFrame();
		logoutBtn.click();
	}
	
	
	public void createNewCompany()
	{
		Utility.switchToMainPanelFrame();;
		Utility.mouseHover(companies);
		newCompany.click();
	}
	
	public NewContactsPage createNewContact()
	{
		Utility.switchToMainPanelFrame();
		Utility.mouseHover(contacts);
		newContact.click();
		return new NewContactsPage();
	}
	
	public void createNewDeal()
	{
		Utility.switchToMainPanelFrame();
		Utility.mouseHover(deal);
		newDeal.click();
	}
	public void createNewTask()
	{
		Utility.switchToMainPanelFrame();
		Utility.mouseHover(task);
		newTask.click();
	}

}
