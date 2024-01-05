package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferPage {

	private WebDriver driver;

	public OfferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='OfferAmount']")
	public WebElement amountElement;
	
	@FindBy(xpath = "//input[@id='OfferDuration']")
	public WebElement durationElement;
	
	@FindBy(xpath = "//input[@name='send']")
	public WebElement submitElement;
}


