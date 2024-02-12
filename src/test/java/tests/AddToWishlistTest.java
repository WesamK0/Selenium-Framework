package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToWishlistPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToWishlistTest extends TestBase{
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddToWishlistPage wishlistObject;
	String productName = "Apple MacBook Pro 13-inch";
	
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
	public void userCanAddProductToWishlist () throws InterruptedException 
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProductToWishlist();
		Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));
		wishlistObject = new AddToWishlistPage(driver);
		Assert.assertTrue(wishlistObject.wishlistHeader.getText().contains("Wishlist"));
		Assert.assertTrue(wishlistObject.wishlistedProductName.getText().equalsIgnoreCase(productName));
	}
	
	@Test (priority = 3)
	public void userCanRemoveProductFromWishlist () 
	{
		wishlistObject = new AddToWishlistPage(driver);
		wishlistObject.removeProductFromWishlist();
		Assert.assertEquals(wishlistObject.wishlistEmptyMsg.getText(), "The wishlist is empty!");
	}
}
