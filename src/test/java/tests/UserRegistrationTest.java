package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test (priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully () {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.registerUser("Wesam", "Kassem", "nemodori501@gmail.com", "12345678");
		Assert.assertTrue(registerObject.registerSuccess.getText().contains("Your registration completed"));
	}
	
	@Test (dependsOnMethods = "userCanRegisterSuccessfully")
	public void registeredUserCanLogin () 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.loginUser("nemodori501@gmail.com", "12345678");
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
}
