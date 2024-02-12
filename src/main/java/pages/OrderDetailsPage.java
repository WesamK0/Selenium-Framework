package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css = "a.button-2.print-order-button")
	WebElement printOrderBtn;
	
	@FindBy (css = "a.button-2.pdf-invoice-button")
	WebElement pdfInvoiceBtn;
	
	public void printOrder () 
	{
		clickButton(printOrderBtn);
	}
	
	public void downloadPDFInvoice () throws InterruptedException 
	{
		clickButton(pdfInvoiceBtn);
		Thread.sleep(4000);
	}

}
