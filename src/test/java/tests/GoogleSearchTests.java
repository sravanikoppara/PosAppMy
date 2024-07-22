package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import enums.Browser;
import factory.BrowserProvider;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
import pages.GoogleHomePage;

public class GoogleSearchTests {
	private WebDriver driver;

	/**
	 * This method will be executed before the test start.
	 */
	@BeforeSuite
	public void initalize() {
		driver = BrowserProvider.createDriver(Browser.CHROME);
		driver.manage().window().maximize();
		//driver.get("https://www.pos.com.my/");
		
	}
/*	@BeforeTest
	public void launch() {
    driver.get("https://www.pos.com.my/");
		// Initialize the GoogleHomePage object
		//GoogleHomePage googleHomePage = new GoogleHomePage(driver);	
	}*/
	/**
	 * This method perform a google search test. We can have multiple @Test methods inside this class.
	 */
	@Test
	public void posOffersBuyInsurance() {

		GoogleHomePage googleHomePage = new GoogleHomePage(driver);
		driver.get("https://www.pos.com.my/");
		googleHomePage.searchFor();	
		googleHomePage.buyInsure();
		
	}
	
	@Test (dependsOnMethods = "posOffersBuyInsurance") 
	public void createShipment() {
		GoogleHomePage googleHomePage = new GoogleHomePage(driver);
		googleHomePage.testMenuClick();	
	
	}
	/**
	 * This method will be executed at the end of the test.
	 */
	@AfterSuite
	public void quitDriver() {
				if(driver != null) {
				driver.quit();
				}

	}
}
