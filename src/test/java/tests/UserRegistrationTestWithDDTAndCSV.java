package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndCSV extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	CSVReader reader;

	@Test (priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully () throws IOException {
		String CSV_file = System.getProperty("user.dir") + "/src/test/java/data/userData.csv";
		reader = new CSVReader(new FileReader(CSV_file));

		String[] csvCell;
		while ((csvCell = reader.readNext()) != null) 
		{
			String fName = csvCell [0];
			String lName = csvCell [1];
			String email = csvCell [2];
			String password = csvCell [3];

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
}
