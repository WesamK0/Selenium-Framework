package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy (linkText = "Register")
	WebElement registerLink;
	
	public void openRegistrationPage () {
		clickButton(registerLink);
	}
	
	@FindBy (linkText = "Log in")
	WebElement loginLink;
	
	public void openLoginPage () {
		clickButton(loginLink);
	}
	
	@FindBy (css = "a.ico-account")
	public WebElement myAccountLink;
	
	public void openMyAccount () {
		clickButton(myAccountLink);
	}
	
	@FindBy (css = "a.ico-logout")
	WebElement logoutLink;
	
	public void userLogout () 
	{
		clickButton(logoutLink);
	}
	
	public void scrollToBottom () 
	{
		scrollToContactUs();
	}
	
	@FindBy (id = "customerCurrency")
	WebElement currencyDropDownList;
	
	public void changeCurrency () 
	{
		select = new Select(currencyDropDownList);
		select.selectByVisibleText("Euro");
	}
	
	@FindBy (linkText = "Computers") 
	WebElement computersMenuLink;
	
	@FindBy (xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement noteBooksOptionLink;
	
	public void openNoteBooksFromComputersMenu () 
	{
		action.moveToElement(computersMenuLink).moveToElement(noteBooksOptionLink).click().build().perform();
	}

}
