package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailFriendPage emailFriendObj;
	
	
	String firstName = "Wesam";
	String lastName = "Kassem";
	String email = "test2@test.com";
	String password = "123123";
	String friendEmail = "friend@test.com";
	String productName = "Apple MacBook Pro 13-inch";
	String personalMsg = "Hi MF, check this out!";
	
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
	public void userCanSendProductToFriend () 
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.openEmailFriend();
		emailFriendObj = new EmailFriendPage(driver);
		emailFriendObj.sendEmail(friendEmail,personalMsg);
		Assert.assertEquals(emailFriendObj.emailFriendSuccessMsg.getText(), "Your message has been sent.");
	}
	
	@Test (priority = 5)
	public void userCanLogout () 
	{
		homeObject.userLogout();
	}
	
}
