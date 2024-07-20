package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.SeleniumUtils;

public class GoogleHomePage extends PageBase{
		private WebDriver driver;
		private String alertBox = "//mat-dialog-container[@id='mat-mdc-dialog-3']"; //"//div[@id='cdk-overlay-3']";
		private String notifContainer = "//div[@class='store-notification-top container-fluid']";
		private String closeBtn = "//div[@class='icon-close']";
		private String expectedUrl = "https://insurance.pos.com.my/";
		private String buyInsure = "//a[@href='https://insurance.pos.com.my']";
		private String driveCarButton ="//div[contains(text(),'I drive a car')]";
		private String rideMotorcycleButton="//div[@class='vehicleBox lblueBg mb-2 hover activeBtn']//div[2]";
		private String basefloatingCont= "//body/app-root/div[@class='main-content portal page-wrapper']/app-floating-bar/div[1]";
		private String floatingCont="//body/app-root/div[@class='main-content portal page-wrapper']/app-floating-bar/div[@class='base-container hidden-xs']/div[@class='outer-container']/div[@class='body-container']/div[@class='floating-bar']/div[@class='grid-container']/div[1]/a[1]";
		private String sendButn ="//body/app-root/div[@class='main-content portal page-wrapper']/app-floating-bar/div[@class='base-container hidden-xs']/div[@class='outer-container']/div[@class='body-container']/div[@class='floating-bar']/div[@class='grid-container']/div[1]/a[1]";
		//private String parcelSubMenu="//a[@class='title ng-star-inserted'][normalize-space()='Send']";
		/**
		 * Constructor of the page. Initialize the Page Factory objects.
		 * 
		 * @param driver
		 */
		public GoogleHomePage(WebDriver driver) {
			super(driver);
			this.driver = driver;
		}

		/**
		 * Performs a simple google search and return the next page.
		 * 
		 * @param query
		 */
		public void searchFor() {
		    try {
		        // Close notification container
		        WebElement notificationContainer = SeleniumUtils.findElement(driver, notifContainer);
		        notificationContainer.findElement(By.xpath("//span[@class='close-notification']")).click();

		        //Close alert box
		      WebElement alertBoxElement = SeleniumUtils.waitForElement(driver, alertBox);
		      alertBoxElement.findElement(By.xpath(closeBtn)).click();
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		    
		    public void buyInsure() {	        // Scroll to and click the "Buy Insure" button
		        WebElement buyInsureButton = SeleniumUtils.waitForElementToBeClickable(driver, buyInsure);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buyInsureButton);

		        try {
		            buyInsureButton.click();
		        } catch (Exception e) {
		            System.out.println("Click using WebDriver failed, attempting JavaScript click.");
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buyInsureButton);
		        }

		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		        // Switch to the new tab and verify the URL
		        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		        driver.switchTo().window(tabs.get(1));
		        String actualUrl = driver.getCurrentUrl();
		        System.out.println("Expected URL: " + expectedUrl);
		        System.out.println("Actual URL: " + actualUrl);
		        Assert.assertEquals(actualUrl, expectedUrl, "The URL of the new tab is incorrect.");
		        System.out.println("Test Passed: The URL is correct.");

		        // Click "I drive a car" button and verify visibility and enablement
		        WebElement driveCarButtonContainer = SeleniumUtils.findElement(driver, driveCarButton);
		        Assert.assertTrue(driveCarButtonContainer.isDisplayed(), "\"I drive a car\" button should be visible");
		        Assert.assertTrue(driveCarButtonContainer.isEnabled(), "\"I drive a car\" button should be enabled");
		        driveCarButtonContainer.click();

		        // Verify the "I ride a motorcycle" button
		        WebElement rideMotorcycleButtonContainer = SeleniumUtils.findElement(driver, rideMotorcycleButton);
		        Assert.assertTrue(rideMotorcycleButtonContainer.isDisplayed(), "\"I ride a motorcycle\" button should be visible");
		        Assert.assertTrue(rideMotorcycleButtonContainer.isEnabled(), "\"I ride a motorcycle\" button should be enabled");

		    }
		

		 
		
		@BeforeTest
		public void navigateBack() {
		driver.navigate().back();
		}
		@Test 
		public void testMenuClick() {
			try {
	//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.pos.com.my/");
			searchFor();
			//driver.navigate().back();
			/*// Debugging information
			System.out.println("Expected URL: " + expectedUrl);
			System.out.println("Actual URL: " + actualUrl);
			Assert.assertEquals(actualUrl, expectedUrl, "The URL of the new tab is incorrect.");*/

			//System.out.println("Test Passed: The URL is correct.");
		} catch (Exception e) {
			e.printStackTrace();
		} 
			WebElement basefloatingContainer = SeleniumUtils.findElement(driver, basefloatingCont);
			basefloatingContainer.findElement(By.xpath(sendButn)).click();
			//SeleniumUtils.findElement(driver, floatingCont).click();;
			// Find the "Send" menu item and click it
			 SeleniumUtils.waitForElementToBeClickable(driver,sendButn).click();
			//SeleniumUtils.waitForElement(driver, sendButn).click();
	 			 
			// Find the "Parcel" submenu item and click it
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//SeleniumUtils.waitForElement(driver, parcelSubMenu).click();
			
			return;
		}
	



}
