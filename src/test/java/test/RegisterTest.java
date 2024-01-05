package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.StringHolder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import component.HomePage;
import component.LoginPage;
import component.RegisterPage;
import utilities.BrowserFactory;
import utilities.DriverFactory;
import utilities.WaitMethods;

public class RegisterTest {

	public static WebDriver driver;
	public static HomePage homePage;
	public static LoginPage loginPage;
	public static RegisterPage registerPage;
	private JavascriptExecutor js;
	private String usernameString;
	private String emailString;
	private String passwordString;

	@Before
	public void setup() {
		if (driver == null) {
			BrowserFactory browserFactory = new BrowserFactory();
			driver = DriverFactory.createDriver();
			System.out.println("test driver baslatildi. \n" + driver);
			driver.get("http://localhost:5041/Home");
			DriverFactory.setimplicitlyWait(driver);
			System.out.println(driver.getTitle());
			js = (JavascriptExecutor) driver;
			
			usernameString = "sariyeyaman";
			emailString = "deneme@gmail.com";
			passwordString = "Password123.";
		
		}
	}

	@Test
	public void test() {
		homePage = new HomePage(driver);
 		homePage.loginElement.click();
 		
 		WaitMethods.waitForPageToLoad(driver, 10);
 		loginPage = new LoginPage(driver);
 		loginPage.registerElement.click();
 		
 		WaitMethods.waitForPageToLoad(driver, 10);
 		registerPage = new RegisterPage(driver);
 		registerPage.selectElement.click();
 		registerPage.userElement.click();
 		registerPage.usernameElement.sendKeys(usernameString);
 		registerPage.emailElement.sendKeys(emailString);
 		registerPage.passwordElement.sendKeys(passwordString);
 		registerPage.submitElement.click();
 		WaitMethods.bekle(1);
 		
 		System.out.println("Register Test Completed.");
	}

	@After
	public void tearDown() {
		DriverFactory.closeDriver(driver);
		System.out.println("test driver durduruldu.");
	}
}
