package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
	
	WebDriver driver;

	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div[1]/div/button[1]")
	WebElement size;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[1]/button[3]")
	WebElement quantity;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[2]/button")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/p")
	WebElement message;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/button")
	WebElement CartBtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/div")
	WebElement Cart;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/button")
	WebElement RemoveBtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/button")
	WebElement CheckoutBtn;
	
	
	//Methods
	public void chooseSize () {
		size.click();
	}
	
	public void chooseQuantity () {
		quantity.click();
	}
	
	public void addToCartClick () {
		addToCartBtn.click();
	}
	
	public void cartBtnClick() {
		CartBtn.click();
	}
	
	public void removeItem () {
		RemoveBtn.click();
	}
	
	public void checkoutBtnClick () {
		CheckoutBtn.click();
	}
	
	public String getMessage () {
		return message.getText();
	}
}
