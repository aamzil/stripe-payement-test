package tests;


import org.testng.annotations.Test;
import pages.OverviewPage;
import setup.Setup;
import org.testng.Assert;

public class OverviewTest extends Setup {
	
	@Test(priority = 1)
	public void addToCart () {
		OverviewPage overview = new OverviewPage(driver);
		overview.chooseSize();
		overview.chooseQuantity();
		overview.addToCartClick();
	    String message = overview.getMessage();
	    Assert.assertTrue(message.contains("Item added to the cart."), "Success: Item not added to cart");
	}
	
	@Test(priority = 2)
	public void addToCartFailed () {
		OverviewPage overview = new OverviewPage(driver);
		overview.chooseQuantity();
		overview.addToCartClick();
        String message = overview.getMessage();
        Assert.assertTrue(message.contains("Please select a size."), "Failed case: Item added to the cart");
	}
}
