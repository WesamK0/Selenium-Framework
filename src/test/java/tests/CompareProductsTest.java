package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProductsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CompareProductsTest extends TestBase{

	HomePage homeObject;
	ProductDetailsPage detailsObject;
	CompareProductsPage compareObject;
	SearchPage searchObject;
	
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	
	@Test (priority = 1)
	public void userCanCompareProducts () throws InterruptedException 
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.searchProductsUsingAutoComplete("macb");
		Assert.assertEquals(detailsObject.productNameInBreadcrumb.getText(), firstProductName);
		detailsObject.addProductToCompareList();
		searchObject.searchProductsUsingAutoComplete("asus");
		Assert.assertEquals(detailsObject.productNameInBreadcrumb.getText(), secondProductName);
		detailsObject.addProductToCompareList();
		detailsObject.openProductsComparison();
		compareObject = new CompareProductsPage(driver);
		compareObject.compareProducts();
		Assert.assertEquals(compareObject.firstProductName.getText(), "Asus N551JK-XO076H Laptop");
		Assert.assertEquals(compareObject.secondProductName.getText(), "Apple MacBook Pro 13-inch");
	}
	
	@Test (priority = 2)
	public void userCanClearComparisonList () 
	{
		compareObject = new CompareProductsPage(driver);
		compareObject.clearComparisonList();
		Assert.assertEquals(compareObject.clearedProductsListSuccessMsg.getText(), "You have no items to compare.");
	}
}
