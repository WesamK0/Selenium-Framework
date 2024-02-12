package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJSON extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@Test (priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully () throws FileNotFoundException, IOException, ParseException {
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.jsonReader();
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.registerUser(jsonReader.firstName, jsonReader.lastName, jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.registerSuccess.getText().contains("Your registration completed"));
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.loginUser(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.logoutLink.click();
	}

}
