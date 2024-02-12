package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductsUsingAutoCompleteTest extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test
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
}