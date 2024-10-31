package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.GatewayPage;
import pages.OverviewPage;
import setup.Setup;
import utils.Utils;
import org.testng.Assert;


public class GatewayTest extends Setup {
    
    Utils utility = new Utils("Dataset.xlsx", "Sheet1");
    
    @Test(priority = 1)
    public void validPayment()  {
        GatewayPage gateway = new GatewayPage(driver);
        OverviewPage overview = new OverviewPage(driver);
        
        overview.chooseSize();
        overview.chooseQuantity();
        overview.addToCartClick();
        overview.cartBtnClick();
        overview.checkoutBtnClick();
        
        String email = utility.getData(1, 0);
        String cardNumber = utility.getData(1, 1);
        String expiration = utility.getData(1, 2);
        String cardCvc = utility.getData(1, 3);
        String fullname = utility.getData(1, 4);
        String country = utility.getData(1, 5);

        
        gateway.userEmail(email);
        gateway.userCardNumber(cardNumber);
        gateway.userCardExpiry(expiration);
        gateway.userCardCvc(cardCvc);
        gateway.userName(fullname);
        gateway.userBillingCountry(country);
        gateway.payButtonClick();
        
        
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        wait.until(ExpectedConditions.urlToBe("http://localhost:5174/success"));
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:5174/success"), "Payment was not successful; URL mismatch.");                
    }
    
    @Test(priority = 2)
    public void invalidPayment()  {
        GatewayPage gateway = new GatewayPage(driver);
        OverviewPage overview = new OverviewPage(driver);
        
        overview.chooseSize();
        overview.chooseQuantity();
        overview.addToCartClick();
        overview.cartBtnClick();
        overview.checkoutBtnClick();
        
        String email = utility.getData(2, 0);
        String cardNumber = utility.getData(2, 1);
        String expiration = utility.getData(2, 2);
        String cardCvc = utility.getData(2, 3);
        String fullname = utility.getData(2, 4);
        String country = utility.getData(2, 5);

        
        gateway.userEmail(email);
        gateway.userCardNumber(cardNumber);
        gateway.userCardExpiry(expiration);
        gateway.userCardCvc(cardCvc);
        gateway.userName(fullname);
        gateway.userBillingCountry(country);
        gateway.payButtonClick();
                
        gateway.cancelButtonClick();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        wait.until(ExpectedConditions.urlToBe("http://localhost:5174/cancel"));
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:5174/cancel"), "Payment passed successfully; URL matches.");                
    }
}