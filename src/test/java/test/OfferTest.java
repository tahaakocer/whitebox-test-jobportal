package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import component.AllJobsPage;
import component.HomePage;
import component.LoginPage;
import component.OfferPage;
import component.PostJobPage;
import component.ViewDetailsPage;
import utilities.BrowserFactory;
import utilities.DriverFactory;
import utilities.WaitMethods;

public class OfferTest {

	public static WebDriver driver;
	public static HomePage homePage;
	public static AllJobsPage allJobsPage;
	public static ViewDetailsPage viewDetailsPage;
	public static LoginPage loginPage;
	public static OfferPage offerPage;
	public static JavascriptExecutor js;
	private String usernameString;
	private String passwordString;

	@Before
	public void setup() {
		if (driver == null) {
			BrowserFactory browserFactory = new BrowserFactory();
			driver = DriverFactory.createDriver();
			System.out.println("test driver baslatildi. \n" + driver);
			driver.get("http://localhost:5041/Home");
			// DriverFactory.setimplicitlyWait(driver);
			System.out.println(driver.getTitle());
			js = (JavascriptExecutor) driver;

			usernameString = "sariyeyaman";
			passwordString = "Password123.";

		}
	}

	@Test
	public void test() {

		homePage = new HomePage(driver);
		homePage.searchInputElement.sendKeys("Ata");
		homePage.searchButtonElement.click();
		WaitMethods.waitForPageToLoad(driver, 10);

		WaitMethods.bekle(3);
		allJobsPage = new AllJobsPage(driver);
		js.executeScript("arguments[0].click()", allJobsPage.viewDetailsElement);

		viewDetailsPage = new ViewDetailsPage(driver);

		if (!driver.findElements(By.xpath("//a[normalize-space()='log in now']")).isEmpty()) {
			WebElement element = driver.findElement(By.xpath("//a[normalize-space()='log in now']"));
			js.executeScript("arguments[0].click()", element);
			WaitMethods.waitForPageToLoad(driver, 10);
			loginPage = new LoginPage(driver);
			loginPage.nicknameElement.sendKeys(usernameString);
			loginPage.passwordElement.sendKeys(passwordString);
			loginPage.submitElement.click();
			WaitMethods.bekle(1);

			homePage = new HomePage(driver);
			homePage.searchInputElement.sendKeys("Ata");
			homePage.searchButtonElement.click();
			WaitMethods.waitForPageToLoad(driver, 10);

			WaitMethods.bekle(3);
			allJobsPage = new AllJobsPage(driver);
			js.executeScript("arguments[0].click()", allJobsPage.viewDetailsElement);

			viewDetailsPage = new ViewDetailsPage(driver);

		}

		WaitMethods.bekle(3);
		js.executeScript("arguments[0].click()", viewDetailsPage.offerElement);
		WaitMethods.waitForPageToLoad(driver, 10);

		WaitMethods.bekle(3);
		offerPage = new OfferPage(driver);
		offerPage.amountElement.sendKeys("2000");
		offerPage.durationElement.sendKeys("2");
		offerPage.submitElement.click();
		WaitMethods.waitForPageToLoad(driver, 10);

		System.out.println("Offer Test Completed.");

	}

	@After
	public void tearDown() {
		DriverFactory.closeDriver(driver);
		System.out.println("test driver durduruldu.");
	}

}
