package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	
	
	@Test (priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully () {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.registerUser(firstName, lastName, email, password);
		System.out.println("The user data is: " + firstName + " " + lastName + " " + email + " " + password);
		Assert.assertTrue(registerObject.registerSuccess.getText().contains("Your registration completed"));
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.loginUser(email, password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.logoutLink.click();
	}
	
}
