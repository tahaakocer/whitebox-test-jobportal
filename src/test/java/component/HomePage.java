package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	public WebElement loginElement;
	
	@FindBy(xpath = "//a[normalize-space()='Post Job']")
	public WebElement postJobElement;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	public WebElement logoutElement;
	
	@FindBy(xpath = "//input[@placeholder='keyword, company or location']")
	public WebElement searchInputElement;
	
	@FindBy(xpath = "//button[normalize-space()='Search Job']")
	public WebElement searchButtonElement;
}


