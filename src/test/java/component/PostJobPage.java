package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostJobPage {
private WebDriver driver;
	

	public PostJobPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}	
	

	@FindBy(xpath = "//input[@id='CompanyName']")
	public WebElement companyElement;
	
	@FindBy(xpath = "//input[@id='JobTitle']")
	public WebElement jobTitleElement;
	
	@FindBy(xpath = "//input[@id='Location']")
	public WebElement locationElement;
	
	@FindBy(xpath = "//input[@id='Education']")
	public WebElement educationElement;
	
	@FindBy(xpath = "//input[@id='Experience']")
	public WebElement experiencElement;
	
	@FindBy(xpath = "//input[@id='ShiftType']")
	public WebElement shiftTypElement;
	
	@FindBy(xpath = "//input[@id='NumberOfVacancies']")
	public WebElement numberofVacaniesElement;
	
	@FindBy(xpath = "//input[@id='Requirements']")
	public WebElement requirementsElement;
	
	@FindBy(xpath = "//input[@id='Skills']")
	public WebElement skillsElement;
	
	@FindBy(xpath = "//input[@id='SalaryRange']")
	public WebElement salaryElement;
	
	@FindBy(xpath = "//textarea[@id='Description']")
	public WebElement descriptionElement;
	
	@FindBy(xpath = "//input[@name='send']")
	public WebElement submitElement;
}
