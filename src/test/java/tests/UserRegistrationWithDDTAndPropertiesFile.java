package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	String fName = LoadProperties.userData.getProperty("firstName");
	String lName = LoadProperties.userData.getProperty("lastName");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");
	
	@Test (priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully () {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.registerUser(fName, lName, email, password);
		Assert.assertTrue(registerObject.registerSuccess.getText().contains("Your registration completed"));
	}
	
	@Test (dependsOnMethods = "userCanRegisterSuccessfully")
	public void registeredUserCanLogin () 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.loginUser(email,password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
}
