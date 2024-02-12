package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase{

	HomePage homeObject;
	
	@Test
	public void userCanSelectSubCategoryFromMainMenu () 
	{
		homeObject = new HomePage(driver);
		homeObject.openNoteBooksFromComputersMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
