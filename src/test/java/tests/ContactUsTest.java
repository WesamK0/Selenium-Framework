package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

	HomePage homeObject;
	ContactUsPage contactUsObject;
	
	String name = "Wesam Kassem Ahmed";
	String email = "test@test.com";
	String enquiry = "Hello, this is Wesam .. I hope you have got my complaint";
	
	@Test 
	public void userCanContactUs () 
	{
		homeObject = new HomePage(driver);
		homeObject.scrollToBottom();
		contactUsObject = new ContactUsPage(driver);
		contactUsObject.contactUs(name, email, enquiry);
		Assert.assertEquals(contactUsObject.successMsg.getText(), "Your enquiry has been successfully sent to the store owner.");
	}
}