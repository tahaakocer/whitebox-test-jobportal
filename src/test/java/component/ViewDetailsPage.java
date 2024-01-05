package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewDetailsPage {

	private WebDriver driver;

	public ViewDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='offer']")
	public WebElement offerElement;
	
	@FindBy(xpath = "//input[@value='apply now']")
	public WebElement applyElement;
}
