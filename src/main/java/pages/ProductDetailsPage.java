package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (css = "strong.current-item")
	public WebElement productNameInBreadcrumb;
	
	@FindBy (css = "button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy (id = "price-value-4")
	public WebElement productPrice;
	
	public void openEmailFriend () 
	{
		clickButton(emailFriendBtn);
	}
	
	@FindBy (linkText = "Add your review")
	WebElement addReviewLink;
	
	public void openAddReview () 
	{
		clickButton(addReviewLink);
	}
	
	@FindBy (linkText = "wishlist")
	WebElement wishlistLink;
	
	@FindBy (id = "add-to-wishlist-button-4")
	WebElement addToWishlistBtn;
	
	public void addProductToWishlist () throws InterruptedException 
	{
		clickButton(addToWishlistBtn);
		Thread.sleep(1500);
		clickButton(wishlistLink);
	}
	
	@FindBy (css = "button.button-2.add-to-compare-list-button")
	WebElement addToComparebtn;
	
	@FindBy (linkText = "product comparison")
	WebElement productComparisonLink;
	
	public void addProductToCompareList () 
	{
		clickButton(addToComparebtn);
	}
	
	public void openProductsComparison () throws InterruptedException 
	{
		Thread.sleep(1000);
		clickButton(productComparisonLink);
	}
	
	@FindBy (id = "add-to-cart-button-4")
	WebElement addToCartBtn;
	
	@FindBy (linkText = "shopping cart")
	WebElement shoppingCartLink;
	
	public void addToCart () throws InterruptedException 
	{
		clickButton(addToCartBtn);
		Thread.sleep(1000);
		clickButton(shoppingCartLink);
	}
}
