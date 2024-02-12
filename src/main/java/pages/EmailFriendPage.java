package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "FriendEmail")
	WebElement friendEmailField;
	
	@FindBy (id = "PersonalMessage")
	WebElement personalMsgField;
	
	@FindBy (css = "button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	
	@FindBy (css = "div.result")
	public WebElement emailFriendSuccessMsg;
	
	public void sendEmail (String friendEmail, String personalMessage)
	{
		sendTextElements(friendEmailField, friendEmail);
		sendTextElements(personalMsgField, personalMessage);
		clickButton(sendEmailBtn);
	}

}
