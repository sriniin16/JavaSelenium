package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProductPage extends Base  {
	
	public WebDriver driver;
	
	public By searchBox = By.xpath("//input[@id='search_query_top']");
	public By searchButton = By.xpath("//button[@name='submit_search']");
	public By searchProductGrid = By.xpath("//ul[@class='product_list grid row']");
	public By multiColorItem = By.xpath("(//ul[@class='product_list grid row']//ul[@class='color_to_pick_list clearfix'])[1]");
	public By firstItem = By.xpath("(//ul[@class='product_list grid row']//div[@class='product-image-container'])[1]");
	public By shortDescription = By.xpath("//div[@id='short_description_block']");
	public By quantityWanted = By.xpath("//input[@id='quantity_wanted']");
	public By addtoCartButton = By.xpath("//span[contains(text(),'Add to cart')]");
	public By cartPopUp = By.xpath("//div[@id='layer_cart']");
	public By popUpClose = By.xpath("//div[@id='layer_cart']//span[@class='cross']");
	public By viewCart = By.xpath("//div[@class='shopping_cart']//a[@title='View my shopping cart']");
	public By summaryText = By.xpath("//h1[contains(text(),'summary')]");
	public By productRow = By.xpath("//tr[contains(@id,'product')]");	
	public By continueShopping = By.xpath("//a[@title='Continue shopping']");
	public By quantitySummary = By.xpath("//tr[1]//input[@class='cart_quantity_input form-control grey']");
	public By deleteItem = By.xpath("//tr[last()]//div/a[@title='Delete']");
	
	public String chooseColorLocator = "//ul[@id='color_to_pick_list']//a[@name='HelloWorld']";
	

	public SearchProductPage(WebDriver driver) {
		super(driver); 
		this.driver = driver;				
	}
	
	public void searchProductInSearchBox(String productType)
	{
		WebElement searchbar = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		searchbar.sendKeys(productType);
		driver.findElement(searchButton).click();
	}
	
	public boolean searchProductDisplayed()
	{
		return isElementDisplayed(searchProductGrid);
	}
	
	public boolean verifyMultiColorItem()
	{
		return isElementDisplayed(multiColorItem);
	}
	
	public void selectItem()
	{
		driver.findElement(firstItem).click();
	}
	
	public boolean verifyProductDescriptionPage()
	{
		return isElementDisplayed(shortDescription);
	}
	
	public void chooseColorAndQuantity(String color)
	{
		String replacedLocator = chooseColorLocator.replace("HelloWorld", color);
		By chooseColor = By.xpath(replacedLocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(chooseColor));
		driver.findElement(chooseColor).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(quantityWanted));
		driver.findElement(quantityWanted).sendKeys("2");
	}
	
	public void addMoreItem(String color)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping));
		driver.findElement(continueShopping).click();
		String replacedLocator = chooseColorLocator.replace("HelloWorld", color);
		By chooseColor = By.xpath(replacedLocator);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(chooseColor));
		driver.findElement(chooseColor).click();
		addToCart();
	}
	
	public void addToCart()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtoCartButton));
		driver.findElement(addtoCartButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartPopUp));
		driver.findElement(popUpClose).click();
	}
	
	public boolean verifySummaryPage()
	{
		wait.until(ExpectedConditions.elementToBeClickable(viewCart));
		driver.findElement(viewCart).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(summaryText));
		return isElementDisplayed(productRow);
	}
	
	public void updateQuantityInSummaryPage()
	{
		verifySummaryPage();
		driver.findElement(quantitySummary).clear();
		driver.findElement(quantitySummary).sendKeys("1");
	}
	
	public void removeItemInSummaryPage()
	{
		driver.findElement(deleteItem).click();
	}
	
	public boolean verifyProductInCart()
	{
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(productRow));
		List<WebElement>  elements = driver.findElements(productRow);
		System.out.println("total: "+ elements.size());
		if(elements.size()==1)
		{
			return true;
		}else
			return false;
	}
}
