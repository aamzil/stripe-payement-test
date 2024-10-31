package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GatewayPage {

     WebDriver driver;

    public GatewayPage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"email\"]")
     WebElement emailField;

    @FindBy(name = "cardNumber")
     WebElement cardNumber;

    @FindBy(name = "cardExpiry")
     WebElement cardExpiry;

    @FindBy(name = "cardCvc")
     WebElement cardCvc;

    @FindBy(name = "billingName")
     WebElement billingName;

    @FindBy(name = "billingCountry")
     WebElement billingCountry;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/main/div/form/div[1]/div/div/div[3]/div/div[3]/button/div[3]")
     WebElement payButton;

    @FindBy(xpath = "//*[@id=\"cardForm-fieldset\"]/div[1]/div[4]")
     WebElement cardNumberErr;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div")
     WebElement confirmation;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/header/div/div/a/div/div/div[2]/div/span")
    WebElement cancelButton;
    
    public void userEmail(String email) {
        emailField.sendKeys(email);
    }

    public void userCardNumber(String card) {
        cardNumber.sendKeys(card);
    }

    public void userCardExpiry(String date) {
        cardExpiry.sendKeys(date);
    }

    public void userCardCvc(String cvc) {
        cardCvc.sendKeys(cvc);
    }

    public void userName(String name) {
        billingName.sendKeys(name);
    }

    public void userBillingCountry(String country) {
        Select select = new Select(billingCountry);
        select.selectByVisibleText(country);
    }

    public void payButtonClick() {
        payButton.click();
    }

    public boolean getCardNumberErrorMessage() {
        return cardNumberErr.isDisplayed();
    }

    public boolean isConfirmationDisplayed() {
        return confirmation.isDisplayed();
    }
    
    public void cancelButtonClick () {
    	cancelButton.click();
    }
}
