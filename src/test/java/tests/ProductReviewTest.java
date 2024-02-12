package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductReviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class ProductReviewTest extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductReviewPage reviewObject;
	
	
	String firstName = "Wesam";
	String lastName = "Kassem";
	String email = "test5@test.com";
	String password = "123123";
	String reviewTitle = "Good Purchase";
	String productName = "Apple MacBook Pro 13-inch";
	String reviewText = "A great laptop, I recommend it";
	
	@Test (priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully () {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.registerUser(firstName, lastName, email, password);
		Assert.assertTrue(registerObject.registerSuccess.getText().contains("Your registration completed"));
	}
	
	@Test (priority = 2, dependsOnMethods = "userCanRegisterSuccessfully")
	public void registeredUserCanLogin () 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.loginUser(email, password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
	
	@Test (priority = 3)
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
	
	@Test (priority = 4)
	public void userCanAddProductReivew () 
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.openAddReview();
		reviewObject = new AddProductReviewPage(driver);
		reviewObject.addProductReview(reviewTitle, reviewText);
		Assert.assertEquals(reviewObject.addedReviewSuccessMsg.getText(),"Product review is successfully added.");
	}
	
	@Test (priority = 5)
	public void userCanLogout () 
	{
		homeObject.userLogout();
	}
}
