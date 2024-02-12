package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndDataProviders extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider (name = "testData")
	public static Object [][] userData () 
	{
		return new Object [][] {{"Wesam", "Kassem","test2@test.net","123123"},
			{"Hamed", "Ahmed","test1@tut.com","123456"}};
	}
	
	
	
	@Test (priority = 1, alwaysRun = true, dataProvider = "testData")
	public void userCanRegisterSuccessfully (String fName, String lName, String email, String password) {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.registerUser(fName, lName, email, password);
		Assert.assertTrue(registerObject.registerSuccess.getText().contains("Your registration completed"));
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.loginUser(email, password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.logoutLink.click();
	}
	
}
