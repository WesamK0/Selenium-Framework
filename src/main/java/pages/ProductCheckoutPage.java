package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductCheckoutPage extends PageBase{

	public ProductCheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "BillingNewAddress_FirstName")
	WebElement billingFirstName;
	
	@FindBy (id = "BillingNewAddress_LastName")
	WebElement billingLastName;
	
	@FindBy (id = "BillingNewAddress_Email")
	WebElement billingEmail;
	
	@FindBy (id = "BillingNewAddress_CountryId")
	WebElement billingCountryDropDownList;
	
	@FindBy (id = "BillingNewAddress_City")
	WebElement billingCity;
	
	@FindBy (id = "BillingNewAddress_Address1")
	WebElement billingAddress;
	
	@FindBy (id = "BillingNewAddress_ZipPostalCode")
	WebElement billingZipCode;
	
	@FindBy (id = "BillingNewAddress_PhoneNumber")
	WebElement billingPhoneNumber;
	
	@FindBy (css = "button.button-1.new-address-next-step-button")
	WebElement continue1Btn;
	
	@FindBy (css = "button.button-1.shipping-method-next-step-button")
	WebElement continue2Btn;
	
	@FindBy (css = "button.button-1.payment-method-next-step-button")
	WebElement continue3Btn;
	
	@FindBy (css = "button.button-1.payment-info-next-step-button")
	WebElement continue4Btn;
	
	@FindBy (xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a")
	public WebElement productNameBeforeConfirm;
	
	@FindBy (css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmOrderBtn;
	
	@FindBy (css = "div.title")
	public WebElement orderConfirmedSuccessMsg;
	
	@FindBy (linkText = "Click here for order details.")
	WebElement orderDetailsLink;
	
	@FindBy (css = "button.button-1.checkout-as-guest-button")
	WebElement guestCheckoutBtn;
	
	public void registeredUserCheckoutProduct (String countryName, String cityName, String phone, 
			String address, String zipCode, String productName) throws InterruptedException 
	{
		Thread.sleep(2000);
		select = new Select(billingCountryDropDownList);
		select.selectByVisibleText(countryName);
		sendTextElements(billingCity, cityName);
		sendTextElements(billingAddress, address);
		sendTextElements(billingZipCode, zipCode);
		sendTextElements(billingPhoneNumber, phone);
		clickButton(continue1Btn);
		Thread.sleep(1000);
		clickButton(continue2Btn);
		Thread.sleep(1000);
		clickButton(continue3Btn);
		Thread.sleep(1000);
		clickButton(continue4Btn);
		Thread.sleep(2000);
	}
	
	public void confirmOrder () throws InterruptedException 
	{
		
		clickButton(confirmOrderBtn);
		Thread.sleep(1500);
	}
	
	public void openOrderDetails () 
	{
		clickButton(orderDetailsLink);
	}
	
	public void guestCheckoutProduct (String firstName, String lastName, String email, String countryName, String cityName, String phone, 
			String address, String zipCode, String productName) throws InterruptedException 
	{
		Thread.sleep(2000);
		sendTextElements(billingFirstName, firstName);
		sendTextElements(billingLastName, lastName);
		sendTextElements(billingEmail, email);
		select = new Select(billingCountryDropDownList);
		select.selectByVisibleText(countryName);
		sendTextElements(billingCity, cityName);
		sendTextElements(billingAddress, address);
		sendTextElements(billingZipCode, zipCode);
		sendTextElements(billingPhoneNumber, phone);
		clickButton(continue1Btn);
		Thread.sleep(1000);
		clickButton(continue2Btn);
		Thread.sleep(1000);
		clickButton(continue3Btn);
		Thread.sleep(1000);
		clickButton(continue4Btn);
		Thread.sleep(2000);
	}
	
	public void checkoutAsGuest () 
	{
		clickButton(guestCheckoutBtn);
	}

}
