package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id = "AddProductReview_Title")
	WebElement reviewTitleField;
	
	@FindBy (id = "AddProductReview_ReviewText")
	WebElement reviewTextField;
	
	@FindBy (id = "addproductrating_4")
	WebElement ratingRadioBtn;
	
	@FindBy (css = "button.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	@FindBy (css = "div.result")
	public WebElement addedReviewSuccessMsg;
	
	public void addProductReview (String reviewTitle, String reviewText) 
	{
		sendTextElements(reviewTitleField, reviewTitle);
		sendTextElements(reviewTextField, reviewText);
		clickButton(ratingRadioBtn);
		clickButton(submitReviewBtn);
	}
}
