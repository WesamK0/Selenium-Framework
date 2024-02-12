package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy (id = "small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy (css = "button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy (id = "ui-id-1")
	List<WebElement> productsList;
	
	@FindBy (linkText = "Apple MacBook Pro 13-inch")
	WebElement productItemName;
	
	public void searchProducts (String productName)
	{
		sendTextElements(searchTxtBox, productName);
		clickButton(searchBtn);
	}
	
	public void openProductsDetailsPage () 
	{
		clickButton(productItemName);
	}
	
	public void searchProductsUsingAutoComplete (String searchTxt) throws InterruptedException 
	{
		sendTextElements(searchTxtBox, searchTxt);
		Thread.sleep(2000);
		productsList.get(0).click();
	}

}
