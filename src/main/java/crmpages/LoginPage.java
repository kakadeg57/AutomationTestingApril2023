package crmpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmbase.TestBase;

public class LoginPage extends TestBase
{
	// page factory init elements method
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElement repository 
		
			//username text box	
			//driver.findElement(By.xpath("demo")).sendKeys("Speedway2023");
			@FindBy(name ="username")
			WebElement usernameTxtBox;
			
			// password text box
			@FindBy(name = "password")
			WebElement passwordTxtBox;
			// login button
			@FindBy (xpath = "//input[@value='Login']")
			WebElement loginBtn;
	
			@FindBy (xpath = "/html/body/div[2]/div/div[1]/a/img")
			WebElement logoImg;
			
			@FindBy (linkText = "Sign Up")
			WebElement signUpLink;
			
			@FindBy(linkText = "Pricing")
			WebElement pricingLink;
			
			@FindBy (linkText = "Features")
			WebElement featuresLink;
			
			@FindBy (linkText = "Forgot Password?")
			WebElement forgotPasswordLink;
			
	//Actions
			//login
	public HomePage login()
	{
		
		usernameTxtBox.sendKeys(prop.getProperty("username"));
		passwordTxtBox.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		return new HomePage();
		
	}
	
	public boolean  logoStatus()
	{
		return logoImg.isDisplayed();
	}
	
	public boolean signUplinkStatus()
	{
		boolean signupLinkStatus = signUpLink.isDisplayed();
		return signupLinkStatus;
	}
	
	public void clickOnForgotPasswordLink()
	{
		forgotPasswordLink.click();
	}


}
