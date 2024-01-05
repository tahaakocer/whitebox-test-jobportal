package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import component.HomePage;
import component.LoginPage;
import utilities.BrowserFactory;
import utilities.DriverFactory;
import utilities.WaitMethods;

public class LoginTest {

	public static WebDriver driver;
	public static HomePage homePage;
	public static LoginPage loginPage;
	private JavascriptExecutor js;
	private String usernameString;
	private String passwordString;


	@Before
	public void setup() {
		if(driver == null) {
			BrowserFactory browserFactory = new BrowserFactory();
			driver = DriverFactory.createDriver();
			System.out.println("test driver baslatildi. \n" + driver);
		//	driver.get("https://www.reddit.com/r/movies/comments/155ag1m/official_discussion_oppenheimer_spoilers/");
			DriverFactory.setimplicitlyWait(driver);
			System.out.println(driver.getTitle());
			js = (JavascriptExecutor) driver;
			
			usernameString = "sariyeyaman";
			passwordString = "Password123.";
		}	
	}

	@Test
	public void test() {
		
		homePage = new HomePage(driver);
 		homePage.loginElement.click();
 	
 		WaitMethods.waitForPageToLoad(driver, 10);
 		loginPage = new LoginPage(driver);
 		loginPage.nicknameElement.sendKeys(usernameString);
 		loginPage.passwordElement.sendKeys(passwordString);
 		loginPage.submitElement.click();
 		WaitMethods.bekle(1);
	}
	
	@After
	public void tearDown() {
		DriverFactory.closeDriver(driver);
		System.out.println("test driver durduruldu.");
	}

}
