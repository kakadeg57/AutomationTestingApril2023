package crmpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crmbase.TestBase;
import crmutil.Utility;

public class NewContactsPage extends TestBase
{
	// page factory to initilize webelements
	public NewContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// webelements repository
	
	@FindBy (name = "title")
	WebElement titleEle;
	
	@FindBy (id = "first_name")
	WebElement firstNameTxt; 
	@FindBy (id = "surname")
	WebElement lastNameTxt;
	@FindBy (id = "mobile")
	WebElement mobileNrTxt;
	@FindBy (id ="email")
	WebElement emailTxt;
	@FindBy (name = "address")
	WebElement addressTxt;
	@FindBy (xpath = "/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	// actions
	public void newContact(String title, String firstName, String lastName, String mobileNumber, String emailId,String add)
	{
		Utility.selectDropdownByVisibleText(titleEle, title);
		firstNameTxt.sendKeys(firstName);
		lastNameTxt.sendKeys(lastName);
		mobileNrTxt.sendKeys(mobileNumber);
		emailTxt.sendKeys(emailId);
		addressTxt.sendKeys(add);
		saveBtn.click();
	}
//	public void newContact2()
//	{
//		Utility.selectDropdownByVisibleText(title, "Mr.");
//		firstNameTxt.sendKeys("Pravin");
//		lastNameTxt.sendKeys("Kumar");
//		mobileNrTxt.sendKeys("9900121212");
//		emailTxt.sendKeys("pravin.kumar@tesla.com");
//		addressTxt.sendKeys("1st silver oak street, Newyork");
//		saveBtn.click();
//	}
	
}
