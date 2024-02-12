package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToCartPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCartTest extends TestBase{

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductToCartPage cartObject;

	String productName = "Apple MacBook Pro 13-inch";
	String quantity = "4";

	@Test (priority = 1)
	public void userCanSearchUsingAutoComplete () 
	{
		searchObject = new SearchPage(driver);
		try {
			searchObject.searchProductsUsingAutoComplete("mac");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameInBreadcrumb.getText(), productName);

	}

	@Test (priority = 2)
	public void userCanAddProductToCart () throws InterruptedException 
	{
		detailsObject = new ProductDetailsPage(driver);
		try {
			detailsObject.addToCart();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cartObject = new AddProductToCartPage(driver);
		Assert.assertEquals(cartObject.productNameInCart.getText(), productName);
		cartObject.updateShoppingCart(quantity);
		Assert.assertEquals(cartObject.productTotalPriceInCart.getText(), "$7,200.00");
	}

	@Test (priority = 3)
	public void userCanRemoveProductFromCart () 
	{
		cartObject.removeProductsfromCart();
		Assert.assertEquals(cartObject.shoppingCartEmpyMsg.getText(), "Your Shopping Cart is empty!");
	}
}
