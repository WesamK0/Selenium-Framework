package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "FullName")
	WebElement fullNameField;
	
	@FindBy (id = "Email")
	WebElement emailField;
	
	@FindBy (id = "Enquiry")
	WebElement enquiryField;
	
	@FindBy (css = "button.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy (css = "div.result")
	public WebElement successMsg;
	
	public void contactUs (String fullName, String email, String enquiry) 
	{
		sendTextElements(fullNameField, fullName);
		sendTextElements(emailField, email);
		sendTextElements(enquiryField, enquiry);
		clickButton(submitBtn);
		
	}

}
