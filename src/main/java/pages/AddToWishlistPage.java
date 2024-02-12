package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToWishlistPage extends PageBase{

	public AddToWishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css = "a.product-name")
	public WebElement wishlistedProductName;
	
	@FindBy (css = "button.remove-btn")
	WebElement removeProductFromWishlistBtn;
	
	@FindBy (css = "h1")
	public WebElement wishlistHeader;
	
	@FindBy (css = "div.no-data")
	public WebElement wishlistEmptyMsg;
	
	public void removeProductFromWishlist () 
	{
		clickButton(removeProductFromWishlistBtn);
	}

}
