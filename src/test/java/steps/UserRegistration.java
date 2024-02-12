package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{
	
	 HomePage homeObj;
	 UserRegistrationPage registerObj;
	
	@Given("^The user in homepage$")
	public void the_user_in_homepage() {
	   homeObj = new HomePage(driver);
	   homeObj.openRegistrationPage();
	}

	@When("^I click on register link$")
	public void i_click_on_register_link() {
	   Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
 
	@When("^I entered the user data$")
	public void i_entered_the_user_data() {
	   registerObj = new UserRegistrationPage(driver);
	   registerObj.registerUser("Wesam", "Kassem", "wesam@test.com", "123123");
	}

	@Then("^The registration is completed successfully$")
	public void the_registration_is_completed_successfully() {
	   Assert.assertTrue(registerObj.registerSuccess.isDisplayed());
	}
}