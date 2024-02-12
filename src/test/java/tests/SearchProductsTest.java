package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductsTest extends TestBase{

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test
	public void userCanSearchForProducts () throws InterruptedException 
	{
		searchObject = new SearchPage(driver);
		searchObject.searchProducts(productName);
		searchObject.openProductsDetailsPage();
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNameInBreadcrumb.getText().equalsIgnoreCase(productName));
		//Or ...
		//Assert.assertEquals(detailsObject.productNameInBreadcrumb.getText(), productName);
	}
}
