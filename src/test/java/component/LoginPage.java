package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(xpath = "//input[@id='Name']")
	public WebElement nicknameElement;
	
	@FindBy(xpath = "//input[@id='Password']")
	public WebElement passwordElement;
	
	@FindBy(xpath = "//input[@name='submit']")
	public WebElement submitElement;
	
	@FindBy(xpath = "//a[normalize-space()='register now']")
	public WebElement registerElement;
}
