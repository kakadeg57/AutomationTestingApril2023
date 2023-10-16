package crmutil;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import crmbase.TestBase;

public class Utility extends TestBase
{
	public static void switchToMainPanelFrame() 
	{	
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static void mouseHover(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();	
	}
	
	

	public static void selectDropdownByVisibleText(WebElement element,String txt)
	{
		Select sel = new Select(element);	
		sel.selectByVisibleText(txt);
	}
	
	public static void explicitWait(int duration,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
}
