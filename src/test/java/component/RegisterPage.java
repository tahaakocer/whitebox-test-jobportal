package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	private WebDriver driver;
	

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(xpath = "//select[@id='Role']")
	public WebElement selectElement;
	
	@FindBy(xpath = "//option[@value='Employer']")
	public WebElement employerElement;
	
	@FindBy(xpath = "//option[@value='User']")
	public WebElement userElement;

	@FindBy(xpath = "//input[@id='UserName']")
	public WebElement usernameElement;
	
	@FindBy(xpath = "//input[@id='Email']")
	public WebElement emailElement;
	
	@FindBy(xpath = "//input[@id='Password']")
	public WebElement passwordElement;
	
	@FindBy(xpath = "//input[@name='submit']")
	public WebElement submitElement;
}
