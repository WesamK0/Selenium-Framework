package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToCartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductCheckoutPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class RegisteredUserCanCheckoutProducTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	AddProductToCartPage cartObject;
	ProductCheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	String firstName = "Wesam";
	String lastName = "Kassem";
	String email = "test38@test.com";
	String password = "123123";
	
	@Test (priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully () {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.registerUser(firstName, lastName, email, password);
		Assert.assertTrue(registerObject.registerSuccess.getText().contains("Your registration completed"));
	}
	
	@Test (priority = 2)
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
	}
	
	@Test (priority = 5)
	public void registeredUserCanCheckoutProduct () throws InterruptedException
	{
		cartObject = new AddProductToCartPage(driver);
		cartObject.openCheckoutPage();
		checkoutObject = new ProductCheckoutPage(driver);
		checkoutObject.registeredUserCheckoutProduct("Egypt", "Cairo", "01089320321", "9 street,Maadi.", "11777", productName);
		Assert.assertTrue(checkoutObject.productNameBeforeConfirm.isDisplayed());
		Assert.assertTrue(checkoutObject.productNameBeforeConfirm.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.orderConfirmedSuccessMsg.getText().contains("Your order has been successfully processed!"));
		checkoutObject.openOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver);
		orderObject.downloadPDFInvoice();
		orderObject.printOrder();
	}
	
	@Test (priority = 6)
	public void userCanLogout () 
	{
		homeObject.userLogout();
	}
}
