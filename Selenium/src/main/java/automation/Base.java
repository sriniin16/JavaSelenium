package automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Base(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public String getSiteURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String getSiteTitle()
	{
		return driver.getTitle();
	}

	public boolean isElementDisplayed(By locator)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		if(element.isDisplayed())
		{
			return true;
		}else
			return false;		
	}
}
