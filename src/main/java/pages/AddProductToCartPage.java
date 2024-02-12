package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToCartPage extends PageBase{

	public AddProductToCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (css = "a.product-name")
	public WebElement productNameInCart;

	@FindBy (css = "button.remove-btn")
	WebElement removeProductFromCartBtn;

	@FindBy (css = "span.product-subtotal")
	public WebElement productTotalPriceInCart;

	@FindBy (css = "input.qty-input")
	WebElement productQuantity;

	@FindBy (id = "updatecart")
	WebElement updateCartBtn;

	@FindBy (css = "div.no-data")
	public WebElement shoppingCartEmpyMsg;
	
	@FindBy (id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy (id = "termsofservice")
	WebElement agreeCheckBox;

	public void updateShoppingCart (String quantity)
	{
		clearField(productQuantity);
		sendTextElements(productQuantity, quantity);
		clickButton(updateCartBtn);
	}

	public void removeProductsfromCart () 
	{
		clickButton(removeProductFromCartBtn);
	}
	
	public void openCheckoutPage () 
	{
		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
	}

}
