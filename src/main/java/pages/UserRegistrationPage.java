package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase
{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "gender-male")
	WebElement genderRdoBtn;
	
	@FindBy (id = "FirstName")
	WebElement firstNameTxtBox;
	
	@FindBy (id = "LastName")
	WebElement lastNameTxtBox;
	
	@FindBy (id = "Email")
	WebElement emailTxtBox;
	
	@FindBy (id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy (id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy (id = "register-button")
	WebElement registerBtn;
	
	@FindBy (css = "div.result")
	public WebElement registerSuccess;
	
	@FindBy (css = "a.ico-login")
	WebElement loginLink;
	
	@FindBy (css = "a.ico-logout")
	public WebElement logoutLink;
	
	public void registerUser (String firstName, String lastName, String email, String password) 
	{
		clickButton(genderRdoBtn);
		sendTextElements(firstNameTxtBox, firstName);
		sendTextElements(lastNameTxtBox, lastName);
		sendTextElements(emailTxtBox, email);
		sendTextElements(passwordTxtBox, password);
		sendTextElements(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}
	

}
