package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import component.HomePage;
import component.LoginPage;
import component.PostJobPage;
import utilities.BrowserFactory;
import utilities.DriverFactory;
import utilities.WaitMethods;

public class PostJobTest {

	public static WebDriver driver;
	public static HomePage homePage;
	public static LoginPage loginPage;
	public static PostJobPage postJobPage;
	public static JavascriptExecutor js;
	
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
			
			
		}	
	}
	@Test
	public void test() {
		
		homePage = new HomePage(driver);
 		homePage.postJobElement.click();
 		
 		WaitMethods.waitForPageToLoad(driver, 10);
 		postJobPage = new PostJobPage(driver);
 		
 		postJobPage.companyElement.sendKeys("ATADEM");
 		postJobPage.jobTitleElement.sendKeys("Yorum Yap");
 		postJobPage.locationElement.sendKeys("Youtube");
 		postJobPage.educationElement.sendKeys("İlkokul+");
 		postJobPage.experiencElement.sendKeys("gerek yok");
 		postJobPage.shiftTypElement.sendKeys("day");
 		postJobPage.numberofVacaniesElement.sendKeys("150");
 		postJobPage.requirementsElement.sendKeys("Akıllı cihaz ve internet");
 		postJobPage.skillsElement.sendKeys("yeteneğe gerek yok");
 		postJobPage.salaryElement.sendKeys("150");
 		postJobPage.descriptionElement.sendKeys(
 				"https://www.youtube.com/watch?v=A_Sfru99QNA"
 				+ " Bu linke tıkla ve yorum yap.");
 		WaitMethods.bekle(4);
 		postJobPage.submitElement.click();
 		js.executeScript("argument[0].click()", postJobPage.submitElement);
 		WaitMethods.waitForPageToLoad(driver, 10);
 		
 		System.out.println("Post Job Test Completed.");
 		
 		homePage.logoutElement.click();
 		
 		System.out.println("logout");
 		
 	
	}
	
	@After
	public void tearDown() {
		DriverFactory.closeDriver(driver);
		System.out.println("test driver durduruldu.");
	}

}
