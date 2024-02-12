package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "OldPassword")
	WebElement oldPasswordTxtBox;
	
	@FindBy (id = "NewPassword")
	WebElement newPasswordTxtBox;
	
	@FindBy (id = "ConfirmNewPassword")
	WebElement confirmNewPasswordTxtBox;
	
	@FindBy (css = "button.button-1.change-password-button")
	WebElement changePasswordButton;
	
	@FindBy (linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy (css = "p.content")
	public WebElement passwordChangedSuccessMsg;
	
	@FindBy (css = "span.close")
	public WebElement successMsgCloseBtn;
	
	public void openChangePasswordLink () 
	{
		clickButton(changePasswordLink);
	}
	
	public void changePassword (String oldPassword, String newPassword) 
	{
		sendTextElements(oldPasswordTxtBox, oldPassword);
		sendTextElements(newPasswordTxtBox, newPassword);
		sendTextElements(confirmNewPasswordTxtBox, newPassword);
		clickButton(changePasswordButton);
	}

}
