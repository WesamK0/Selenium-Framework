package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithExcelFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider (name = "ExcelData")
	public Object [][] userRegisterData () throws IOException
	{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	
	@Test (priority = 1, dataProvider = "ExcelData")
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
