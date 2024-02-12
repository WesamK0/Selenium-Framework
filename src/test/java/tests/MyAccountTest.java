package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
	String firstName = "Wesam";
	String lastName = "Kassem";
	String email = "nemodori539@gmail.com";
	String oldPassword = "12345678";
	String newPassword = "123123";
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	
	@Test (priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully () {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.registerUser(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.registerSuccess.getText().contains("Your registration completed"));
	}
	
	@Test (dependsOnMethods = "userCanRegisterSuccessfully")
	public void registeredUserCanLogin () 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.loginUser(email, oldPassword);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
	
	@Test (dependsOnMethods = "registeredUserCanLogin")
	public void registeredUserCanChangePassword () throws InterruptedException 
	{
		myAccountObject = new MyAccountPage(driver);
		homeObject.openMyAccount();
		myAccountObject.openChangePasswordLink();
		myAccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.passwordChangedSuccessMsg.getText().contains("Password was changed"));
		myAccountObject.successMsgCloseBtn.click();
		Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods = "registeredUserCanChangePassword")
	public void userCanLogout () 
	{
		homeObject.userLogout();
	}
	
	@Test (dependsOnMethods = "userCanLogout")
	public void registeredUserCanLoginWithNewPassword () 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.loginUser(email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}

}
