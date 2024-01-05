package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import component.HomePage;
import utilities.BrowserFactory;
import utilities.DriverFactory;

public class RegisterTest {

	public static WebDriver driver;
	public static HomePage homePage;
	private JavascriptExecutor js;

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
	}

	@After
	public void tearDown() {
		DriverFactory.closeDriver(driver);
		System.out.println("test driver durduruldu.");
	}
}
