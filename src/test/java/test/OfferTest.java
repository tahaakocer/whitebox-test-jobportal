package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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
	public static OfferPage offerPage;
	public static JavascriptExecutor js;

	@Before
	public void setup() {
		if (driver == null) {
			BrowserFactory browserFactory = new BrowserFactory();
			driver = DriverFactory.createDriver();
			System.out.println("test driver baslatildi. \n" + driver);
			// driver.get("https://www.reddit.com/r/movies/comments/155ag1m/official_discussion_oppenheimer_spoilers/");
			DriverFactory.setimplicitlyWait(driver);
			System.out.println(driver.getTitle());
			js = (JavascriptExecutor) driver;

		}
	}
	
	@Test
	public void test() {
		
		homePage = new HomePage(driver);
		homePage.searchInputElement.sendKeys("Ata");
		homePage.searchButtonElement.click();
		WaitMethods.waitForPageToLoad(driver, 10);
		
		allJobsPage = new AllJobsPage(driver);
		allJobsPage.viewDetailsElement.click();
		WaitMethods.waitForPageToLoad(driver, 10);
		
		viewDetailsPage = new ViewDetailsPage(driver);
		viewDetailsPage.offerElement.click();
		WaitMethods.waitForPageToLoad(driver, 10);
		
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
