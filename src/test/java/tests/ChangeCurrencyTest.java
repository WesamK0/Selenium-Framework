package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test (priority = 1)
	public void userCanChangeCurrency () 
	{
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}
	
	
	@Test (priority = 2)
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
		Assert.assertTrue(detailsObject.productPrice.getText().contains("€"));
		System.out.println(detailsObject.productPrice.getText());
		
	}
}
