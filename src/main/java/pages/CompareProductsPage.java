package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase{

	public CompareProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (css = "a.clear-list")
	WebElement clearListBtn;

	@FindBy (css = "table.compare-products-table")
	WebElement compareProductsTable;

	@FindBy (tagName = "td")
	List<WebElement> cells;

	@FindBy (tagName = "tr")
	List<WebElement> allRows;

	@FindBy (linkText = "Asus N551JK-XO076H Laptop")
	public WebElement firstProductName;

	@FindBy (linkText = "Apple MacBook Pro 13-inch")
	public WebElement secondProductName;

	@FindBy (css = "div.no-data")
	public WebElement clearedProductsListSuccessMsg;

	public void clearComparisonList () 
	{
		clickButton(clearListBtn);
	}

	public void compareProducts () 
	{
		System.out.println(allRows.size());

		for (WebElement row : allRows) {
			System.out.println(row.getText()); //useless line

			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}
	}

}
